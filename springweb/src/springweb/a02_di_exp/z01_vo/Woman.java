package springweb.a02_di_exp.z01_vo;

//springweb.a02_di_exp.z01_vo.Woman
public class Woman {
	private String name;
	private int age;
	private String loc;
	public Woman() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Woman(String name, int age, String loc) {
		super();
		this.name = name;
		this.age = age;
		this.loc = loc;
	}
	// 기본 정보 표현..
	public void showInfo() {
		System.out.println("# 그녀는 #");
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("사는곳:"+loc);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
