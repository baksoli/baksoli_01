package board.vo;

public class BoardSch {
	// Model Attribute로 처리 하자.
	// 검색할 내용
	private String subject; // 제목
	private String writer; // 작성자
	private String content; // 내용
	public BoardSch() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	 
}
