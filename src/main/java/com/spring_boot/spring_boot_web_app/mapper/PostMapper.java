package com.spring_boot.spring_boot_web_app.mapper;

import com.spring_boot.spring_boot_web_app.dto.PostDto;
import com.spring_boot.spring_boot_web_app.entity.Post;

public class PostMapper {
    public static PostDto maptoPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
    public static Post maptoPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .url(postDto.getUrl())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdAt(postDto.getCreatedAt())
                .updatedAt(postDto.getUpdatedAt())
                .build();
    }
}
