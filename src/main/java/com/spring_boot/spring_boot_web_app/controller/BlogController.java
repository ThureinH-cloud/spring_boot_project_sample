package com.spring_boot.spring_boot_web_app.controller;

import com.spring_boot.spring_boot_web_app.dto.CommentDto;
import com.spring_boot.spring_boot_web_app.dto.PostDto;
import com.spring_boot.spring_boot_web_app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    private PostService postService;
    public BlogController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping(value = "/")
    public String viewBlogPosts(Model model){
       List<PostDto> posts=postService.findAllPosts();
       model.addAttribute("posts", posts);
       return "blog/view_posts";
    }

    @GetMapping(value = "/post/{postUrl}")
    public String viewBlogPost(@PathVariable("postUrl") String postUrl, Model model){
        PostDto post=postService.findPostByUrl(postUrl);
        CommentDto comment=new CommentDto();
        model.addAttribute("post", post);
        model.addAttribute("comment", comment);
        return "blog/blog_post";
    }
    @GetMapping(value = "/page/search")
    public String searchPosts(@RequestParam("query") String query , Model model){
       List<PostDto> posts=postService.searchPosts(query);
       model.addAttribute("posts", posts);
       return "blog/view_posts";
    }


}
