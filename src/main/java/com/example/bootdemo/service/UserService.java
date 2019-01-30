package com.example.bootdemo.service;

import com.example.bootdemo.model.User;

import java.util.List;


public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

}
