package pl.edu.agh.mwo.itracker.service;

import pl.edu.agh.mwo.itracker.model.Commands;

public interface Utils {

    static Commands parseCommandToConstant(String commandFromCommandLine) {
        switch (commandFromCommandLine) {
            case "rap1": {
                return Commands.RAP1;
            }
            case "rap2": {
                return Commands.RAP2;
            }
            case "rap3": {
                return Commands.RAP3;
            }
            case "h": {
                return Commands.HELP;
            }
            default: throw new IllegalStateException("Command not recognized");
        }
    }
}
