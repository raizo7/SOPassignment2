package microservice65.part2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Module {
    private ModuleCode moduleCode;

    public Module() {}
    public Module(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    
}
