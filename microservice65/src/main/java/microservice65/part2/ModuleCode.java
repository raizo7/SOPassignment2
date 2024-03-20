package microservice65.part2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public enum ModuleCode{
	   CSC1022, CSC1023, CSC1024, CSC1025, CSC1026, CSC1027, CSC1028, CSC1029,
	      CSC1030, CSC1031
	}
