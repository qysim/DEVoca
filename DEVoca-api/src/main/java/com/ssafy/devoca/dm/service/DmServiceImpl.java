package com.ssafy.devoca.dm.service;

import com.ssafy.devoca.dm.model.DmDTO;
import com.ssafy.devoca.dm.model.DmRoomDTO;
import com.ssafy.devoca.dm.model.mapper.DmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmServiceImpl implements DmService {

    private final DmMapper dmMapper;

    // DM 채팅방 리스트 조회
    @Override
    public List<DmRoomDTO> getDmRoomList(int loginUserIdx) throws Exception {
        return dmMapper.getDmRoomList(loginUserIdx);
    }

    // DM 채팅 내역 조회
    @Override
    public List<DmDTO> getDmList(String roomUuid, int scroll) throws Exception {
        return dmMapper.getDmList(roomUuid, scroll * 10);
    }

    // DM 채팅방 참여자인지 확인
    @Override
    public Boolean getParticipantsYN(String roomUuid, int loginUserIdx) throws Exception {
        return dmMapper.getParticipantsYN(roomUuid, loginUserIdx);
    }
}