package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.domain.comments.Comments;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class CommentsListResponseDto {
    private Long id;
    private String comment;

    public CommentsListResponseDto(Comments entity) {
        this.id = entity.getId();
        this.comment = entity.getComment();
    }
}
