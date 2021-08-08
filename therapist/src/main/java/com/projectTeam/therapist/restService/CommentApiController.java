package com.projectTeam.therapist.restService;

import com.projectTeam.therapist.model.CommentCategory;
import com.projectTeam.therapist.model.CommentDto;
import com.projectTeam.therapist.model.PostCommentDto;
import com.projectTeam.therapist.postService.CommentService;
import com.projectTeam.therapist.repository.CommentRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class CommentApiController {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PostComment에 관한 API
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private CommentService commentService;

    // 모든 게시글 댓글(PostComment) 조회
    @GetMapping("/postComments")
    List<PostCommentDto> findAllPostComments() {
        return commentService.findAllPostComments();
    }

    // 게시글 댓글(PostComment)의 아이디에 해당하는 게시글 댓글 조회
    @GetMapping("/postComments/{postCommentId}")
    PostCommentDto findSinglePostComment(@PathVariable Long postCommentId) {
        return commentService.findSinglePostComment(postCommentId);
    }

    // 게시글 댓글(PostComment) 생성
    @PostMapping("/postComments/{userName}/{postId}")
    PostCommentDto newPostComment(@RequestBody JSONObject params, @PathVariable String userName, @PathVariable Long postId) {
        return commentService.newPostComment(params, userName, postId);
    }

    // 게시글 댓글(PostComment) 삭제
    @DeleteMapping("/postComments/{postCommentId}")
    void deletePostComment(@PathVariable Long postCommentId) {
        commentService.deletePostComment(postCommentId);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ReplyComment에 관한 API
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}