package com.ssafy.devoca.user.model.mapper;

import com.ssafy.devoca.user.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface UserMapper {

    int userIdxLoad(String userId) throws SQLException;
    int checkUser(long id) throws SQLException;
    void joinUser(UserDTO userDTO) throws SQLException;
    UserDTO getUserInfo(int userIdx) throws SQLException;
    void updateUserInfo(UserDTO userDTO) throws SQLException;
    void setFavCategory(Map<String, Object> params) throws SQLException;
}
