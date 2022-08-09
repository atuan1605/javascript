package com.example.springlogin.service;

import com.example.springlogin.dto.UserDto;
import com.example.springlogin.exception.BadRequestException;
import com.example.springlogin.exception.NotFoundException;
import com.example.springlogin.model.User;
import com.example.springlogin.request.LoginRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public List<User> users;

    @Autowired
    private ModelMapper modelMapper;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1, "account1", "gmail1@.com", "123", "image1"));
        users.add(new User(2, "account2", "gmail2@.com", "asdf", "image2"));
        users.add(new User(3, "account3", "gmail3@.com", "321", "image3"));
        users.add(new User(4, "account4", "gmail4@.com", "qwer", "image4"));
    }

    public Optional<User> findUser(String userName, String password) {
        return users
                .stream()
                .filter(user -> user.getUserName().equals(userName) && user.getPassword().equals(password)).findFirst();
    }

    public UserDto loginUser(LoginRequest request) {
        User user = findUser(request.getUserName(), request.getPassword()).orElseThrow(() -> {
            throw new BadRequestException("User doesn't exist");
        });

        return modelMapper.map(user, UserDto.class);
    }



}
