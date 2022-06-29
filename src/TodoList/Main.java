package TodoList;

import java.util.ArrayList;
import java.util.Scanner;

interface  Bank {
    void account();
}

class SBIAccount implements Bank {
    public void account(){
        Scanner sbi = new Scanner(System.in);
        System.out.println("Enter you details");
        System.out.println("Name:");
        String name =sbi.nextLine();
        System.out.println("Gender:M/F");
        String gender = sbi.nextLine();
        System.out.println("dateofbith:ddmmyyyy");
        int dateofbirth = sbi.nextInt();
        System.out.println(name+" "+gender+" "+dateofbirth);
    }
}
class ICICIAccount implements Bank {
    public void account(){
        Scanner icici = new Scanner(System.in);

        String firstname =icici.nextLine();
        String laststname =icici.nextLine();
        String gender = icici.nextLine();
        double dateofbirth = icici.nextInt();
        System.out.println(firstname+laststname+gender+dateofbirth);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        int Bankoptionmenu;
        do {
            System.out.println("Select your Bank");
            System.out.println("1. SBI");
            System.out.println("2.ICICI");
            System.out.println("3.close");
            Bankoptionmenu = menu.nextInt();

            switch (Bankoptionmenu) {
                case 1: {
                    Bank sbi = new SBIAccount();
                    sbi.account();
                    break;
                }
                case 2: {
                    Bank icici = new ICICIAccount();
                    icici.account();

                }
            }
        }
        while (Bankoptionmenu != 3) ;
        System.out.println("Successful closes");
    }
}
