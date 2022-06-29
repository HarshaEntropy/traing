package Interface;

import java.util.Scanner;

public class InterfaceTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int st;
        do {
            System.out.println("Enter Number ot select the Bank");
            System.out.println("1. SBI");
            System.out.println("2. KOTAC");
            System.out.println("3. ICIC");
            System.out.println("0. close");
            st = input.nextInt();
            switch (st){
                case 1:{
                    Bank mb = new SBI();
                    mb.process();
                    break;
                }
                case 2:{
                    Bank mb = new KOTAC();
                    mb.process();
                    break;
                }
                case 3:{
                    Bank mb = new ICIC();
                    mb.process();
                    break;
                }
            }
        }
        while (st !=0);
    }
}
interface Bank{
    void process();
}
class SBI implements Bank{
    public void process(){
        System.out.println("Enter Account No.");
        System.out.println("Enter Cvv no.");
        System.out.println("Enter date of validation");
        System.out.println("Enter OTP no.");
        System.out.println("Successfully Transaction is complected");

    }
}
class KOTAC implements Bank{
    public void process(){
        System.out.println("Enter Phone No.");
        System.out.println("Enter Account No.");
        System.out.println("Enter Cvv no.");
        System.out.println("Enter date of validation");
        System.out.println("DATE of Birth");
        System.out.println("Welcome KOTAC");
        System.out.println("Enter OTP no.");
        System.out.println("Successfully Transaction is complected");
    }
}
class ICIC implements Bank{
    public void process(){
        System.out.println("Enter Account No.");
        System.out.println("Enter Cvv no.");
        System.out.println("Enter date of validation");
        System.out.println("Welcome ICIC");
        System.out.println("Do You need any Personal LOAN.....\nYour lucky Person you got lone for 9.5 interest rale click hear");
        System.out.println("Enter OTP no.");
        System.out.println("Successfully Transaction is complected");
    }
}

