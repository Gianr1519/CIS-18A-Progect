package User;

//Created this class to have the users input private. 
class user {
    private String First;
    private String Last;

    user(String f, String l) { //Creating a constructor for the users info goes into. 
        this.First = f;
        this.Last = l;
    }

    public void displayName() {
        System.out.println("First Name: " + First);
        System.out.println("Last name: " + Last);
    }
    
}

class personalInformation extends user { //Creating a sub class because it is Is-A relation. It is to display both information. 
    private String email;
    private String PhoneNumber;
    private String houseAddress;

    public personalInformation(String e, String PN, String HA, String f, String l) {
        super(f, l);
        email = e;
        PhoneNumber = PN;
        houseAddress = HA;
    }

    public void displaypersonalInformation() { //Displaying the users information. 
        System.out.println("Email: "+ email);
        System.out.println("Phone Number: " + PhoneNumber);
        System.out.println("House Address: " + houseAddress);
    }
}
