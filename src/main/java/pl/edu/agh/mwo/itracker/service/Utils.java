package pl.edu.agh.mwo.itracker.service;

import pl.edu.agh.mwo.itracker.model.Commands;

public interface Utils {

    static Commands parseCommandToConstant(String commandFromCommandLine) {
        switch (commandFromCommandLine) {
            case "inv1": {
                return Commands.INV1;
            }
            case "inv2": {
                return Commands.INV2;
            }
            case "inv3": {
                return Commands.INV3;
            }
            case "h": {
                return Commands.HELP;
            }
            default: throw new IllegalStateException("Command not recognized");
        }
    }
}
