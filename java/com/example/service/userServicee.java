package com.example.service;

import com.example.entity.Users;

public interface userServicee {
    /**
     * 查询所有用户
     * @return
     */
    Users findAll(String id);

    /**
     * 添加用户
     * @param user
     */
    void addUser(Users user);

    /**
     * 跟新用户
     * @param user
     */
    void updateUser(Users user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);
}