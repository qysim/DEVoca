package com.ssafy.devoca.user.model.mapper;

import com.ssafy.devoca.user.model.BadgeDTO;
import com.ssafy.devoca.user.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    int loadUserIdx(String userId) throws SQLException;
    int checkUser(long id) throws SQLException;
    void joinUser(UserDTO userDTO) throws SQLException;
    UserDTO getUserInfo(int userIdx) throws SQLException;
    void updateUserInfo(UserDTO userDTO) throws SQLException;
    void delFavCategory(int userIdx) throws SQLException;
    void setFavCategory(Map<String, Object> params) throws SQLException;
    List<Integer> getFavCategory(int userIdx) throws SQLException;
    List<BadgeDTO> getUserBadges(int userIdx) throws SQLException;
}
