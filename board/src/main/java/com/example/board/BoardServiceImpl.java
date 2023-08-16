package com.example.board;

import com.example.board.dao.BoardDao;
import com.example.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDao boardDao;

    @Override
    public void insertBoard(BoardDto dto) {
        boardDao.insertBoard(dto);
    }

    @Override
    public void updateBoard(BoardDto dto) {
        boardDao.updateBoard(dto);
    }

    @Override
    public void deleteBoard(BoardDto dto) {
        boardDao.deleteBoard(dto);
    }

    @Override
    public BoardDto getBoard(BoardDto dto) {
        return boardDao.getBoard(dto);
    }

    @Override
    public List<BoardDto> getBoardList() {
        return boardDao.getBoardList();
    }
}
