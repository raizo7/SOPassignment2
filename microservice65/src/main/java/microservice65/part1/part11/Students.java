package microservice65.part1.part11;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Students {
	private Student[] students=new Student[3];
	
	public Students() {}
	
	public Student[] getStudents() {
		return students;
	}
	
	public boolean addStudent(Student newStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getStudentId() == newStudent.getStudentId()) {
               
                return false;
            }
        }
        
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudent;
                return true; 
            }
        }
        
        return false;
    }
	
	
	
}
