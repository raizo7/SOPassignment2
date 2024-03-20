package microservice65;

import microservice65.part2.ModuleCode;

public class ModuleRequest {
    private int id;
    private ModuleCode moduleCode;

    // Constructor, getters, and setters
    ModuleRequest() {}

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    ModuleCode getModuleCode() {
        return moduleCode;
    }

     void setModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }
}
