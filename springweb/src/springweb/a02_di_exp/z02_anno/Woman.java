package springweb.a02_di_exp.z02_anno;

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
	public void showInfo() {
		System.out.println("그 여자의 이름은 "+name);
		System.out.println("그 여자의 나이는 "+age);
		System.out.println("그 여자의 주소는 "+loc);
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
