import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String ccNum;
        int[] ccNumDigits;
        int tempCounter = 0;
        int generalSum = 0;
        boolean validStatus = false;
        
        System.out.println("Enter Credit/Debit Card Number: ");
        ccNum = input.nextLine();
        ccNumDigits = new int[ccNum.length()];

        for (int i = ccNum.length() - 1; i > -1; i--) {
            ccNumDigits[tempCounter] = Integer.parseInt("" + ccNum.charAt(i));
            tempCounter++;
        }
        
        for (int i = 0; i < ccNumDigits.length; i += 2) {
            generalSum += ccNumDigits[i];
        }

        for (int i = 1; i < ccNumDigits.length; i += 2) {
            int tempSum = ccNumDigits[i] * 2;
            if (tempSum > 9) {
                int digit1 = tempSum / 10;
                int digit2 = tempSum % 10;
                tempSum = digit1 + digit2;
            }
            generalSum += tempSum;
        }

        if (generalSum % 10 == 0) {
            System.out.println("This Credit/Debit Card is Valid.");
            validStatus = true;
        }
        else {
            System.out.println("This Credit/Debit Card is Invalid.");
            validStatus = false;
        }

        if (validStatus == true && ccNumDigits[ccNumDigits.length - 1] == 4) {
            System.out.println("Visa");
        }
        if (validStatus == true && ((ccNumDigits[ccNumDigits.length - 1] * 10 + ccNumDigits[ccNumDigits.length - 2] >= 51 && ccNumDigits[ccNumDigits.length - 1] * 10 + ccNumDigits[ccNumDigits.length - 2] <= 55) || (ccNumDigits[ccNumDigits.length - 1] * 1000 + ccNumDigits[ccNumDigits.length - 2] * 100 + ccNumDigits[ccNumDigits.length - 3] * 10 + ccNumDigits[ccNumDigits.length - 4] >= 2221 && ccNumDigits[ccNumDigits.length - 1] * 1000 + ccNumDigits[ccNumDigits.length - 2] * 100 + ccNumDigits[ccNumDigits.length - 3] * 10 + ccNumDigits[ccNumDigits.length - 4] <= 2720))) {
            System.out.println("MasterCard");
        }
        if (validStatus == true && (ccNumDigits[ccNumDigits.length - 1] * 10 + ccNumDigits[ccNumDigits.length - 2] >= 34 && ccNumDigits[ccNumDigits.length - 1] * 10 + ccNumDigits[ccNumDigits.length - 2] <= 37)) {
            System.out.println("American Express");
        }
        // If you want you can add Discover and Diners Club too.

        input.close();
    }
}
