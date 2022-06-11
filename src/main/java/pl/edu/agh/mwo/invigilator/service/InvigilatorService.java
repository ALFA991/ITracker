package pl.edu.agh.mwo.invigilator.service;

import lombok.NoArgsConstructor;
import pl.edu.agh.mwo.invigilator.model.Commands;

@NoArgsConstructor
public class InvigilatorService {

    public void startInvigilation(Commands commandToResolve) {
        switch (commandToResolve) {
            case INV1: {
                System.out.println("Wybrano raport 1. Jest w trakcie implementacji");
                break;
            }
            case INV2: {
                System.out.println("Wybrano raport 2. Jest w trakcie implementacji");
                break;
            }
            case INV3: {
                System.out.println("Wybrano raport 3. Jest w trakcie implementacji");
                break;
            }
            case HELP: {
                System.out.println("Aby wybrać raport, który wypisuje osoby i ilość godzin, wpisz: inv1");
                System.out.println("Aby wybrać raport, który wypisuje projekt i ilość godzin, wpisz: inv2");
                System.out.println("Aby wybrać raport, który zestawia pracownika, projekt i ilość godzin, wpisz: inv3");
                break;
            }
        }
    }
}
