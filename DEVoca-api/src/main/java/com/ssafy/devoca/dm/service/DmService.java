package com.ssafy.devoca.dm.service;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.dm.model.DmRoomDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DmService {
    public List<DmRoomDTO> getDmRoomList(int loginUserIdx) throws Exception;
    public List<DmDTO> getDmList(@Param("roomUuid") String roomUuid, @Param("scroll") int scroll) throws Exception;
    public Boolean getParticipantsYN(@Param("roomUuid") String roomUuid, @Param("loginUserIdx") int loginUserIdx) throws Exception;
    public String getRoomUuid(@Param("loginUserIdx") int loginUserIdx, @Param("chatUserIdx") int chatUserIdx) throws Exception;
    public int createRoom(@Param("roomUuid") String roomUuid) throws Exception;
    public void insertParticipants(@Param("roomUuid") String roomUuid, @Param("loginUserIdx") int loginUserIdx, @Param("chatUserIdx") int chatUserIdx) throws Exception;
}