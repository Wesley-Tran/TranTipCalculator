import java.util.Scanner;
import java.text.DecimalFormat;

public class TipCalculatorRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        int tip;
        int numPeople;


        //welcome to the calculator and ask for final variables
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group? ");
        numPeople = scan.nextInt();
        scan.nextLine();
        System.out.print("What's the tip percentage? (0 - 100): ");
        tip = scan.nextInt();
        scan.nextLine();

        TipCalculator bill = new TipCalculator(numPeople, tip);

        //add all the meals
        double itemPrice;
        while (true) {
            System.out.print("Enter a cost in dollars and cents, eg. 12.50 (-1 to end): ");
            itemPrice = scan.nextDouble();
            scan.nextLine();
            if (itemPrice == -1) {break;}
            bill.addMeal(itemPrice);
        }

        //print out all the information
        System.out.println("--------------------------");
        System.out.println("Total Bill Before Tip: " + formatter.format( bill.getTotalBillBeforeTip()));
        System.out.println("Tip Percentage: " + bill.getTipPercentage());
        System.out.println("Total Tip: " + formatter.format(bill.tipAmount()));
        System.out.println("Total Bill With Tip: " + formatter.format(bill.totalBill()));
        System.out.println("Per Person Cost Before Tip: " + formatter.format(bill.perPersonCostBeforeTip()));
        System.out.println("Tip Per Person: " + formatter.format(bill.perPersonTipAmount()));
        System.out.println("Total Cost Per Person: " + formatter.format(bill.perPersonTotalCost()));
    }
}
