import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");
//initialize variables
        double itemPrice;
        double sum = 0;

//find the variables that will be constants
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group? ");
        int totalPeople = scan.nextInt();
        scan.nextLine();

        System.out.print("What's the tip percentage? (0 - 100): ");
        int tip  = scan.nextInt();
        scan.nextLine();

//start asking for all the prices
        System.out.print("Enter a cost in dollars and cents, eg. 12.50 (-1 to end): ");
        itemPrice = scan.nextDouble();
        scan.nextLine();
        while (itemPrice != -1) {
            sum += itemPrice;

            System.out.print("Enter a cost in dollars and cents, eg. 12.50 (-1 to end): ");
            itemPrice = scan.nextDouble();
            scan.nextLine();
        }
        scan.close();
//initialize all the variables that are base don other numbers
        double tipTotal = sum * tip / 100;
        double perPerson = sum / totalPeople;
        double tipPerPerson = tipTotal / totalPeople;

//start printing out all the calculations
        System.out.println("--------------------------");
        System.out.println("Total Bill Before Tip: " + formatter.format(sum));
        System.out.println("Tip Percentage: " + tip);
        System.out.println("Total Tip: " + formatter.format(tipTotal));
        System.out.println("Total Bill With Tip: " + formatter.format(sum + tipTotal));
        System.out.println("Per Person Cost Before Tip: " + formatter.format(perPerson));
        System.out.println("Tip Per Person: " + formatter.format(tipPerPerson));
        System.out.println("Total Cost Per Person: "+ formatter.format(tipPerPerson + perPerson));



    }
}
