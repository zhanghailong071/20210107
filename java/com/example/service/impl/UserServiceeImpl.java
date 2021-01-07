package com.example.service.impl;

import com.example.dao.UsersMapper;
import com.example.entity.Users;
import com.example.service.userServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceeImpl implements userServicee {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users findAll(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addUser(Users user) {

    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public int deleteUser(Integer id) {
        return 0;
    }
}
