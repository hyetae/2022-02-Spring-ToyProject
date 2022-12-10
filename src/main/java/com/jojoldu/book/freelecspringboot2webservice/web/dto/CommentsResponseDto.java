package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.domain.comments.Comments;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsResponseDto {
    private Long id;
    private Long postId;
    private String comment;
    //private String author;

    public CommentsResponseDto(Comments entity) {
        this.id = entity.getId();
        this.postId = entity.getPosts().getId();
        this.comment = entity.getComment();
        //this.author = entity.getAuthor();
    }
}
