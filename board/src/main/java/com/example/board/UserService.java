package com.example.board;

import com.example.board.dto.UserDto;

public interface UserService {
    // 회원 조회
    public UserDto getUser(UserDto dto);

    // 회원 등록
    void insertUser(UserDto dto);
}
