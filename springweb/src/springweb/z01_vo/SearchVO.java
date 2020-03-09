package springweb.z01_vo;

public class SearchVO {
	private String type;
	private String query;
	public SearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchVO(String type, String query) {
		super();
		this.type = type;
		this.query = query;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
}
