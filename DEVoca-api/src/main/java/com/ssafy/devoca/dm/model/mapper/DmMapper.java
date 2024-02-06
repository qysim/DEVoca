package com.ssafy.devoca.dm.model.mapper;

import com.ssafy.devoca.dm.model.DmRoomDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface DmMapper {
    public List<DmRoomDTO> getDmRoomList(int loginUserIdx) throws SQLException;
}