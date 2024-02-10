package com.ssafy.devoca.comment.controller;

import com.ssafy.devoca.comment.model.CommentDTO;
import com.ssafy.devoca.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Comment 관련 Controller
 *
 * @author kimjuyi
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    /**
     * Card나 Board의 상세 페이지에서 댓글 조회
     *
     * @param flag card or board
     * @param cardBoardId cardId or boardId
     * @return CommentList
     */
    @GetMapping("/{flag}/{cardBoardId}")
    public ResponseEntity<List<CommentDTO>> getCommentList(@PathVariable("flag") String flag, @PathVariable("cardBoardId") int cardBoardId) {
        log.info("getCommentList 호출 : {} {}", flag, cardBoardId);

        try {
            List<CommentDTO> commentList = commentService.getCommentList(flag, cardBoardId);
            return ResponseEntity.status(HttpStatus.OK).body(commentList);
        } catch (Exception e) {
            log.error("getCommentList 조회 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
