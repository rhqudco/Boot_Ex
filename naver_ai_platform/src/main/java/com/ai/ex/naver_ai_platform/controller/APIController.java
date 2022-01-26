package com.ai.ex.naver_ai_platform.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.ai.ex.naver_ai_platform.model.CelebrityVO;
import com.ai.ex.naver_ai_platform.model.FaceVO;
import com.ai.ex.naver_ai_platform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class APIController {
	@Autowired
	private CFRCelebrityService cfrServiceCel;
	
	@Autowired
	private CFRFaceRecogService cfrRecogService;

	@Autowired
	private OCRService ocrService;

	@Autowired
	private PoseEstimationService poseEstimationService;

	@Autowired
	private ObjectDetectionService objectDetectionService;

	@Autowired
	private STTService sttService;

	@Autowired
	private TTSService ttsService;

	@Autowired
	private ChatbotService chatbotService;
	
	// index 페이지로 이동
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/faceRecogCelForm")
	public String faceRecogCelForm() {
		return "celebrityView";
	}

	// (1) 유명인 얼굴인식 API 호출 : 결과를 콘솔에 출력
	// 변경  -> 
	// (2) 유명인 얼굴인식 API 호출 결과 CelebrityVO 리스트 받아서
	// Model에 담아 celebrityView.jsp 뷰 페이지로 전달
	@RequestMapping("/faceRecogCel")
	public String  faceRecogCel(@RequestParam("uploadFile") MultipartFile file,			
													 Model model) throws IOException {
		// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		// 3. 파일 생성
		File file1 = new File(filePathName);
		// 4. 서버로 전송
		file.transferTo(file1);
		ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();
		// 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
		// 서비스에서 반환된 CelebrityVO 리스트 저장
		celList = cfrServiceCel.clovaFaceRecogCel(filePathName);
		//Model에 "celList" 이름으로 저장 -> view 페이지로 전달
		model.addAttribute("celList", celList);
		model.addAttribute("fileName", originalFileName);
		return "celebrityView";
	}
	
	@RequestMapping("/faceRecogForm")
		public String faceRecogForm() {
			return "faceRecogView";
		}
	// (1) 얼굴 감지 API 호출 : 결과를 콘솔에 출력
	@RequestMapping("/faceRecog")
	public String faceRecog(@RequestParam("uploadFile") MultipartFile file,
			Model model) throws IOException {
		// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		// 3. 파일 생성
		File file1 = new File(filePathName);
		// 4. 서버로 전송
		file.transferTo(file1);
		ArrayList<FaceVO> faceList = new ArrayList<FaceVO>();
		faceList = cfrRecogService.faceRecog(filePathName);
		model.addAttribute("faceList", faceList);
		System.out.println(faceList+"ee");
		model.addAttribute("fileName", originalFileName);
		return "faceRecogView";
	}

//	// ocr 페이지 호출
//	@RequestMapping("/clovaOCR")
//	public void clovaOCR() {
//		ocrService.clovaOCRService();
//	} -> APIRestController에서 처리

	// ocrView.jsp 페이지로 이동
	@RequestMapping("/clovaOCRForm")
	public String clovaOCRForm() {
		return "ocrView";
	}

//	@RequestMapping("/pose")
//	public void pose() {
//		poseEstimationService.poseEstimation();
//	}

	@RequestMapping("/poseForm")
	public String poseForm() {
		return "poseView";
	}

	@RequestMapping("/objDetectForm")
	public String objDetectForm() {
		return "objDetect";
	}

	@RequestMapping("/sttView")
	public String sttService() {
		return "sttView";
	}
	@RequestMapping("/sttView2")
	public String sttService2() {
		return "sttView2";
	}

	// tts
	@RequestMapping("clovaTTSForm")
	public String ttsService() {
		return "ttsView";
	}

	// 챗봇 질문 전송하고 결과 받아서 출력
	@RequestMapping("/chatbot")
	public void chatbot() {
		chatbotService.main("넌 누구니"); // 메소드가 static이라 클래스로 호출해야 함
	}
	@RequestMapping("/chatbotForm")
	public String chatbotForm() {
		return "chatbotForm";
	}
	@RequestMapping("/chatbotForm2")
	public String chatbotForm2() {
		return "chatbotForm2";
	}
	@RequestMapping("/chatbotForm3")
	public String chatbotForm3() {
		return "chatbotForm3";
	}
}