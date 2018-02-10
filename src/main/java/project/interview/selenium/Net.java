package project.interview.selenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;
 
public class Net {
 
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";
 
    public void post(String url, String params) throws Exception {
    String result = null;
 
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
 
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(params);
    wr.flush();
    wr.close();
 
    int responseCode = con.getResponseCode();
    System.out.println("'POST' request to URL : " + url);
    System.out.println("Response Code : " + responseCode);
 
    System.out.println("Response Body : ");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
 
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
 
    result = response.toString();
    System.out.println(result);
 
    }
 
    public void get(String url, String params) throws Exception {
    String result = null;
 
    URL obj = new URL(url + "?" + params);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
    con.setRequestMethod("GET");
 
    con.setRequestProperty("User-Agent", USER_AGENT);
 
    int responseCode = con.getResponseCode();
    System.out.println("'GET' request to URL : " + url);
    System.out.println("Response Code : " + responseCode);
 
    System.out.println("Response Body : ");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
 
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
 
    result = response.toString();
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"\\logs.txt"));
	bw.write(result);
    }
 
    @Test
    public void somemethod() {
    try {
        Net example = new Net();
        String getUrl = "https://lottods.qa.pch.com";
 
        System.out.println("HttpURLConnection Examples:");
        System.out.println();
        example.get(getUrl, null);
        System.out.println();
 
        /*String postUrl = "https://lottods.qa.pch.com";
        example.post(postUrl, null);*/
 
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}

