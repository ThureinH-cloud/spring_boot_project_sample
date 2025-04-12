package com.spring_boot.spring_boot_web_app.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    @NotEmpty(message = "Post Title should not be empty")
    private String title;
    private String url;
    @NotEmpty(message = "Post Content should not be empty")
    private String content;
    @NotEmpty(message = "Post short description should not be empty")
    private String shortDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
