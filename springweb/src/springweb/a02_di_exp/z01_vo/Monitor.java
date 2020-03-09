package springweb.a02_di_exp.z01_vo;

import java.util.Map;
//springweb.a02_di_exp.z01_vo.Monitor
public class Monitor {
	// 1. key, Sensor
	// 2. key, Integer
	private Map<String, Sensor> sensorMap;
	private Map<String, Integer> config;
	public Monitor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Monitor(Map<String, Sensor> sensorMap, Map<String, Integer> config) {
		super();
		this.sensorMap = sensorMap;
		this.config = config;
	}
	public Map<String, Sensor> getSensorMap() {
		return sensorMap;
	}
	// 저장 property 와 연결하는 메서드 setXXX (di.xml 에서 호출) ==> sensorMap
	public void setSensorMap(Map<String, Sensor> sensorMap) {
		this.sensorMap = sensorMap;
	}
	
	public Map<String, Integer> getConfig() {
		return config;
	}
	// 저장 property 와 연결하는 메서드 setXXX (di.xml 에서 호출) ==> config
	public void setConfig(Map<String, Integer> config) {
		this.config = config;
	}
	@Override
	public String toString() {
		return "Monitor [sensorMap=" + sensorMap + ", config=" + config + "]";
	}
	
	// 해당 map객체 할당 처리.
	// 1. 기본 생성자. 데이터 할당 생성자.
	// 2. 기본 저장 메서드. 호출 메서드.
	// 3. toString() : 참조 변수로 해당 데이터 출력.
	
	
	
	
}
