package springweb.a02_di_exp.z01_vo;

import java.util.ArrayList;

public class Mart3 {
	private String mname;
	private ArrayList<Product> plist;
	public Mart3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mart3(String mname) {
		super();
		this.mname = mname;
	}
	public void buyList() {
		System.out.println(mname+"에서 구매한 물건 list");
		// ArrayList가 null이 아니고, 구매물품이 1개 이상일 때..
		if(plist!=null && plist.size()>0) {
			System.out.print("번호\t");
			System.out.print("물건명\t");
			System.out.print("가격\t");
			System.out.print("객수\t");
			System.out.print("계\n");
			int cnt=1;
			int tot=0;
			for(Product p : plist) {
				System.out.print(cnt+++"\t");
				System.out.print(p.getName()+"\t");
				System.out.print(p.getPrice()+"\t");
				System.out.print(p.getCnt()+"\t");
				System.out.print(p.getPrice()*p.getCnt()+"\n");
				tot+= p.getPrice()*p.getCnt();
			}
			System.out.println("전체 총계:"+tot+"원!!");
		}else {
			System.out.println("## 구매 물품 없음 ##");
		}
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public ArrayList<Product> getPlist() {
		return plist;
	}
	public void setPlist(ArrayList<Product> plist) {
		this.plist = plist;
	}
	
}
