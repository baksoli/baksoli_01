package springweb.a02_di_exp.z01_vo;

import java.util.ArrayList;

public class Baseball {
	private String name;
	private ArrayList<Team> plist;
	public Baseball() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Baseball(String name) {
		super();
		this.name = name;
	}
	public void teamList() {
		System.out.println("## 한국 야구 순위 ##");
		if(plist != null && plist.size()>0) {
			System.out.print("순위\t");
			System.out.print("팀이름\t");
			System.out.print("경기수\t");
			System.out.print("승률\n");
			int cnt = 1;
			for(Team t : plist) {
				System.out.print(cnt+++"\t");
				System.out.print(t.getTname()+"\t");
				System.out.print(t.getCnt()+"\t");
				System.out.print(t.getOdds()+"\n");
			}
			
		}else {
			System.out.println("## 등록된 한국 야구 경기가 없습니다. ##");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Team> getPlist() {
		return plist;
	}
	public void setPlist(ArrayList<Team> plist) {
		this.plist = plist;
	}
	
}
