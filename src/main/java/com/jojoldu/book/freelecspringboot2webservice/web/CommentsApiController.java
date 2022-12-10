package com.jojoldu.book.freelecspringboot2webservice.web;

import com.jojoldu.book.freelecspringboot2webservice.domain.comments.Comments;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.service.comments.CommentsService;
import com.jojoldu.book.freelecspringboot2webservice.service.posts.PostsService;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class CommentsApiController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/{id}/comments")
    public Long save(@PathVariable Long id, @RequestBody CommentsSaveRequestDto requestDto) {
        return commentsService.save(id, requestDto);
    }


    @GetMapping("/{pid}/comments")
    public CommentsResponseDto findById(@PathVariable Long pid) {
        return commentsService.findById(pid);
    }

    /*@GetMapping("/{pid}/comments")
    public List<CommentsListResponseDto> getCommentsList(@PathVariable Long pid){
        return commentsService.findAllDesc();
    }*/

    @DeleteMapping("/{pid}/comments/{id}")
    public Long delete(@PathVariable Long pid, @PathVariable Long id) {
        commentsService.delete(id);
        return id;
    }

    // 댓글 조회
    //List<CommentsListResponseDto> getCommentsList = commentsService.findAllDesc();
    //model.addAttribute("comment", getCommentsList);

    // 댓글 삭제
    //commentsService.delete(cno);
}
