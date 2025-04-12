package com.spring_boot.spring_boot_web_app.service.impl;

import com.spring_boot.spring_boot_web_app.dto.RegisterDto;
import com.spring_boot.spring_boot_web_app.entity.Role;
import com.spring_boot.spring_boot_web_app.entity.User;
import com.spring_boot.spring_boot_web_app.repository.RoleRepository;
import com.spring_boot.spring_boot_web_app.repository.UserRepository;
import com.spring_boot.spring_boot_web_app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public void save(RegisterDto registerDto) {
        User user = new User();
        user.setName(registerDto.getFirstName() + " " + registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        Role role=roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
