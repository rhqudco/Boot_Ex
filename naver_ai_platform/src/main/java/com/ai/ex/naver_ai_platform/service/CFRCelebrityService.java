package com.ai.ex.naver_ai_platform.service;

import com.ai.ex.naver_ai_platform.dao.CelebrityVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

@Service
public class CFRCelebrityService {
    public void clovaFaceRecogCel() {
        StringBuffer reqStr = new StringBuffer();
        String clientId = "awb85vfn33";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "01CLEtMaAM1jmjya6WtEV5zEmNUj87TnWmaZdnic";//애플리케이션 클라이언트 시크릿값";

        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = "/Users/gobyeongchae/Desktop/IMG_5387.JPG";
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ArrayList<CelebrityVO> jsonToVo(String jsonResultStr) {
        ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();
        try {
            // JSON 형태의 문자열에서 JSON 오브젝트 "faces" 추출해서 JSONArray에 저장
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonResultStr);
            JSONArray celebrityArray = (JSONArray)jsonObject.get("faces");
            // JSONArray 각 요소에서 value와 confidence 추출하여 VO에 담아서 리스트에 추가
            if(celebrityArray != null) {
                // value와 confidence 추출
                // JSONArray 각 요소에서 value와 confidence 추출
                for(int i = 0; i < celebrityArray.size(); i++) {
                    JSONObject tempObj = (JSONObject)celebrityArray.get(i);
                    tempObj = (JSONObject)tempObj.get("celebrity");
                    String value = (String)tempObj.get("value");
                    double confidence = (double)tempObj.get("confidence");
                    // VO에 저장하여 리스트에 추가
                    CelebrityVO vo = new CelebrityVO();
                    vo.setValue(value);
                    vo.setConfidence(confidence);
                    celList.add(vo);
                }
            }
            else { // 유명인을 찾지 못한 경우 (faces가 빈 배열인 경우)
                CelebrityVO vo = new CelebrityVO();
                vo.setValue("없음");
                vo.setConfidence(0);
                celList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return celList;
    }
}
