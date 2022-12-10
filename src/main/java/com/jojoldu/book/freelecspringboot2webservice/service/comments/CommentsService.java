package com.jojoldu.book.freelecspringboot2webservice.service.comments;

import com.jojoldu.book.freelecspringboot2webservice.domain.comments.Comments;
import com.jojoldu.book.freelecspringboot2webservice.domain.comments.CommentsRepository;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.PostsRepository;
//import com.jojoldu.book.freelecspringboot2webservice.web.dto.CommentsListResponseDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.CommentsListResponseDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.CommentsResponseDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.CommentsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(Long id, CommentsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        requestDto.setPosts(posts);
        return commentsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public CommentsResponseDto findById(Long id) {
        Comments entity = commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return new CommentsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CommentsListResponseDto> findAllDesc() {
        return commentsRepository.findAllDesc().stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        commentsRepository.delete(comments);
    }
}