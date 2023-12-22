package com.mapper;

import com.entity.User;

import java.util.List;

public interface UserMapper {
    public void addUser(User user);
    public List<User> findAllUser();
}
