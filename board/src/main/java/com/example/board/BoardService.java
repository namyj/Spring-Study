package com.example.board;

import com.example.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    void insertBoard(BoardDto dto);
    void updateBoard(BoardDto dto);
    void deleteBoard(BoardDto dto);
    BoardDto getBoard(BoardDto dto);
    List<BoardDto> getBoardList();
}
