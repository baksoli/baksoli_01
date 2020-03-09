package springweb.a02_di_exp.z02_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Man {
	private String name;
	// autowired는 접근제어자 상관없이,
	// 자동으로 객체가 메모리에 있으면 할당이 되어 진다.
	// Qualifier("ch01")
	// container 안에 같은 type의 객체가 여러가지 선언할 때,
	// 식별해서 할당할 수 있는 객체를 선언할 때 활용된다.
	// ex) container에서 메모리에 로딩된 Woman 객체 중에서
	//  qualifier가 "ch01"인 Woman 객체를 현재 선언된 Woman woman에 
	//  할당 처리한다. <qualifier value="ch01"/>
	@Autowired
	@Qualifier("ch01") 
	private Woman woman01;
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Man(String name) {
		super();
		this.name = name;
	}
	public void show() {
		System.out.println(" ## Man & Woman 정보 리스트 ##");
		System.out.println("그 남자의 이름은 "+name);
		if(woman01!=null) {
			woman01.showInfo();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Man [name=" + name + ", woman01=" + woman01 + "]";
	}
	public Woman getWoman01() {
		return woman01;
	}
	public void setWoman01(Woman woman01) {
		this.woman01 = woman01;
	}
	
}
