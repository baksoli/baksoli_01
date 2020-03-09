package springweb.a02_di_exp.z01_vo;

import java.util.Map;

//springweb.a02_di_exp.z01_vo.BookStore
public class BookStore {
	private String bName;
	private Map<String, Integer> bookMap;
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookStore(String bName, Map<String, Integer> bookMap) {
		super();
		this.bName = bName;
		this.bookMap = bookMap;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Map<String, Integer> getBookMap() {
		return bookMap;
	}
	public void setBookMap(Map<String, Integer> bookMap) {
		this.bookMap = bookMap;
	}
	@Override
	public String toString() {
		return "BookStore [서점명=" + bName + ", 도서명과 가격=" + bookMap + "]";
	}
	
	
}
