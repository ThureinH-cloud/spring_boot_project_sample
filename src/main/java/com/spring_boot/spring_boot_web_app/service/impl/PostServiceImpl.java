package com.spring_boot.spring_boot_web_app.service.impl;

import com.spring_boot.spring_boot_web_app.dto.PostDto;
import com.spring_boot.spring_boot_web_app.entity.Post;
import com.spring_boot.spring_boot_web_app.mapper.PostMapper;
import com.spring_boot.spring_boot_web_app.repository.PostRepository;
import com.spring_boot.spring_boot_web_app.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::maptoPostDto).collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = PostMapper.maptoPost(postDto);
        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No Exception"));
        return PostMapper.maptoPostDto(post);
    }

    @Override
    public void updatePost(PostDto postDto) {
        Post post=PostMapper.maptoPost(postDto);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDto findPostByUrl(String url) {
       Post post=postRepository.findByUrl(url).orElseThrow(()->new EntityNotFoundException("No url not found"));
       return PostMapper.maptoPostDto(post);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
      List<Post> posts = postRepository.searchByQuery(query);
      return posts.stream().map(PostMapper::maptoPostDto).collect(Collectors.toList());
    }
}
