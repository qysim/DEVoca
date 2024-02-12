package com.ssafy.devoca.mypage.service;

import com.ssafy.devoca.mypage.model.mapper.MypageMapper;
import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.FavCategoryDTO;
import com.ssafy.devoca.user.model.UserDTO;
import com.ssafy.devoca.user.model.mapper.UserMapper;
import com.ssafy.devoca.user.service.UserService;
import com.ssafy.devoca.util.JwtUtil;
import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    public String uploadProfileImg(MultipartFile image) throws Exception {
        String url = null;

        // 파일 정보
        String originFileName = image.getOriginalFilename();
        String extName
                = originFileName.substring(originFileName.lastIndexOf("."), originFileName.length());
        Long size = image.getSize();

        // 저장할 이름
        String saveFileName = getSaveFileName(extName);
        InputStream stream = image.getInputStream();
        // minio로 업로드
        putObjectMinio("devoce", saveFileName, stream);
        log.info("minio로 업로드 saveFileName : {}", saveFileName);
        url += saveFileName;
        return url;
    }

    private String getSaveFileName(String extName) {
        String filename = "";

        Calendar calendar = Calendar.getInstance();
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

    private void putObjectMinio(String bucket, String objectName, InputStream stream){
        log.info("minio putObjectMinio ::: {}", bucket);
        try{
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(MINIO_HOST)
                            .credentials(MINIO_USER, MINIO_USER_PASSWORD)
                            .build();

            log.info("checking bucket");
//            boolean checkBucket = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
//            if(checkBucket){
//                log.info("devoca exists");
//            } else {
//                log.info("devoca does not exists");
//            }

            log.info("uploading image");
            minioClient.putObject(
                    PutObjectArgs.builder().bucket("devoca").object(objectName)
                            .stream(stream, -1, 10485760)
                            .contentType("image/jpeg").build()
            );

        } catch (Exception e){
            log.info("putObject error ::: {}", e);
        }
    }
}
