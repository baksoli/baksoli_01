package springweb.a02_di_exp.z01_vo;

import java.util.Properties;
import java.util.Set;

//springweb.a02_di_exp.z01_vo.Sensor
public class Sensor {
	//여러가지 구조의 데이터 DI 처리..
	private Properties addInfo;
	private Set<String> agentCodes;
	public Properties getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(Properties addInfo) {
		this.addInfo = addInfo;
	}
	public Set<String> getAgentCodes() {
		return agentCodes;
	}
	public void setAgentCodes(Set<String> agentCodes) {
		this.agentCodes = agentCodes;
	}
	public int read() {
		return 0;
	}
	@Override
	public String toString() {
		return "Sensor [addInfo=" + addInfo + ", agentCodes=" + agentCodes + "]";
	}
	
}
