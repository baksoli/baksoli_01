package springweb.a02_di_exp.z02_anno;

public class Number {
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Number [number=" + number + "]";
	}
	public Integer toNumber(){
		return number;
	}
}
