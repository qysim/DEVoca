package com.ssafy.devoca.notify.model.mapper;

import com.ssafy.devoca.notify.model.NotifyDTO;

import java.sql.SQLException;

public interface NotifyMapper {
    public void saveNotify(NotifyDTO notifyDTO) throws SQLException;
}
