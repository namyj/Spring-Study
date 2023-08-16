package com.example.board;

import com.example.board.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String insert() {
        UserDto dto = new UserDto();
        dto.setName("홍길동");
        dto.setPassword("1234");
        dto.setRole("관리자");

        userService.insertUser(dto);
        return "insert success";
    }

    @GetMapping("/get")
    public UserDto getUser() {
        UserDto dto = new UserDto();
        dto.setName("홍길동");
        dto.setPassword("1234");
        return userService.getUser(dto);
    }
}
