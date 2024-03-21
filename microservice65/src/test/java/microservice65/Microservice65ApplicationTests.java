package microservice65;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Microservice65ApplicationTests {

	@Test
	void contextLoads() throws Exception {
		Microservice65Application.deploy();
		ServiceEndpointsTests tests = new ServiceEndpointsTests();
		String baseUri = "http://localhost:8081/microservice65";
		tests.registerNullPostRequest(baseUri + "/register");
		tests.registerNonExistingStudentPostRequest(baseUri + "/register");
		tests.registerExistingStudentPostRequest(baseUri+ "/register");
		tests.enrolNullPostRequest(baseUri+ "/enrol");
		tests.enrolNonExistingFilePostRequest(baseUri+ "/enrol");
	}

}
