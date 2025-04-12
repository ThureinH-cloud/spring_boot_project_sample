package com.spring_boot.spring_boot_web_app.service;

import com.spring_boot.spring_boot_web_app.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    void createPost(PostDto postDto);

    PostDto findPostById(Long id);

    void updatePost(PostDto postDto);

    void deletePost(Long id);

    PostDto findPostByUrl(String url);

    List<PostDto> searchPosts(String query);
}
