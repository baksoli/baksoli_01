package board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.vo.Board;
import board.vo.BoardSch;

@Service
public class A02_BoardService {
	@Autowired(required = false)
	private BoardDao dao;
	
	// 리스트 되는 데이터 메서드 선언.
//	public ArrayList<Board> listBoard(Board board){
//		return dao.listBoard(board);
//	}
	public List<Board> boardList(BoardSch sch){
		List<Board> blist = new ArrayList<Board>();	
//		blist.add(new Board(1,"첫번째 글","홍길동",new Date(),0));
//		blist.add(new Board(2,"두번째 글","김길동",new Date(),2));
//		blist.add(new Board(3,"세번째 글","신길동",new Date(),1));
//		blist.add(new Board(4,"네번째 글","마길동",new Date(),3));
//		blist.add(new Board(5,"다섯번째 글","오길동",new Date(),4));
		return blist;
	}
	
	// 등록 처리
	public void insert(Board ins) {
//		System.out.println("등록 성공!!");
//		System.out.println("제목 : "+ins.getSubject());
//		System.out.println("작성자 : "+ins.getWriter());
//		System.out.println("내용 : "+ins.getContent());
		dao.insertBoard(ins);
	}
}
