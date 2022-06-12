package pl.edu.agh.mwo.itracker.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import pl.edu.agh.mwo.itracker.model.Commands;

import java.util.Date;

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

    static boolean checkIfFilterDate(Cell dateToCheck, String from, String to) {
        if (dateToCheck.getCellType().equals(CellType.NUMERIC)) {
            Date recordDate = dateToCheck.getDateCellValue();
            if (from.isBlank() && to.isBlank()) {
                return false;
            } else if (to.isBlank() && !from.isBlank()) {
                return (recordDate.getMonth() + 1) == Integer.parseInt(from);
            } else if (recordDate.getMonth() <= Integer.parseInt(to) && recordDate.getMonth() >= Integer.parseInt(from)) {
                return false;
            }
        }
        return true;
    }
}
