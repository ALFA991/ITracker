package pl.edu.agh.mwo.invigilator;

import pl.edu.agh.mwo.invigilator.service.InvigilatorService;
import pl.edu.agh.mwo.invigilator.service.Utils;

public class Invigilator {

    public static void main(String[] args) {
        InvigilatorService invigilatorService = new InvigilatorService();
        if (args.length > 1) {
            throw new IllegalStateException("Bad command");
        } else {
            invigilatorService.startInvigilation(Utils.parseCommandToConstant(args[0]));
        }
    }
}
