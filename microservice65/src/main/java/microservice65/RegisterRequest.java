package microservice65;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RegisterRequest {
	private int id;
	
	void setStudentID(int id) {
		this.id = id;
	}
	
	int getStudentID() {
		return id;
	}
}
