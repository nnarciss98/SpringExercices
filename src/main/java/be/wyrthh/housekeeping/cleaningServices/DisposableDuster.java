package be.wyrthh.housekeeping.cleaningServices;

public class DisposableDuster implements CleaningTool {

    private boolean used = false;

    public void use() {
        if (used) {
            System.out.println("Eeeewww, this is an already used duster...");
        }
        else {
            System.out.println("Dusting the dust away (:");
            used = true;
        }
    }
}
