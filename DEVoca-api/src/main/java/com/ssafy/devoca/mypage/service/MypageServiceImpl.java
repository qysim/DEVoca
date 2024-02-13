package com.ssafy.devoca.mypage.service;

import com.ssafy.devoca.mypage.model.mapper.MypageMapper;
import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.model.mapper.UserMapper;
import com.ssafy.devoca.user.service.UserService;
import com.ssafy.devoca.util.JwtUtil;
import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MypageServiceImpl implements MypageService {

    private final MypageMapper mypageMapper;

    @Value("${minio.host}")
    private String MINIO_HOST;

    @Value("${minio.user}")
    private String MINIO_USER;

    @Value("${minio.user.password}")
    private String MINIO_USER_PASSWORD;

    @Override
    public List<BadgeDTO> getUserBadges(int userIdx) throws Exception {
        return mypageMapper.getUserBadges(userIdx);
    }

    @Override
    public void followUser(int userIdx, int followIdx) throws Exception {
        mypageMapper.followUser(userIdx, followIdx);
    }

    @Override
    public void unfollowUser(int userIdx, int followIdx) throws Exception {
        mypageMapper.unfollowUser(userIdx, followIdx);
    }

    @Override
    public List<UserDTO> getFollowList(int userIdx) throws Exception {
        return mypageMapper.getFollowList(userIdx);
    }

    @Override
    public List<UserDTO> getFollowingList(int userIdx) throws Exception {
        return mypageMapper.getFollowingList(userIdx);
    }

    @Override
    public List<UserDTO> recommendFollow(int userIdx) throws Exception {
        return mypageMapper.recommendFollow(userIdx);
    }

    @Override
    @Transactional
    public String uploadProfileImg(MultipartFile image, int userIdx) throws Exception {

        // 파일 정보
        String originFileName = image.getOriginalFilename();
        String extName
                = originFileName.substring(originFileName.lastIndexOf("."), originFileName.length());
        Long size = image.getSize();
        String type = image.getContentType();
        log.info("type : {}" , type);

        // 저장할 이름
        String saveFileName = getSaveFileName(extName, userIdx);
        InputStream stream = image.getInputStream();

        // minio로 업로드
        String bucketName = "devoca";
        putObjectMinio(bucketName, saveFileName, stream, size, type);
        log.info("minio로 업로드 완료 bucket : {}, fileName : {}", bucketName, saveFileName);
        return getImageUrl(saveFileName, bucketName, userIdx);
    }

    @Override
    public String getImageUrl(String objectName, String bucket, int userIdx) throws Exception {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(MINIO_HOST)
                        .credentials(MINIO_USER, MINIO_USER_PASSWORD)
                        .build();

        String url = minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket("devoca")
                        .object(objectName)
                        .build()
        );

        saveImageUrl(url, userIdx);
        return url;
    }

    private void saveImageUrl(String url, int userIdx) {
        mypageMapper.saveImageUrl(url, userIdx);
    }


    private String getSaveFileName(String extName, int userIdx) {
        String filename = "";

        Calendar calendar = Calendar.getInstance();
        filename += userIdx;
        filename += calendar.get(Calendar.YEAR);
        filename += calendar.get(Calendar.MONTH);
        filename += calendar.get(Calendar.DATE);
        filename += calendar.get(Calendar.HOUR);
        filename += calendar.get(Calendar.MINUTE);
        filename += calendar.get(Calendar.SECOND);
        filename += calendar.get(Calendar.MILLISECOND);
        filename += extName;

        return filename;
    }

    private void putObjectMinio(String bucket, String objectName, InputStream stream, long size, String type){
        log.info("minio putObjectMinio ::: {}", stream);
        try{
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(MINIO_HOST)
                            .credentials(MINIO_USER, MINIO_USER_PASSWORD)
                            .build();

//            log.info("checking bucket");
//            boolean checkBucket = minioClient.bucketExists(
//                    BucketExistsArgs.builder().bucket(bucket).build());
//            if(checkBucket){
//                log.info("devoca exists");
//            } else {
//                log.info("devoca does not exists");
//            }

            log.info("uploading image type :: {}", type);
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucket).object(objectName)
                            .stream(stream, size, -1)
                            .contentType(type).build()
            );
        } catch (Exception e){
            log.info("putObject error ::: {}", e);
        }
    }
    @Override
    public String getObjectName(int userIdx) throws Exception {
        return mypageMapper.getObjectName(userIdx);
    }
}
