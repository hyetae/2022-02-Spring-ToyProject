package com.jojoldu.book.freelecspringboot2webservice.domain.comments;

import com.jojoldu.book.freelecspringboot2webservice.domain.BaseTimeEntity;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @Column(columnDefinition = "TEXT", length = 300, nullable = false)
    private String comment;
    //private String author;

    @Builder
    public Comments(String comment, Posts posts) {
        this.comment = comment;
        //this.author = author;
        this.posts = posts;
    }
}
