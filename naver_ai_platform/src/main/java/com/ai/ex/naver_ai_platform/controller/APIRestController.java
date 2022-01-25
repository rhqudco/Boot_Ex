package com.ai.ex.naver_ai_platform.controller;

import com.ai.ex.naver_ai_platform.model.CelebrityVO;
import com.ai.ex.naver_ai_platform.model.FaceVO;
import com.ai.ex.naver_ai_platform.model.ObjectVO;
import com.ai.ex.naver_ai_platform.model.PoseVO;
import com.ai.ex.naver_ai_platform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class APIRestController {
    @Autowired
    private OCRService ocrService;
    @Autowired
    private PoseEstimationService poseEstimationService;
    @Autowired
    private ObjectDetectionService objectDetectionService;
    @Autowired
    private STTService sttService;
    @Autowired
    private STTService2 sttService2;
    @Autowired
    private TTSService ttsService;
    @RequestMapping("/clovaOCR")
    public String clovaOCR(@RequestParam("uploadFile") MultipartFile file){
        String result = "";
        try {
            // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
            String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();
            String filePathName = uploadPath + originalFileName;
            // 3. 파일 생성
            File file1 = new File(filePathName);
            // 4. 서버로 전송
            file.transferTo(file1);
            // 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
            // 서비스에서 반환된 텍스트를 result에 저장
            result = ocrService.clovaOCRService(filePathName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    // 포즈 인식
    @RequestMapping("/poseDetect")
    public ArrayList<PoseVO> poseDetect(@RequestParam("uploadFile") MultipartFile file) {
        ArrayList<PoseVO> poseList = null;
        try {
            // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
            String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();
            String filePathName = uploadPath + originalFileName;
            // 3. 파일 생성
            File file1 = new File(filePathName);
            // 4. 서버로 전송
            file.transferTo(file1);
            // 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
            // 서비스에서 반환된 PoseVO 리스트 저장
            poseList = poseEstimationService.poseEstimation(filePathName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return poseList;
    }
    // 포즈 인식
    @RequestMapping("/objDetect")
    public ArrayList<ObjectVO>  objectDetect(@RequestParam("uploadFile") MultipartFile file) {
        ArrayList<ObjectVO>objectList = null;
        try {
            // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
            String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();
            String filePathName = uploadPath + originalFileName;
            // 3. 파일 생성
            File file1 = new File(filePathName);
            // 4. 서버로 전송
            file.transferTo(file1);
            // 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
            // 서비스에서 반환된 PoseVO 리스트 저장
            objectList = objectDetectionService.objectDetect(filePathName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }
    // 일반
    @RequestMapping("/stt")
    public String sttService(@RequestParam("uploadFile") MultipartFile file) {
        String stt = "";
        try {
            // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
            String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();
            String filePathName = uploadPath + originalFileName;
            // 3. 파일 생성
            File file1 = new File(filePathName);
            // 4. 서버로 전송
            file.transferTo(file1);
            // 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
            // 서비스에서 반환된 PoseVO 리스트 저장
            stt = sttService.clovaSpeechToText(filePathName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stt;
    }
    // 언어 선택
    @RequestMapping("/stt2")
    public String sttService2(@RequestParam("uploadFile") MultipartFile file, @RequestParam("language") String language) {
        String stt = "";
        try {
            // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
            String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();
            String filePathName = uploadPath + originalFileName;
            // 3. 파일 생성
            File file1 = new File(filePathName);
            // 4. 서버로 전송
            file.transferTo(file1);
            // 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
            // 서비스에서 반환된 PoseVO 리스트 저장
            stt = sttService2.clovaSpeechToText(filePathName, language);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stt;
    }
    @RequestMapping("/clovaTTS")
    public String clovaTTS(@RequestParam("uploadFile") MultipartFile file,
                            @RequestParam("country") String country) {
        String tts = "";
        try {
            // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
            String uploadPath = "/Users/gobyeongchae/Desktop/productImages";
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();
            String filePathName = uploadPath + originalFileName;
            // 3. 파일 생성
            File file1 = new File(filePathName);
            // 4. 서버로 전송
            file.transferTo(file1);
            // 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
            // 서비스에서 반환된 파일명 받아오기
            tts = ttsService.clovaTextToSpeech(filePathName, country);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tts;
    }
}