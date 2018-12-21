/*
 * Homework #3
 * Christopher White
 */
package loans;

/* Import libraries*/
import java.util.Scanner; //keyboard scanner
import java.lang.Math;  // for squareroot
import java.text.DecimalFormat; // decimal formatting


/**
 *
 * @author chriswhite
 */

public class Loans {
    
    // create a method to read in the keyboard input
    // values are stored in an array of size = 3
    public static void read_user_input() {
        
        //formatting numbers upto 2 decimal places in Java
        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        Scanner kybd = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        double loan_amount = kybd.nextInt();
        System.out.print("Number of Years: ");
        double no_years = kybd.nextInt();
        System.out.print("Annual Interest Rate: ");
        double annual_interest_rate = kybd.nextInt(); 
        
        double monthly_interest_rate = ((annual_interest_rate/100) / 12);
        
        double balance = loan_amount;
        double interest = 0;
        double principal = 0;

        double monthly_payment  = (monthly_interest_rate*balance)/(1-Math.pow((1+monthly_interest_rate),-no_years*12));
        
        System.out.println("\nMonthly Payment: " + df.format(monthly_payment));
        System.out.println("Total Payment: " + df.format(monthly_payment*no_years*12));
        System.out.println();
        
        int i = 0;
        System.out.println("Payment#\tInterest\tPrincipal\tBalance");
        for (i = 1; i <= no_years * 12; i++) {
            interest = monthly_interest_rate * balance; //confirmed
            principal = monthly_payment - interest; 
            balance = balance - principal;
            System.out.println(i + "\t\t" + df.format(interest) + "\t\t" + df.format(principal) + "\t\t" + df.format(balance));
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        read_user_input();
        
        
    }
    
}
