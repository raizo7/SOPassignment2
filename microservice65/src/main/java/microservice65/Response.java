package microservice65;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Response {
	private int code;
	public void setResponseCode(int code) {
		this.code = code;
	}
	public int getResponseCode() {
		return code;
	}
}
