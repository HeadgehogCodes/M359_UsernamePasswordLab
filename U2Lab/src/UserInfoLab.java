
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner ns = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String fn = ns.nextLine();
        System.out.println("Enter your last name: ");
        String ln = ns.nextLine();
        String username = generateUsername(fn,ln);
        System.out.println("Username: "+ username);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.println("Enter password: ");
        boolean correctPass = validatePassword(ns.nextLine());

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if (correctPass) {
            System.out.println("Valid password. Checking Credit Card");
            System.out.println("Enter your credit card");
            String ccn = ns.nextLine();
            System.out.println(maskCreditCard(ccn));
        }
            else{
                System.out.println("Invaid Credit Card Number.");
            // Part 4
            // If the user entered a valid password AND valid credit card number, display the output
            // as shown in the demo video
            // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing
        }


    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String first3 =firstName;
        String last3 = lastName;
        if(firstName.length()>=3)
            first3 = firstName.substring(0,3);
        if(lastName.length()>=3)
            last3 = lastName.substring(0,3);

        return (first3+last3).toLowerCase();
    }
    public static boolean validatePassword(String password) {
        boolean isValid = true;

        boolean hasUppercase = false;
        for (int i=0;i<password.length();i++) {
            String letter = password.substring(i,i+1);
            int lnumb = letter.compareTo("A");
            if(0<= lnumb && lnumb <= 25){
                hasUppercase = true;
            }
        }

        if(password.length()<8 ){
            System.out.println("Invalid, Too Short");
            isValid = false;
        }
        if(!hasUppercase){
            System.out.println("Invalid, No Uppercase letter");
            isValid = false;
        }
        if(!containsDigit(password)){
            System.out.println("Invalid, No digit");
            isValid = false;
        }
        return isValid;
    }
    public static String maskCreditCard(String creditCardNumber) {
        if(!allDigits(creditCardNumber)){
            System.out.println("Invalid credit card number, Not all didgets");
            return "";
        }
        if(creditCardNumber.length()<16){
            System.out.println("Invalid credit card number, Too many didgets(make it 16)");
            return "";
        }
        if(creditCardNumber.length()>16){
            System.out.println("Invalid credit card number, Too little didgets(make it 16)");
            return "";
        }
        // Fill in this method and if the credit card is valid, return a masked CC
        return "********"+creditCardNumber.substring(creditCardNumber.length()-4);
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }


    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
