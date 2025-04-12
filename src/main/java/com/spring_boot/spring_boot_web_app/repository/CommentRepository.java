package com.spring_boot.spring_boot_web_app.repository;

import com.spring_boot.spring_boot_web_app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
