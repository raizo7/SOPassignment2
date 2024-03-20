package microservice65;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.apache.commons.lang3.SystemUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import microservice65.part1.part11.*;
import microservice65.part2.ModuleCode;
import microservice65.part2.Module;


public class Microservice65Service {
	private static final String PATH = SystemUtils.OS_NAME.startsWith("Windows") ? "src\\main\\resources\\Students.json" : "src/main/resources/Students.json";
	public Response register(RegisterRequest c) throws IOException{
		 Response responseCode = new Response();
		 ObjectMapper mapper = new ObjectMapper();
		 File file = new File(PATH);
		 Students students = null;
		 int studentID = c.getStudentID();
		 Student newStudent = new Student(studentID);
		 try {
			 if(file.exists()) {
					FileInputStream fstream = new FileInputStream(PATH);

					DataInputStream in = new DataInputStream(fstream);

					BufferedReader br = new BufferedReader(new InputStreamReader(in));

					String jsonString = "", strLine = null;

					while((strLine = br.readLine()) != null) jsonString += strLine;

					br.close();

					in.close();

					fstream.close();
					
					students = mapper.readValue(jsonString, Students.class);
			 }else {
				 students = new Students();
			 }
			 boolean added = students.addStudent(newStudent);
		        if (!added) {
		            boolean studentExists = false;
		            for (Student student : students.getStudents()) {
		            	 if (student != null && student.getStudentId() == studentID) {
		                     studentExists = true;
		                     break;
		                 }
		            }
		            if (studentExists) {
		                // Student already exists
		                responseCode.setResponseCode(4);
		            } else {
		                // Array must be full since the student doesn't exist and couldn't be added
		                responseCode.setResponseCode(3);
		            }
		        } else {
		          
		            String jsonString = mapper.writeValueAsString(students);
		            try (BufferedWriter output = new BufferedWriter(new FileWriter(PATH))) {
		                output.write(jsonString);
		                output.close();
		            }
		            responseCode.setResponseCode(0); 
		        }
					
		 }catch (Exception ex) {
		        responseCode.setResponseCode(-1); 
		    }

		    return responseCode;
		 
}
	public Response enrol(ModuleRequest request) {
        Response response = new Response();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(PATH);
        
        try {
            Students students;
            if (file.exists()) {
            	FileInputStream fstream = new FileInputStream(PATH);

				DataInputStream in = new DataInputStream(fstream);

				BufferedReader br = new BufferedReader(new InputStreamReader(in));

				String jsonString = "", strLine = null;

				while((strLine = br.readLine()) != null) jsonString += strLine;

				br.close();

				in.close();

				fstream.close();
				students = mapper.readValue(jsonString, Students.class);
            } else {
                response.setResponseCode(5); // The file does not exist.
                return response;
            }

            boolean foundStudent = false;
            boolean moduleAdded = false;
            for (Student s : students.getStudents()) {
                if (s != null && s.getStudentId() == request.getId()) {
                    foundStudent = true;

                    // Check if the student is already associated with this module code
                    for (ModuleCode mc : s.getModuleCodes()) {
                        if (mc == request.getModuleCode()) {
                            response.setResponseCode(7); // User is already associated with this module code
                            return response;
                        }
                    }

                    // Try to add the module and module code
                    boolean addedCode = s.addModuleCode(request.getModuleCode());
                    boolean addedModule = s.addModule(new Module(request.getModuleCode()));
                    moduleAdded = addedCode && addedModule;
                    
                    break; // Stop searching after finding the student
                }
            }

            if (!foundStudent) {
                response.setResponseCode(6); // The user does not exist in the system
                return response;
            } else if (!moduleAdded) {
                response.setResponseCode(3); // The array is full (no empty position)
                return response;
            } else {
                // Successfully added, now serialize back to JSON
                mapper.writeValue(file, students);
                response.setResponseCode(0); // Successful execution
            }
        } catch (Exception e) {
            e.printStackTrace(); // For debugging
            response.setResponseCode(-1); // Exception was caught
        }

        return response;
    }
}

