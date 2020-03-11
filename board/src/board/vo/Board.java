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
	
	private int readcnt; //조회수
	private Date regdte; // 등록일
	private Date uptdte; // 수정일
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int no, int refno, String subject, String writer, String content, String pass, String email,
			int readcnt, Date regdte, Date uptdte) {
		super();
		this.no = no;
		this.refno = refno;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.pass = pass;
		this.email = email;
		this.readcnt = readcnt;
		this.regdte = regdte;
		this.uptdte = uptdte;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRefno() {
		return refno;
	}
	public void setRefno(int refno) {
		this.refno = refno;
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
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdte() {
		return uptdte;
	}
	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}
	
	
	
	
}
