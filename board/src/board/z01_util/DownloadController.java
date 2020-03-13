package board.z01_util;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {
	// 다운로드 파일이 있는 폴드 위치
	@Value("${upload1}")
	private String upload1;
	// 다운로드 url 패턴
	// /down.do?fname=파일명
	@RequestMapping("/down.do")
	public String download(@RequestParam("fname") String fname, Model d) {
		// DownloadViewer 안에서 파일을 식별하기 위해, 모델명으로 파일명을 설정한다.
		d.addAttribute("downloadFile", new File(upload1+fname));
		return "download"; // controller에 선언된 bean의 id가 download 
	}
}
