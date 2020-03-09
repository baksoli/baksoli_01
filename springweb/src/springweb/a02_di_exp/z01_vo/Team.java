package springweb.a02_di_exp.z01_vo;

//springweb.a02_di_exp.z01_vo.Team
public class Team {
	private String tname;
	private String cnt;
	private String odds;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tname, String cnt, String odds) {
		super();
		this.tname = tname;
		this.cnt = cnt;
		this.odds = odds;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getOdds() {
		return odds;
	}
	public void setOdds(String odds) {
		this.odds = odds;
	}
	
	
}
