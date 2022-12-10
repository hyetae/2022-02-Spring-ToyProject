package com.jojoldu.book.freelecspringboot2webservice.domain.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Query("SELECT c FROM Comments c WHERE c.posts.id = :id ORDER BY c.id DESC")
    List<Comments> findAllDesc();
}
