package springweb.a02_di_exp.z01_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Man {
	private String name;
	@Autowired
	private Woman woman;
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Man(String name) {
		super();
		this.name = name;
	}
	public void show() {
		System.out.println("그 남자는 "+name);
		if(woman != null) {
			System.out.println("그 남자 안에 있는 그녀!");
			woman.showInfo();
		}else {
			System.out.println("아무도 없음.(객체할당 안됨)");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Woman getWoman() {
		return woman;
	}
	// autowire byType에 의해 해당 객체가 할당 될 수 있다.
	public void setWoman(Woman woman) {
		this.woman = woman;
	}
	
}

