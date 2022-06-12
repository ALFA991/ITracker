package pl.edu.agh.mwo.itracker;

import pl.edu.agh.mwo.itracker.service.ITrackerService;
import pl.edu.agh.mwo.itracker.service.Utils;

import java.io.FileNotFoundException;

public class ITracker {

    public static void main(String[] args) throws FileNotFoundException {
        ITrackerService ITrackerService = new ITrackerService();
        if (args.length > 4 || args.length == 0) {
            throw new IllegalStateException("Bad command");
        } else if (args.length == 2) {
            ITrackerService.startTracking(Utils.parseCommandToConstant(args[0]), args[1], "", "");
        } else if (args.length == 3) {
            ITrackerService.startTracking(Utils.parseCommandToConstant(args[0]), args[1], args[2], "");
        } else if (args.length == 4) {
            ITrackerService.startTracking(Utils.parseCommandToConstant(args[0]), args[1], args[2], args[3]);
        } else {
            ITrackerService.startTracking(Utils.parseCommandToConstant(args[0]), "", "", "");
        }
    }
}
