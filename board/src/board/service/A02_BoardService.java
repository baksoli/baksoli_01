package board.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import board.dao.BoardDao;
import board.vo.Board;
import board.vo.BoardFile;
import board.vo.BoardSch;

@Service
public class A02_BoardService {
	@Autowired(required = false)
	private BoardDao dao;
	
	// 리스트 되는 데이터 메서드 선언.
	public ArrayList<Board> getList(BoardSch sch){
		return dao.getList(sch);
	}
	
	// 1. 경로1(web현재 폴더) 경로2(temp폴더)
	@Value("${upload1}")
	private String upload1;
	
	@Value("${upload2}")
	private String upload2;
	
	// 등록 처리
	public void insert(Board ins) {
//		System.out.println("등록 성공!!");
//		System.out.println("제목 : "+ins.getSubject());
//		System.out.println("작성자 : "+ins.getWriter());
//		System.out.println("내용 : "+ins.getContent());
		dao.insertBoard(ins);
		// 첨부파일 물리적 위치 지정/DB 등록.
		String fname = null;
		File tmpFile = null;
		File orgFile = null;
		BoardFile insFile = null;
		
		// 다중 파일 처리.
		for(MultipartFile mpf:ins.getReport()) {
			fname=mpf.getOriginalFilename();
			// 파일이 없는 경우는 제외
			if(fname!=null && !fname.trim().equals("")) {
				insFile = new BoardFile(fname, upload1, ins.getSubject());
				// DB에 입력처리.(DAO)
				dao.uploadFile(insFile);
				
				// 물리적 파일 저장
				tmpFile = new File(upload2+fname);
				System.out.println("경로(임시):"+upload2+fname);
				// MultipartFile ==> File객체로 변환하여 특정한 위치에 저장.
				if(!tmpFile.exists()) {
					try {
						mpf.transferTo(tmpFile);
						
						orgFile = new File(upload1+fname);
						System.out.println("경로(최종):"+upload1+fname);
						//if(!tmpFile.exists()) {
							Files.copy(tmpFile.toPath(), orgFile.toPath());
						//}
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public Board getBoard(int boardno) {
		// 1. 기본 board 정보 할당.
		Board board = dao.getBoard(boardno);
		// 2. 첨부 파일 정보 할당.
		board.setFileInfo(dao.getFile(boardno));
		//3. 조회 cnt 수정.
		dao.uptReadCnt(boardno);
		
		return board;
	}
	// 게시글 수정
	public void updateBoard(Board upt) {
		dao.updateBoard(upt);
	}
	//게시글 삭제
	public void deleteBoard(int no) {
		dao.deleteBoard(no);
	}
}
