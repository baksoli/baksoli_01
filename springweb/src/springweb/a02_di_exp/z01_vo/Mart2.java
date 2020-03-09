package springweb.a02_di_exp.z01_vo;

import java.util.ArrayList;

public class Mart2 {
	private String mname;
	// 판매물품 list
	private ArrayList<String> blist;
	public Mart2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mart2(String mname) {
		super();
		this.mname = mname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public ArrayList<String> getBlist() {
		return blist;
	}
	// list데이터를 처리해주는 메서드 정의.
	public void setBlist(ArrayList<String> blist) {
		this.blist = blist;
	}
	public void displayProd() {
		System.out.println("## "+mname+"의 판매 물품 전시 현황 ##");
		int cnt=1;
		for(String prod : blist) {
			System.out.println(cnt+++" - "+prod);
		}
	}
	
}
