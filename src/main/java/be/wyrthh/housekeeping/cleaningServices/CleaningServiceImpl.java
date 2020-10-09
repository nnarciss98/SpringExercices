package be.wyrthh.housekeeping.cleaningServices;

public class CleaningServiceImpl implements CleaningService {

    CleaningTool cleaningTool;

    public CleaningTool getCleaningTool() {
        return cleaningTool;
    }

    public CleaningServiceImpl setCleaningTool(CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
        return this;
    }

    public void cleaning(){
        cleaningTool.use();
    }

}
