package User;
import java.util.Scanner;


//This is a interface class
//The purpose of this class was to ensure every input from the user was correctly inputted.
//If not the user had to reinput the information neeeded.

public interface inputValidate {
    //These are the methods from the interface. 
    String FLName(String input);
    String DateValid(String input);
    String EmailValid(String input);
    String PhoneValid(String input);
    String HouseValid(String input);
    int ChoiceValid(int input);
    String partOfDay(String day);
    int hourValid(int hour, String part);
    int minuteValid(int time);
}

class Check implements inputValidate {
    
    Scanner sc = new Scanner(System.in); //Create a scanner. 

    //LEARN REGEX FUTURE GIAN

    public String FLName(String input) { //This method was to ensure the names was correctly inputted. 
        while(!input.matches("^[a-zA-Z]+$")) { //In the parameter it is know as regex. To only have characters. No numbers
            System.out.println("Please enter your information correctly. "); 
            input = sc.next();
            sc.nextLine(); 
        }
        return input;
    }

    public String DateValid(String input) { //Another method. To ensure the date is correctly made. 
        //This regex, is only supposed to work for the user to not enter fake dates. Such as 3/41/3044
        while(!(input.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/[0-9]{4}$"))) { 
            System.out.println("Please enter the correct date format. (MM/DD/YYYY)");
            input = sc.nextLine();   
        }
        return input;
    }

    public String EmailValid(String input) { //To ensure that email is valid. 
        while(!input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) { //The email must contain letters, @ and . in order to work. 
        System.out.println("Please enter the correct email address. ");
            input = sc.nextLine();
        }
        return input;
    }

    public String PhoneValid(String input) {
        while(!input.matches("^\\d{3}-\\d{3}-\\d{4}$")) { //Making sure the phone number has 3 digits between each "-" and last 4
            System.out.println("Please enter your phone number correctly.");
            input = sc.nextLine();
        }
        return input;
    }

    public String HouseValid(String input) {

        while(!input.matches("^[A-Za-z0-9 ,.-]+$")) { //Ensuring that it has numbers and letters.
            System.out.println("Please enter a valid House address");
            input = sc.nextLine();
        }
        return input;
    }

    public int ChoiceValid(int input) { //Ensuring the users input between 1-7
        while(!(input > 0 && input <= 7)) {
            System.out.println("Please enter between 1-7 from the following options.");
            input = sc.nextInt();
            sc.nextLine();
        }
        if(input == 7) {
            System.exit(0); //If users selects 7 then the program ends. 
        }
        return input;
    }

    public String partOfDay(String day) {

        String morning = "Morning";
        String Afternoon = "Afternoon";
        boolean isEqual1;
        boolean isEqual2;

        if(isEqual1 = day.equals(morning)); //Comparing the strings. 
        if(isEqual2 = day.equals(Afternoon));

        if(!(day.equals(morning)) && !(day.equals(Afternoon))) { //And if non them are equaled it activated the if statement. 
            System.out.println("Please enter (Morning) or (Afternoon)");
            day = sc.nextLine();
            isEqual1 = day.equals(morning);
            isEqual2 = day.equals(Afternoon);
        }

        return day;
    }
    
    public int hourValid(int hour, String part) {
        
        String morning = "Morning";
        String Afternoon = "Afternoon";
        boolean isEqual1;
        boolean isEqual2; //Same as before but whichover "isEqual" is true then the while loop would be activated. 

        if(isEqual1 = part.equals(morning));
        if(isEqual2 = part.equals(Afternoon));

        while(isEqual1) {
            if(hour >= 5 && hour <= 11) { //If it is equal 1 then the morning it is so we are ensure it is only from 5AM -11AM
                break;
            }
            else {
                System.out.println("Please enter the correct hour for morning.");
                hour = sc.nextInt();
                sc.nextLine(); 
            }
        }
        while(isEqual2) { //If it is not equal1 then it is equal2 and ensuring that the user the time must be from 1PM - 6PM
            if(hour >= 1 && hour <= 6) {
                break;
            }
            else {
                System.out.println("Please enter the correct hour for Afternoon.");
                hour = sc.nextInt();
            }
        }
        return hour;
    }

    public int minuteValid(int time) {
        while(!(time >= 0 && time <=59)) { //Ensuring the users minute is either from 0 - 59.
            System.out.println("Please enter the correct minute.");
            System.out.print("Must be from 00-59: ");
            time = sc.nextInt();
            sc.nextLine(); 
        }
        return time;
    }

}

