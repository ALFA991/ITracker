package pl.edu.agh.mwo.itracker;

import pl.edu.agh.mwo.itracker.service.ITrackerService;
import pl.edu.agh.mwo.itracker.service.Utils;

public class ITracker {

    public static void main(String[] args) {
        ITrackerService ITrackerService = new ITrackerService();
        if (args.length > 2 || args.length == 0) {
            throw new IllegalStateException("Bad command");
        } else if (args.length > 1) {
            ITrackerService.startTracking(Utils.parseCommandToConstant(args[0]), args[1]);
        } else {
            ITrackerService.startTracking(Utils.parseCommandToConstant(args[0]), "");
        }
    }
}
