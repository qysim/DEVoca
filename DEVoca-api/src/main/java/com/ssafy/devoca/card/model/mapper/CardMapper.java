package com.ssafy.devoca.card.model.mapper;

import com.ssafy.devoca.card.model.CardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CardMapper {
    public void registerCard(CardDTO cardDTO) throws SQLException;

    CardDTO getCardDetail(int cardId) throws SQLException;

    List<CardDTO> getCardList(@Param("scroll") int scroll, @Param("userId") String userId)
            throws SQLException;
}
