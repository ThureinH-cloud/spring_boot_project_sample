package com.spring_boot.spring_boot_web_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    @NotEmpty(message = "Name required")
    private String name;
    @Email
    @NotEmpty(message = "Email required")
    private String email;
    @NotEmpty(message = "Required")
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
