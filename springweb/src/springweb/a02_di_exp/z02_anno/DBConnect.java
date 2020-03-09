package springweb.a02_di_exp.z02_anno;

//springweb.a02_di_exp.z02_anno.DBConnect
public class DBConnect {
	private String driver;
	private String url;
	private String user;
	private String password;
	public DBConnect(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public void showInfo() {
		System.out.println("## 데이터 베이스 접근 정보 ##");
		System.out.println("driver : "+driver);
		System.out.println("url : "+url);
		System.out.println("user : "+user);
		System.out.println("password : "+password);
	}
}
