package microservice65;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.apache.commons.lang3.SystemUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import microservice65.part2.ModuleCode;

class ServiceEndpointsTests {
	private static final String PATH = SystemUtils.OS_NAME.startsWith("Windows") ? "src\\main\\resources\\Students.json" : "src/main/resources/Students.json";
	File fileToDelete = new File(PATH);
	
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
        System.out.println(response.getResponseCode());
        assertTrue(response.getResponseCode() == -1);
    }
	
	void registerExistingStudentPostRequest(String uri) throws Exception{
		RegisterRequest obj = new RegisterRequest();
        obj.setStudentID(1);
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(obj);
        
        Response responseStr = new HttpPostWrapper().execute(uri, requestBody);
        System.out.println("Response = " + responseStr);
        
        String jsonResponseString = mapper.writeValueAsString(responseStr);
        Response response = mapper.readValue(jsonResponseString, Response.class);
        
        assertTrue(response.getResponseCode() == -1);
	}
	
	void enrolNullPostRequest(String uri) {
		Response response = new HttpPostWrapper().execute(uri, null);
		System.out.println("Response = " + response);
		assertFalse(response == null);
	}
	
	void enrolNonExistingFilePostRequest(String uri) throws Exception{
		ModuleRequest obj = new ModuleRequest();
		obj.setId(1);
		obj.setModuleCode(ModuleCode.CSC1022);
		
		ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(obj);
        
        Response responseStr = new HttpPostWrapper().execute(uri, requestBody);
        System.out.println("Response = " + responseStr);
        
        String jsonResponseString = mapper.writeValueAsString(responseStr);
        Response response = mapper.readValue(jsonResponseString, Response.class);
        
        assertTrue(response.getResponseCode() == -1);
	}
}
