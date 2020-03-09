package springweb.a02_di_exp.z01_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Bus {
	private int busNum;
	@Autowired
	private Passenger passenger;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int busNum) {
		super();
		this.busNum = busNum;
	}
	public void showInfo() {
		System.out.println(busNum + "번 버스에");
		if(passenger != null) {
			System.out.println("승객 "+passenger.getName()+"가 탑승했습니다.");
		}else {
			System.out.println("탑승한 승객이 없습니다.");
		}
	}
	public int getBusNum() {
		return busNum;
	}
	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
}
