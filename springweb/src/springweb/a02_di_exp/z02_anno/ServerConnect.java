package springweb.a02_di_exp.z02_anno;

import org.springframework.beans.factory.annotation.Value;

//web.server01=192.168.77.88
//web.port=7799
//web.url=/springweb/start.do
	
public class ServerConnect {
	private String server01;
	private String port;
	private String url;
	
	// 공통 properties파일에 적용된 내용을,
	// code에서 직접 적용 처리가 가능하다.
	// 1. annotation선언.
	// 2. 설정파일 선언. - <context:annotation-config>
	//(실무적으로 더 많이 쓰일 수 있음)
	@Value("${web.server01}")
	private String server02;
	@Value("${web.port}")
	private String port2;
	@Value("${web.url}")
	private String url2;
	
	public ServerConnect(String server01, String port, String url) {
		super();
		this.server01 = server01;
		this.port = port;
		this.url = url;
	}
	public void showInfo1() {
		System.out.println("## 속성 설정 정보1(xml선언) ##");
		System.out.println("server01 : "+server01);
		System.out.println("port : "+port);
		System.out.println("url : "+url);
		
	}
	public void showInfo2() {
		System.out.println("## 속성 설정 정보2(java annotation으로 mapping) ##");
		System.out.println("server2 : "+server02);
		System.out.println("port2 : "+port2);
		System.out.println("url2 : "+url2);
	}
}
