package microservice65.part1.part11;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import microservice65.part2.ModuleCode;
import microservice65.part2.Module;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Student {
	private int id;
	private ModuleCode[] moduleCodes = new ModuleCode[2]; // Array with a maximum length of 2
    private Module[] modules = new Module[2]; // Array with a maximum length of 2
	
	Student(){}
	
	public Student(int id){
		this.id = id;
	}
	
	void setStudentId(int id) {
		this.id = id;
	}
	
	public int getStudentId() {
		return id;
	}
	
	// Adds a single module code, ensuring not to exceed array length
    public boolean addModuleCode(ModuleCode moduleCode) {
        for (int i = 0; i < moduleCodes.length; i++) {
            if (moduleCodes[i] == null) { // Find the first null spot
                moduleCodes[i] = moduleCode;
                return true; // Successfully added
            }
        }
        // If no spots were null, array is full
        return false;
    }

    // Adds a single module, ensuring not to exceed array length
    public boolean addModule(Module module) {
    	for (int i = 0; i < modules.length; i++) {
    		if (modules[i] == null) { // Find the first null spot
    		modules[i] = module;
    		return true; // Successfully added
    		}
    		}
    		// If no spots were null, array is full
    		return false;
    		}

    // ModuleCodes getter
    public ModuleCode[] getModuleCodes() {
        return moduleCodes;
    }

   

    // Modules getter
    public Module[] getModules() {
        return modules;
    }
}
