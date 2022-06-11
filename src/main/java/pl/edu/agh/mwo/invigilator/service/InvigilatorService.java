package pl.edu.agh.mwo.invigilator.service;

import lombok.NoArgsConstructor;
import pl.edu.agh.mwo.invigilator.model.Commands;

@NoArgsConstructor
public class InvigilatorService {

    public void startInvigilation(Commands commandToResolve) {
        switch (commandToResolve) {
            case INV1: {
                System.out.println("Wybrano raport 1. Jest w trakcie implementacji");
            }
            case INV2: {
                System.out.println("Wybrano raport 2. Jest w trakcie implementacji");
            }
            case INV3: {
                System.out.println("Wybrano raport 3. Jest w trakcie implementacji");
            }
            case HELP: {
                System.out.println("Wybrano pomoc. Jest w trakcie implementacji");
            }
        }
    }
}
