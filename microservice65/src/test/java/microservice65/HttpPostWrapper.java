package microservice65;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

class HttpPostWrapper {
	Response execute(String uri, String requestBody) {
		Response responseCode = new Response();
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost(uri);
			StringEntity input = new StringEntity(requestBody);
			input.setContentType("application/json");
			post.setEntity(input);
			
			CloseableHttpResponse response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("Status code of POST request = " + statusCode);
			if(statusCode != 200) {
				responseCode.setResponseCode(-1);
			};
		
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder responseStr = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                responseStr.append(line);
            }
			rd.close();
			response.close();
			client.close();
			return responseCode;
			
		}
		catch(Exception ex) { 
			responseCode.setResponseCode(-1);
			return responseCode;
		}
	}
}
