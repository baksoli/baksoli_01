package springweb.a02_di_exp.z02_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BookStore {
	private String name;
	@Autowired(required = false)
	@Qualifier("ch002")
	private Book book;
	
	@Autowired(required = false)
	@Qualifier("ch003")
	private Book book2;
	
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookStore(String name) {
		super();
		this.name = name;
	}
	public void bookStoreShow() {
		System.out.println("## "+name+" 서점 책/가격 ##");
		if(book!=null) {
			System.out.println("첫번째 도서");
			book.showBook();
		}
		if(book2!=null) {
			System.out.println("두번째 도서");
			book2.showBook();
		}else {
			System.out.println("재고가 없습니다.");
		}
	}
	
}
