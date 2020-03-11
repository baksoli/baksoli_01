package board.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import board.vo.Board;

@Repository
public interface BoardDao {
	
	// 조회
	public ArrayList<Board> listBoard(Board board);
	
	// db 를 이용하여 등록 처리 
	public void insertBoard(Board ins);
}
