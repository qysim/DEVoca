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

import java.io.InputStream;
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
    public void uploadProfileImg(String imgname, InputStream stream) throws Exception {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(MINIO_HOST)
                        .credentials(MINIO_USER, MINIO_USER_PASSWORD)
                        .build();
        // bucket 있는지 확인
        boolean checkBucket = minioClient.bucketExists(BucketExistsArgs.builder().bucket("devoca").build());
        if(checkBucket){
            log.info("devoca exists");
        } else {
            log.info("devoca does not exists");
        }

        // 이미지 업로드
        minioClient.putObject(
                PutObjectArgs.builder().bucket("devoca").object(imgname)
                        .stream(stream, -1, 10485760)
                        .contentType("image/jpeg").build()
        );
    }


}
