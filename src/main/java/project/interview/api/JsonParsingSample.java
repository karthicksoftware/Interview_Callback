package project.interview.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class JsonParsingSample {

		static String url = "https://httpbin.org/get?show_env=1";
		@Test
		public void getResponse() throws IOException, JSONException {

			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);
			request.addHeader("accept", "application/json");

			/*
			 * HttpPost post = new HttpPost(url); StringEntity entity = new
			 * StringEntity("{\"Name\":\"Karthick\"},\"Age\":23}");
			 * entity.setContentType("application\\json");
			 * post.setEntity(entity);
			 */

			HttpResponse response = client.execute(request);
			System.out.println("Status code : " + response.getStatusLine().getStatusCode());
			BufferedReader data = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = data.readLine()) != null) {
				result.append(line + "\n");
			}
			System.out.println(result);
			
			/*{
	            "args": {
	            "show_env": "1"
	        },
	            "headers": {
	            "Accept": "application/json",
	                    "Accept-Encoding": "gzip,deflate",
	                    "Host": "httpbin.org",
	                    "Runscope-Service": "httpbin",
	                    "User-Agent": "Apache-HttpClient/4.5.2 (Java/1.8.0_111)",
	                    "X-Forwarded-For": "182.73.143.158",
	                    "X-Forwarded-Protocol": "https",
	                    "X-Forwarded-Ssl": "on",
	                    "X-Real-Ip": "182.73.143.158"
	        },
	            "origin": "182.73.143.158",
	                "url": "https://httpbin.org/get?show_env=1"
	        }*/

			JSONObject obj = new JSONObject(result.toString());
			System.out.println(obj.getJSONObject("headers").toString());
			String prop = obj.getJSONObject("headers").toString();
			// System.out.println(prop);
			List<String> items = Arrays.asList(prop.split("\","));
			Map<String, String> map = new HashMap<String, String>();
			for (String item : items) {
				map.put(item.replace("{", "").replace("}", "").replace("\"", "").split(":")[0],
						item.replace("{", "").replace("}", "").replace("\"", "").split(":")[1]);
			}
			System.out.println("Size of the map : " + map.size());
			for (Map.Entry item : map.entrySet()) {
				System.out.println("Key : " + item.getKey() + " , Value : " + item.getValue().toString());
			}
		}
	}
