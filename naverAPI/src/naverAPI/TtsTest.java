package naverAPI;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class TtsTest {
	public static void main(String[] args) {
        String clientId = "ae04cl80or";
        String clientSecret = "iOE185WnowDox1JFX9AVgY0iqNl815EDLV9FBr4X";
        try {
            String text = URLEncoder.encode("안녕하세요 저는 AI Platform 기반의 지능형 서비스 개발 프로젝트"
            		+ "11회차 K반 김태은입니다. 이것은 과정 실습평가 샘플 음성입니다 이 음성 인식 결과가 텍스트로 출력될"
            		+ "것입니다", "UTF-8"); 
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "speaker=nara&speed=0&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { 
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];

//                String tempname = Long.valueOf(new Date().getTime()).toString();
//                File f = new File(tempname + ".mp3");
                File f = new File("sample2.wav");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else { 
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
    }
}
