package User;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Create a class to use the switch method.

public class Main {
    public static void main(String[] args) throws Exception {
        
        //First we are welcoming the user.
        System.out.println("Hello Welcome to Laura's Cleaning Services.");
        System.out.println("May we please get your information to get started.");

        //Creating a scanner to get the users input throughout the program. 
        Scanner sc = new Scanner(System.in);

        //Created this class to ensure the users input is correct.
        inputValidate check = new Check();
        
        System.out.println();

        //Creating the strings for first name and last name.
        System.out.print("First name: ");
        String fname;
        fname = sc.nextLine(); 
        fname = check.FLName(fname); //Sending this to the interface class to check users input

        System.out.println();

        //Asking the user for his last name. 
        System.out.print("Last name: ");
        String lname;
        lname = sc.nextLine();
        lname = check.FLName(lname);
        //Calling the interface to ensure the user input is valid
        System.out.println();

        System.out.println("Please answer the following.");
        
        System.out.println();


        //Asking user to enter his email.
        System.out.print("Please enter your email: ");
        String emailString = sc.nextLine();
        emailString = check.EmailValid(emailString); //Checking users email.
        
        System.out.println();
        

        //Asking the user for phone number
        System.out.println("Please enter your phone number: \nIn format of ###-###-####: ");
        String phoneNumber = sc.nextLine();
        phoneNumber = check.PhoneValid(phoneNumber); //Checking users phone numbers is correct. 
        
        System.out.println();



        //Asking the user for the address.
        System.out.print("Please enter your house address: ");
        String houseAddress = sc.nextLine();
        houseAddress = check.HouseValid(houseAddress); //Checking the users Address

        System.out.println();

        //First we are securing the users information into a class with private atributes.
        personalInformation display = new personalInformation(emailString, phoneNumber, houseAddress, fname, lname);

        display.displayName(); //We are displaying the users Name and information
        display.displaypersonalInformation(); 

        System.out.println();

        //Created a class for the menu to show to the user. 
        Menu getMenu = new Menu();

        String[]List = { 
            "1. Standared Clean. One Floor: $150.00",  "2. Standared Clean. Two Floors: $250.00",
            "3. Deep Clean: One Floor: $300.00", "4. Deep Clean: Two Floors: $400.00",
            "5. Move-in/Move-out: One Floor: $250.00", "6. Move-in/Move-out: Two Floors: $350.00",
            "7. Quit"
        };

        getMenu.showMenu(List); //call the showMenu class to show the menu. 
        
        int offMenu; //This variable is to user selection.
        offMenu = sc.nextInt(); //Get users selection.
        offMenu = check.ChoiceValid(offMenu);
        sc.nextLine(); 
        double cost = 0.0; //Created this variable to get the cost of it. 

        cost = getMenu.getChoice(offMenu, cost); //Getting the cost from this class.
        
        
        System.out.println();

        //Asking the user to set the date.
        System.out.println("Please enter the best date that is best for you to set your appointment.");
        System.out.println();

        //Explaining the format.
        System.out.print("In the format of (MM/DD/YYYY): ");
        String date = sc.next(); 
        sc.nextLine(); 
        
        date = check.DateValid(date); //Calling the function to ensure it is used correctly.

        System.out.println();


        //Time.
        System.out.println("Hours: Morrning 5AM-11AM. Afternoon 1PM-6PM");
        System.out.print("Morning or Afternoon: ");
        String part_day = sc.next();
        part_day = check.partOfDay(part_day); //Checking the users input. 

        System.out.println();

        System.out.print("Hour: ");
        int hour  = sc.nextInt();
        sc.nextLine(); 
        hour = check.hourValid(hour, part_day); //Checking users input. 
        
        
        System.out.print("Minute: "); 
        int minute = sc.nextInt();
        sc.nextLine(); 
        minute = check.minuteValid(minute); //Checking users input. 


        System.out.println("Here were your choices and appointment.");
        userAppointment app = new userAppointment(offMenu, date, hour, minute, cost);
        app.showUserChoice(List);
        app.showUserAppointment();
        System.out.println( "Total: " +app.showCostforUser());


        System.out.println();
        System.out.println();


        //Now, recieved all the information from the user. Now need to output to the user.
        Show look = new Output();
        look.showUserInfo(fname, lname, phoneNumber, emailString, houseAddress);
        look.showUserChoice(List, offMenu);
        look.showUserAppointment(part_day, hour, minute);
        
        sc.close();

        System.out.println("Check your desktop for the Recipt.");
        System.out.println("Thank you for shopping with us!");
        System.out.println("Please have a great day!");

        try { //Create the file.
            BufferedWriter w = new BufferedWriter(new FileWriter("Recipt.txt"));
            w.write("\n-------------------------------------------");
            w.write("\nLaura's Cleaning Services Company.");
            w.write("\n12161 Amber Hill Trail \nCalifornia, Moreno Valley 92557");
            w.write("\n-------------------------------------------");
            w.write("\nBILL TO");
            w.write("\n"+fname + "\n" + lname);
            w.write("\n" + houseAddress);
            w.write("\n-------------------------------------------");
            w.write("\n" + "Customers Information " +"\n" +phoneNumber);
            w.write("\n" +emailString);
            w.write("\n" + houseAddress);
            w.write("\n" + date);
            w.write("\n" +part_day  + " at "  + hour + ":" + minute);
            w.write("\n-------------------------------------------");
            w.write("\nRecipt Total        " + app.showCostforUser());
            w.write("\n-------------------------------------------");
            w.write("\nCustomer Selection ");
            w.write("\nCleaning Option                  Unit Price");
            w.write("\n" + List[offMenu - 1]          );
            w.write("\nTotal: " +      app.showCostforUser() + " + tax");
            w.write("\n-------------------------------------------");
            w.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
