package microservice65;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;

class ServiceEndpointsTests {
	
	void registerNullPostRequest(String uri) {
		Response response = new HttpPostWrapper().execute(uri, null);
		System.out.println("Response = " + response);
		assertFalse(response == null);
	}
	
	
	void registerNonExistingStudentPostRequest(String uri) throws Exception {
        RegisterRequest obj = new RegisterRequest();
        obj.setStudentID(1);
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(obj);
        
        Response responseStr = new HttpPostWrapper().execute(uri, requestBody);
        System.out.println("Response = " + responseStr);
        
        String jsonResponseString = mapper.writeValueAsString(responseStr);
        Response response = mapper.readValue(jsonResponseString, Response.class);
        
        boolean studentNotExist = (response.getResponseCode() == 4); 
        
        assertTrue(studentNotExist, "Expected a non-existing student response code");
    }
	
//	void registerNonExistingStudentPostRequest(String uri) throws Exception{
//		RegisterRequest obj = new RegisterRequest();
//		obj.setStudentID(1);
//		ObjectMapper mapper = new ObjectMapper();
//		String requestBody = mapper.writeValueAsString(obj);
//		Response responseStr = new HttpPostWrapper().execute(uri, requestBody);
//		System.out.println("Response = " + responseStr);
//		
//		String jsonResponseString = mapper.writeValueAsString(responseStr);
//		Response response = mapper.readValue(jsonResponseString, Response.class);
//		
//		boolean studentNotExist = false;
//		if (response.getResponseCode()==6) {
//			studentNotExist = true;
//		}
//		assertTrue(studentNotExist);
//	}
	
	void registerExistingStudentPostRequest() {
		
	}
//	 
}
