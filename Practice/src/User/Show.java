package User;

//Created another interface to output the users input one last time. 
public interface Show {
    void showUserInfo(String FName, String LName, String pNumber, String EAddress, String HAddress);
    void showUserChoice(String []menu, int choice);
    void showUserAppointment(String d, int h, int m);
}

class Output implements Show { //This method is to show the users input of the personal information. 
    public void showUserInfo(String FirstName, String LastName , String pNumber, String EAddress, String HAddress) {
        System.out.println();
        System.out.println("Here is the name you entered:");
        System.out.println("First Name: " + FirstName + "\nLast Name: " + LastName);
        System.out.println();
        System.out.println("Email: " + EAddress);
        System.out.println("Phone Number: " + pNumber);
        System.out.println("House Address: " + HAddress);
    }

    public void showUserChoice(String []menu, int selection) { //Showing the users selection. 
        System.out.println("Users Choice: " + menu[(selection - 1)]);
    }

    public void showUserAppointment(String d, int h, int m) { //Showing the users input for there appointment. 
        System.out.println("Date: " + d);
        System.out.println("Time: " + h +":" +m);
        System.out.println();
    }

}
