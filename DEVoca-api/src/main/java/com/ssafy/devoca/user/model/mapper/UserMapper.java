package com.ssafy.devoca.user.model.mapper;

import com.ssafy.devoca.user.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

@Mapper
public interface UserMapper {

    int userIdxLoad(String userId) throws SQLException;
    int checkUser(long id) throws SQLException;
    void joinUser(UserDTO userDTO) throws SQLException;
    UserDTO getUserInfo(int userIdx) throws SQLException;
}
