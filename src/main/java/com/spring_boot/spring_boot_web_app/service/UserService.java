package com.spring_boot.spring_boot_web_app.service;


import com.spring_boot.spring_boot_web_app.dto.RegisterDto;

public interface UserService {
    void save(RegisterDto registerDto);
}
