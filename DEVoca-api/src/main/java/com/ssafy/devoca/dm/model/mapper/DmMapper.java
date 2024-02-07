package com.ssafy.devoca.dm.model.mapper;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.dm.model.DmRoomDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface DmMapper {
    public List<DmRoomDTO> getDmRoomList(int loginUserIdx) throws SQLException;

    public List<DmDTO> getDmList(@Param("roomUuid") String roomUuid, @Param("scroll") int scroll) throws SQLException;

    public Boolean getParticipantsYN(@Param("roomUuid") String roomUuid, @Param("loginUserIdx") int loginUserIdx) throws SQLException;
}