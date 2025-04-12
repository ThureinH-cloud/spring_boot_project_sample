package com.spring_boot.spring_boot_web_app.controller;

import com.spring_boot.spring_boot_web_app.dto.CommentDto;
import com.spring_boot.spring_boot_web_app.dto.PostDto;
import com.spring_boot.spring_boot_web_app.service.CommentService;
import com.spring_boot.spring_boot_web_app.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private PostService postService;
    private CommentService commentService;
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }
    @GetMapping(value = "/admin/posts")
    public String posts(Model model) {
      List<PostDto> posts=postService.findAllPosts();
      model.addAttribute("posts", posts);
      return "admin/posts";
    }

    @GetMapping(value = "/admin/posts/newpost")
    public String newPostForm(Model model) {
        PostDto postDto=new PostDto();
        model.addAttribute("post", postDto);
        return "admin/postForm";
    }
    @PostMapping(value = "/admin/posts")
    public String savePost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", postDto);
            return "admin/postForm";
        }
        postDto.setUrl("example.com");
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }

    @GetMapping(value = "/admin/posts/{postId}/edit")
    public String editPostForm(@PathVariable("postId") Long postId, Model model) {
        model.addAttribute("post", postService.findPostById(postId));
        return "admin/edit_post";
    }

    @PostMapping(value = "/admin/posts/{postId}")
    public String updatePost(@PathVariable("postId") Long postId,@Valid @ModelAttribute("post") PostDto postDto, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", postDto);
            return "redirect:/admin/posts/{postId}/edit";
        }
        postDto.setId(postId);
        postService.updatePost(postDto);
        return "redirect:/admin/posts";
    }
    @GetMapping(value = "/admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/admin/posts";
    }

    @GetMapping(value = "/admin/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl, Model model) {
       PostDto postDto=postService.findPostByUrl(postUrl);
       model.addAttribute("post",postDto);
       return "admin/view";
    }

    @GetMapping(value = "/admin/posts/search")
    public String searchPosts(@RequestParam("query") String query, Model model) {
        List<PostDto> posts=postService.searchPosts(query);
        model.addAttribute("posts", posts);
        return "admin/posts";
    }

    @GetMapping(value = "/admin/posts/comments")
    public String postComments(Model model) {
       List<CommentDto> comments=commentService.findAllComments();
       model.addAttribute("comments", comments);
       return "admin/comments";
    }
    @GetMapping(value = "/admin/{commentId}/delete")
    public String deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/admin/posts/comments";
    }

}
