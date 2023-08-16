package com.example.board.dao;

import com.example.board.BoardRepository;
import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    private BoardRepository boardRepository;

    public void insertBoard(BoardDto dto) {
        System.out.println("JDBC로 insertBoard() 처리");

        try {
            Board board = new Board();
            board.setTitle(dto.getTitle());
            board.setWriter(dto.getWriter());
            board.setContent(dto.getContent());
            board.setCnt(dto.getCnt());
            board.setRegDate(dto.getRegDate());
            board.setSeq(dto.getSeq());

            boardRepository.save(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBoard(BoardDto dto) {
        System.out.println("JDBC로 updateBoard() 처리");

        try {
            Board board = boardRepository.findBySeq(dto.getSeq());
            board.setTitle(dto.getTitle());
            board.setContent(dto.getContent());

            boardRepository.save(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteBoard(BoardDto dto) {
        System.out.println("JDBC로 deleteBoard() 처리");

        try {
            Board board = boardRepository.findBySeq(dto.getSeq());

            boardRepository.delete(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public BoardDto getBoard(BoardDto dto) {
        System.out.println("JDBC로 getBoard() 처리");

        try {
            Board board = boardRepository.findBySeq(dto.getSeq());
            dto = new BoardDto();
            dto.setSeq(board.getSeq());
            dto.setTitle(board.getTitle());
            dto.setWriter(board.getWriter());
            dto.setContent(board.getContent());
            dto.setRegDate(board.getRegDate());
            dto.setCnt(board.getCnt());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    public List<BoardDto> getBoardList() {
        System.out.println("JDBC로 getBoardList() 처리");
        List<BoardDto> boardDtoList = new ArrayList<>();

        try {
            List<Board> boardList = boardRepository.findAll();

            for (Board board : boardList) {
                BoardDto dto = new BoardDto();
                dto.setSeq(board.getSeq());
                dto.setTitle(board.getTitle());
                dto.setWriter(board.getWriter());
                dto.setContent(board.getContent());
                dto.setRegDate(board.getRegDate());
                dto.setCnt(board.getCnt());
                boardDtoList.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return boardDtoList;
    }
}
