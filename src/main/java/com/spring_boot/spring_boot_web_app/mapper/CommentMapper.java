package com.spring_boot.spring_boot_web_app.mapper;

import com.spring_boot.spring_boot_web_app.dto.CommentDto;
import com.spring_boot.spring_boot_web_app.entity.Comment;

public class CommentMapper {
    public static Comment mapToComment(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .name(commentDto.getName())
                .email(commentDto.getEmail())
                .content(commentDto.getContent())
                .createdAt(commentDto.getCreatedAt())
                .updatedAt(commentDto.getUpdatedAt())
                .build();
    }
    public static CommentDto mapToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
