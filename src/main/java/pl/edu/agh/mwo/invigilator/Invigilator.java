package pl.edu.agh.mwo.invigilator;

import pl.edu.agh.mwo.invigilator.service.InvigilatorService;
import pl.edu.agh.mwo.invigilator.service.Utils;

public class Invigilator {

    public static void main(String[] args) {
        InvigilatorService invigilatorService = new InvigilatorService();
        if (args.length > 2 || args.length == 0) {
            throw new IllegalStateException("Bad command");
        } else if (args.length > 1) {
            invigilatorService.startInvigilation(Utils.parseCommandToConstant(args[0]), args[1]);
        } else {
            invigilatorService.startInvigilation(Utils.parseCommandToConstant(args[0]), "");
        }
    }
}
