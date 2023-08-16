package com.example.board;

import com.example.board.dao.UserDao;
import com.example.board.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getUser(UserDto dto) {
        return userDao.getUser(dto);
    }

    @Override
    public void insertUser(UserDto dto) {
        userDao.insertUser(dto);
    }
}
