package project.interview.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class XMLParsing {
	
	String value = "<catalog><book id=\"bk101\"><author>Gambardella, Matthew</author><title>XML Developer's Guide</title><genre>Computer</genre><price>44.95</price><publish_date>2000-10-01</publish_date><description>An in-depth look at creating applications with XML.</description></book></catalog>";
	@Test 
	public void getResponse() throws Exception{
		URL url = new URL("http://example.com/");
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); // PUT is another valid option
		http.setDoOutput(true);
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://example.com/");
		StringEntity entity = new StringEntity(value);
		entity.setContentType("application/xml");
		entity.setChunked(true);
		post.setEntity(entity);
		HttpResponse response = client.execute(post);
		HttpEntity hEntity = response.getEntity();
		
		System.out.println("Contents below:\n");
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(EntityUtils.toString(hEntity));
	}

}
