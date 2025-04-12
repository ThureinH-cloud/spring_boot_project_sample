package com.spring_boot.spring_boot_web_app.service;

import com.spring_boot.spring_boot_web_app.dto.CommentDto;
import com.spring_boot.spring_boot_web_app.entity.Comment;

import java.util.List;


public interface CommentService {
    void createComment(String postUrl,CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);
}
