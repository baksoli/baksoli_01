package board.vo;

import java.util.Date;

public class Board {
	//리스트할 단위 속성 내용.
	private int no; // 번호
	private int refno; // 상위 글번호.
	private String subject; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String pass; // 비밀번호
	private String email; // 이메일
	/* no, refno, subject, writer, content, pass, email */
	
	private int readcount; //조회수
	private Date regdate; // 등록일
	private Date uptdate; // 수정일
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Board(int no, String subject, String writer, Date regdate, int readcount) {
		super();
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.regdate = regdate;
		this.readcount = readcount;
	}

	public Board(int no, String subject, String content, int readcount) {
		super();
		this.no = no;
		this.subject = subject;
		this.content = content;
		this.readcount = readcount;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRefno() {
		return refno;
	}
	public void setRefno(int refno) {
		this.refno = refno;
	}
	public Date getUptdate() {
		return uptdate;
	}
	public void setUptdate(Date uptdate) {
		this.uptdate = uptdate;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
