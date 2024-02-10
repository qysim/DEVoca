package com.ssafy.devoca.comment.controller;

import com.ssafy.devoca.comment.model.CommentDTO;
import com.ssafy.devoca.comment.service.CommentService;
import com.ssafy.devoca.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    private final UserService userService;

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

    /**
     * 댓글 작성
     *
     * @param map flag, cardBoardId, commentContent를 map으로 받아온다.
     * @return HttpStatus.CREATED
     */
    @PostMapping("")
    public ResponseEntity<String> registComment(@RequestBody Map<String, Object> map) {
        log.info("registComment 호출 : {}", map);

        try {
            // 작성자 id 가져오기
            String userId = "aabbc";
            int userIdx = userService.loadUserIdx(userId);

            map.put("userIdx", userIdx);

            commentService.registComment(map);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("registComment 댓글 등록 실패 : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
