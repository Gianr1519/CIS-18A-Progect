package User;

class userChoice { //Created another class for the users choice of the menua. 
    private int select;
    private double cost;

    userChoice(int s){
        select = s;
    }

    //Accessor Methods for the userChoices.
    double getCost() {return cost;}
    void setCost(double c) {cost = c;}

    void showUserChoice(String cleaningList[]) { //THis is to display the users input. 

        String CleaningType = cleaningList[select-1]; 
        System.out.println("Cleaning choice: " + CleaningType);
        System.out.println("subtotal: " + cost);
    }
}

class userAppointment extends userChoice { //Created a sub-class because it is a "Is-A" relationship. 
    private String Date;
    private int Hour;
    private int Minute;

    userAppointment(int s,String D, int hour2, int minute2, double c) { //Created a constructor.
        super(s); //Super to call the constructor.
        setCost(c);
        Date = D;
        Hour = hour2;
        Minute = minute2;
    }

    void showUserAppointment() {
        System.out.println("Date: " +Date + " at " + Hour + ":" +Minute);
    }

    double showCostforUser() { //Access the methods from userchoice to display users cost. for the appointment. 
        double tax = 0.05;
        double total = 0.0;
        total = getCost() + (getCost() * tax);

        return total;
    }

}