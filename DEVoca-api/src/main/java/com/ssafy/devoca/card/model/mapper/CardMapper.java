package com.ssafy.devoca.card.model.mapper;

import com.ssafy.devoca.card.model.CardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface CardMapper {
    public void registerCard(CardDTO cardDTO) throws SQLException;
}
