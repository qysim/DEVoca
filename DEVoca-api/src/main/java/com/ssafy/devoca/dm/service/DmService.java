package com.ssafy.devoca.dm.service;

import com.ssafy.devoca.dm.model.DmRoomDTO;

import java.util.List;

public interface DmService {
    public List<DmRoomDTO> getDmRoomList(int loginUserIdx) throws Exception;
}