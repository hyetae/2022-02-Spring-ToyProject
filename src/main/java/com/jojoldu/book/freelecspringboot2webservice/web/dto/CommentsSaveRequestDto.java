package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.domain.comments.Comments;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.domain.user.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private String comment;
    //private String author;
    private Posts posts;

    @Builder
    public CommentsSaveRequestDto(String comment, Posts posts) {
        this.comment = comment;
        //this.author = author;
        this.posts = posts;
    }

    public Comments toEntity() {
        return Comments.builder()
                .comment(comment)
                //.author(author)
                .posts(posts)
                .build();
    }
}
