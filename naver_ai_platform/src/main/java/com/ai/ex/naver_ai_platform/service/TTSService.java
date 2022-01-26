package com.ai.ex.naver_ai_platform.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

@Service
public class TTSService { // 파일 경로 및 언어 전달 받아서, 저장된 파일명 반환
   public String clovaTextToSpeech(String filePathName, String country) {
       String clientId = "";//애플리케이션 클라이언트 아이디값";
       String clientSecret = "";//애플리케이션 클라이언트 시크릿값";
       String voiceFileName = "";
       try {
           // 전달 받은 파일에서 텍스트를 추출하는 함수
           String fileContents = fileRead(filePathName);
           String text = URLEncoder.encode(fileContents, "UTF-8"); // 13자
           String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
           URL url = new URL(apiURL);
           HttpURLConnection con = (HttpURLConnection)url.openConnection();
           con.setRequestMethod("POST");
           con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
           con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
           // post request
           String postParams = "speaker=" + country + "&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
           con.setDoOutput(true);
           DataOutputStream wr = new DataOutputStream(con.getOutputStream());
           wr.writeBytes(postParams);
           wr.flush();
           wr.close();
           int responseCode = con.getResponseCode();
           BufferedReader br;
           if(responseCode==200) { // 정상 호출
               InputStream is = con.getInputStream();
               int read = 0;
               byte[] bytes = new byte[1024];
               // 랜덤한 이름으로 mp3 파일 생성
               String tempname = Long.valueOf(new Date().getTime()).toString();
               voiceFileName = "tts_" + tempname + ".mp3";
               File f = new File("/Users/gobyeongchae/Desktop/" + voiceFileName);
               f.createNewFile();
               OutputStream outputStream = new FileOutputStream(f);
               while ((read =is.read(bytes)) != -1) {
                   outputStream.write(bytes, 0, read);
               }
               is.close();
           } else {  // 오류 발생
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
               String inputLine;
               StringBuffer response = new StringBuffer();
               while ((inputLine = br.readLine()) != null) {
                   response.append(inputLine);
               }
               br.close();
               System.out.println(response.toString());
           }
       } catch (Exception e) {
           System.out.println(e);
       }
       return voiceFileName;
   }

    public String clovaTextToSpeech2(String message) {
        String clientId = "";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "";//애플리케이션 클라이언트 시크릿값";
        String voiceFileName = "";
        try {
            String text = URLEncoder.encode(message, "UTF-8"); // 13자
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "speaker=nara&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 mp3 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                voiceFileName = "tts_" + tempname + ".mp3";
                File f = new File("/Users/gobyeongchae/Desktop/" + voiceFileName);
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return voiceFileName;
    }

   // 파일 경로 전달받아 파일 내용 읽어서 텍스트 반환
    public String fileRead(String filePathName) {
       String result = "";
        try {
            File file = new File(filePathName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}