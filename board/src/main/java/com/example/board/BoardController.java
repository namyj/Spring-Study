package com.example.board;

import com.example.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String main() {
        return "hello";
    }

    // 글 등록
    @GetMapping("/new")
    public String insert() {
        BoardDto dto = new BoardDto();
        dto.setTitle("임시 제목");
        dto.setContent("--------임시 내용--------");
        dto.setWriter("홍길동");

        boardService.insertBoard(dto);

        return "insert success";
    }

    // 글 목록 검색
    @GetMapping("/all")
    public List<BoardDto> readAll() {
        return boardService.getBoardList();
    }

}
