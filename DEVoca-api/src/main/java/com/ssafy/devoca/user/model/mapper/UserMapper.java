package com.ssafy.devoca.user.model.mapper;

import com.ssafy.devoca.user.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {

    int checkUser(long id) throws SQLException;

    void joinUser(UserDTO userDTO);
}
