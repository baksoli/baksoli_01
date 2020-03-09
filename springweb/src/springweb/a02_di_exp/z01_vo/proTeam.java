package springweb.a02_di_exp.z01_vo;

//springweb.a02_di_exp.z01_vo.proTeam
public class proTeam {
	private String teamName;
	private String win;
	private String loose;
	private String same;
	private String state;
	
	public proTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public proTeam(String teamName, String win, String loose, String same, String state) {
		super();
		this.teamName = teamName;
		this.win = win;
		this.loose = loose;
		this.same = same;
		this.state = state;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public String getLoose() {
		return loose;
	}
	public void setLoose(String loose) {
		this.loose = loose;
	}
	public String getSame() {
		return same;
	}
	public void setSame(String same) {
		this.same = same;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
