package User;

class Menu {

    //This class is to show the menu 

    public void showMenu(String []show) {
        System.out.println("Please select the following out of the list! (1-7)");
        for(int i = 0; i < show.length; i++) { //Creating a for loop to go through all of 7 options of the List Array
            System.out.println("----------------");
            System.out.println(show[i]);
        }
        System.out.println("----------------");
        System.out.print("Select: ");
    }

    public double getChoice(int c, double h) {
        h = 0.0; //Created a switch method to get the price of the cleaning option the user wanted. 
        switch(c) {
            case 1:
                System.out.println("Option 1 Selected");
                h = 150.00;
                break;
            case 2:
                System.out.println("Option 2 Selected");
                h = 250.00;
                break;
            case 3:
                System.out.println("Option 3 Selected");
                h = 300.00;
                break;
            case 4:
                System.out.println("Option 4 Selected");
                h = 400.00;
                break;
            case 5: 
                System.out.println("Option 5 Selected");
                h = 250.00;
                break;
            case 6:
                System.out.println("Option 6 Selected");
                h = 350.00;
                break;
            case 7:
                System.out.println("Option 7 selected");
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        return h;
    }
}

