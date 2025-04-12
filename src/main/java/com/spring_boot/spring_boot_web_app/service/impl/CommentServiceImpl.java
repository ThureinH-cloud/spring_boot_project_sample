package com.spring_boot.spring_boot_web_app.service.impl;

import com.spring_boot.spring_boot_web_app.dto.CommentDto;
import com.spring_boot.spring_boot_web_app.entity.Comment;
import com.spring_boot.spring_boot_web_app.entity.Post;
import com.spring_boot.spring_boot_web_app.mapper.CommentMapper;
import com.spring_boot.spring_boot_web_app.repository.CommentRepository;
import com.spring_boot.spring_boot_web_app.repository.PostRepository;
import com.spring_boot.spring_boot_web_app.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository=postRepository;
    }
    @Override
    public void createComment(String postUrl, CommentDto commentDto) {
        Post post=postRepository.findByUrl(postUrl).orElseThrow(()->new EntityNotFoundException("No posts found"));
        Comment comment= CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
       List<Comment> comments=commentRepository.findAll();
       return comments.stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
