package com.ssafy.devoca.card.model.mapper;

import com.ssafy.devoca.card.model.CardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CardMapper {
    public void registerCard(CardDTO cardDTO) throws SQLException;

    void updateCard(CardDTO cardDTO) throws SQLException;

    void deleteCard(int cardId) throws SQLException;

    public CardDTO getCardDetail(int cardId) throws SQLException;

    public List<CardDTO> getCardList(@Param("scroll") int scroll, @Param("loginUserId") String loginUserId)
            throws SQLException;

    List<CardDTO> getCardListByWord
            (@Param("wordId") int wordId, @Param("scroll") int scroll, @Param("loginUserId") String loginUserId)
            throws SQLException;

    List<CardDTO> getCardListByUserId
            (@Param("userId") String userId, @Param("scroll") int scroll, @Param("loginUserId") String loginUserId)
            throws SQLException;

    public void repostCard(CardDTO cardDTO) throws SQLException;
    public void repostCntUpdate(int originCardId) throws SQLException;

}
