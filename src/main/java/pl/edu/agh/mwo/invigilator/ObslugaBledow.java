package pl.edu.agh.mwo.invigilator;

import java.util.List;
import java.util.stream.Collectors;

public class ObslugaBledow {

	public static boolean main(String[] args) {

		// puste pole
		//zadanie - ma byc jednym z listy
		//czas ma byc w doublach - bez stringow
		//suma pracownik na dzien nie wiekszy niz 40 godzin


		//data ma by w odpowiednim formacie --https://stackoverflow.com/questions/2149680/regex-date-format-validation-on-java

//if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
//    ...
//}

//DATA
		String date = "20/01/2022";

			if (date.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-](\\d{4})$")){
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		String regex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-](\\d{4})$";
		DateChecker dc = new DateChecker(regex);
		System.out.println(dc.check(date));


//TIME SPENT
		var timeCheck = Employee.getTimeSpent();
		if(!timeCheck.getClass()==Integer.class){
			System.out.println("number format to be applied for time spent");
		}

//TIME SPENT PER EMPLOYEE - once report is generated
		public boolean checkTotHrsPerDay(Employee employee){

		return StreamOf(Employees).collect(Collectors.groupingBy(Employee::employee), Collectors.groupingBy(Employee::getDate), Collectors.summarizingInt(Employee::getTimeSpent))>=8;
		}


//TYPE of tasks
		public boolean checkTaskInList(){
			List<String> taskList = List.of(new String[]{"Spotkanie", "Analiza"});

			for (int i = 0; i < employees.length(); i++) {
				for (int j = 0; j < employees.getTaskList.length(); j++) {
					if (taskList.contains(employees.getTaskList[j])) {
						return true;
					}
				}return false;
			}
			return false;
		}

	}
}
