package board.z01_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

// 파일을 다운로드 처리하는 객체..
// a href="파일명"
/*
client --> server (다운로드 요청 controller)
server ( response 객체를 통해서 파일을 전송한다.) 
1. response에서 다운로드를 위해 설정할 부분..
	1) contentType : application/download;charset=utf-8;
	2) 파일의 크기 : contentLength
	3) 파일명 : setHead( Content-Desposition 속성에 속성값 a
				attachment;filename=파일명
		       Content-Transfer-Encoding : binary
		- 한글파일명을 경우 encoding가 필요
	4) OutputStream 전송처리..
	    - server 에 있는 File객체를 InputStream으로 담아서..
	    - 위에 OutputStream에 복사처리(FileCopyUtils)
	    - flush()
		
 */

// board.z01_util.DownLoadViewer

// View 최상 객체를 상속받아 처리 AbstractView(추상클래스)
@Component("download")
public class DownLoadViewer extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest arg1, HttpServletResponse response)
			throws Exception {
//		1. 어떤 controller에서 호출하는 있는 model과 이와 매핑되어 있는 파일을 가져온다.
//			1) 다운 로드하는 model,을 표시해서 처리.
		File file = (File)model.get("downloadFile"); // ${downloadFile}
//		2. client로 response를 통해서 파일 넘기기 위한 처리..
//			1) contentType 설정.
		response.setContentType("application/download; charset=utf-8");
//			2) contetnLength(파일크기)
		response.setContentLength((int)file.length());
//			3) setHead( 파일명, 전송엔코딩 )
//				- 한글명파일이면 encoding 처리..
		String fname= URLEncoder.encode(file.getName(), 
				"utf-8").replaceAll("\\+", " ");
		// filename="test01.txt"
		response.setHeader("Content-Disposition", 
					"attachment;filename=\""+fname+"\"");
		response.setHeader("Cotent-Transfer", "binary");
//			4) stream 통해서 전송..
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fis, out);
		out.flush();
	}

}
