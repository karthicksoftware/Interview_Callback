package project.interview.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsonParsingTest1 {

	// String url = "http://services.groupkt.com/state/get/IND/TN";
	String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";

	public String jsonParsing() throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		request.addHeader("accept", "application/json");
		HttpResponse response = client.execute(request);
		String line = "";
		StringBuilder output = new StringBuilder();
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code : " + statusCode);
		if (statusCode == 200) {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
				while ((line = reader.readLine()) != null) {
					output.append(line + "\n");
				}
			}
		} else {
			Assert.assertTrue(false, "Failed due to this status code - " + statusCode);
		}
		return String.valueOf(output);
	}

	/*
	 * { "RestResponse" : { "messages" : [
	 * "More webservices are available at http://www.groupkt.com/post/f2129b88/services.htm"
	 * , "State found matching code [TN]." ], "result" : { "country" : "IND",
	 * "name" : "Tamil Nadu", "abbr" : "TN", "area" : "130058SKM", "capital" :
	 * "Chennai" } } }
	 */
	@Test(enabled = false)
	public void jsonTest() throws Exception {
		JSONObject jo = new JSONObject(jsonParsing());
		JSONArray ja = jo.getJSONObject("RestResponse").getJSONArray("messages");
		System.out.println(ja);
		jo = jo.getJSONObject("RestResponse").getJSONObject("result");
		System.out.println(jo);
		List<String> objects = Arrays
				.asList(jo.toString().substring(jo.toString().indexOf("{") + 1, jo.toString().indexOf("}")).split(","));
		// objects.forEach(karthick->System.out.println(karthick));
		objects.forEach(System.out::println);
		Map<String, String> map = new TreeMap<String, String>();
		for (String obj : objects) {
			map.put(obj.split(":")[0], obj.split(":")[1]);
		}
		for (Map.Entry<String, String> mp : map.entrySet()) {
			System.out.println("Key - " + mp.getKey() + "   " + "Value - " + mp.getValue());
		}
		Assert.assertTrue(map.containsKey("\"area\""));
	}

	@Test(enabled = false)
	public void playWithArrays() throws Exception {
		JSONObject obj = new JSONObject(jsonParsing());
		JSONArray arr = obj.getJSONArray("worldpopulation");
		obj = arr.getJSONObject(1);
		List<String> items = Arrays.asList(obj.toString().substring(1, obj.toString().length() - 1).split(",\""));
		Map<String, String> mp = new HashMap<String, String>();
		for (String item : items) {
			// System.out.println(item);
			mp.put(item.split("\":")[0], item.split("\":")[1]);
		}

		for (Map.Entry<String, String> m : mp.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
		System.out.println();
		System.out.println(obj.getInt("rank"));
	}

	@Test(dataProvider = "crawling", threadPoolSize = 10, invocationCount=10)
	public void launchURLs(String url) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		System.out.println("Launching > " + url);
		Assert.assertTrue(true);
		driver.quit();
		System.out.println("Done");
	}

	@DataProvider(parallel = true)
	public Object[][] crawling() throws Exception {
		JSONObject obj = new JSONObject(jsonParsing());
		JSONArray arr = obj.getJSONArray("worldpopulation");
		List<String> urls = new LinkedList<String>();
		for (int i = 0; i < arr.length(); i++) {
			JSONObject arrObj = arr.getJSONObject(i);
			urls.add(arrObj.getString("flag"));
		}
		Object[][] data = new Object[urls.size()][1];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = urls.get(i);
		}		
		return data;
	}

}
