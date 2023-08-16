package com.example.board.dao;

import com.example.board.UserRepository;
import com.example.board.dto.UserDto;
import com.example.board.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository("userDao")
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    // 회원 조회
    public UserDto getUser(UserDto dto) {
        System.out.println("----JDBC로 getUser() 기능 처리");
        try {
            Optional<User> optionalUser = userRepository.findByName(dto.getName());
            if (optionalUser.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");

            User user = optionalUser.get();
            dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setPassword(user.getPassword());
            dto.setRole(user.getRole());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    // 회원 등록
    public void insertUser(UserDto dto) {
        System.out.println("----JDBC로 insertUser() 기능 처리");
        try {
            User user = new User();
            user.setName(dto.getName());
            user.setPassword(dto.getPassword());
            user.setRole(dto.getRole());
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
