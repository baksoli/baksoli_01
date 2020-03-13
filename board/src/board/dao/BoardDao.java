package board.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import board.vo.Board;
import board.vo.BoardFile;
import board.vo.BoardSch;

@Repository
public interface BoardDao {
	
	// db 를 이용하여 등록 처리
	public void insertBoard(Board ins);

	// 검색할 list데이터 처리.
	// 리스트할 데이터 
	public ArrayList<Board> getList(BoardSch sch);

	// 업로드한 파일 정보 DB 입력.
	public void uploadFile(BoardFile ins);
	
	// 상세화면 조회
	public Board getBoard(int boardno);
	
	// 첨부파일 정보 조회
	public ArrayList<BoardFile> getFile(int boardno);
	
	// 상세화면 클릭시 조회수 update
	public void uptReadCnt(int boardno);
	
	public void updateBoard(Board upt);
	
	public void deleteBoard(int no);	
	
}
