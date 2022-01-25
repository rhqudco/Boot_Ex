package com.ai.ex.naver_ai_platform.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Service
public class STTService2 {
    public String clovaSpeechToText(String filePathName, String language) {
        String clientId = "";             // Application Client ID";
        String clientSecret = "";     // Application Client Secret";
        String resultText = "";
        try {
            String imgFile = filePathName;
            File voiceFile = new File(imgFile);

            //String language = SelLanguage;        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                resultText = jsonToString(response.toString());
                resultToFileSave(resultText); // 파일로 저장
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultText;
    }

    public String jsonToString(String jsonResultStr) {
        String resultText = "";
        try {
            JSONObject jsonObject = new JSONObject(jsonResultStr);
            resultText = (String)jsonObject.get("text");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultText;
    }
    // 음성 파일에서 추출한 텍스트 파일로 저장
    public void resultToFileSave(String result) {
        try {
            String fileName = Long.valueOf(new Date().getTime()).toString();
            String filePathName = "/Users/gobyeongchae/Desktop/voice/" + "stt2_" + fileName + ".txt";

            FileWriter fw = new FileWriter(filePathName);
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}