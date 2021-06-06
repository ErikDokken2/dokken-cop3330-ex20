package exercises.ex20;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Erik Dokken
 */
public class ex20 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex20 example20 = new ex20();

        String orderInput = example20.orderInput();
        String stateInput = example20.stateInput();
        String countyInput = example20.countyInput();

        //Str->Int
        int orderInt = example20.orderInt(orderInput);

        double stateTax = example20.stateTax(stateInput, countyInput);
        double taxCharged = example20.taxValue(stateTax, orderInt);
        double total = example20.total(taxCharged, orderInt);

        //Output
        String outputString = example20.outputString(taxCharged, total);

        example20.printOutput(outputString);

    }

    private void printOutput(String outputString) {System.out.println(outputString);
    }

    private String outputString(double stateTax, double total) {
        return "The tax is $"+ String.format("%.2f",stateTax) +".\n" +
                "The total is $" + String.format("%.2f",total) + ".";
    }

    private double total(double tax, int orderInt) {
        return (orderInt * tax/10) + orderInt;
    }

    private double taxValue(double stateTax, int orderInt) {

        return orderInt * stateTax;
    }

    private double stateTax(String stateInput, String countyInput) {
        if(stateInput.equals("Wisconsin"))
        {
            double tax = 0.05;
            if(countyInput.equals("Eau Claire"))
            {
                tax = tax + 0.005;
                return tax;
            }
            else if(countyInput.equals("Dunn"))
            {
                tax = tax +0.004;
                return tax;
            }
            return tax;
        }
        if(stateInput.equals("Illinois"))
        {
            double tax = 0.08;
            return tax;
        }
        else
        {
            double tax = 0;
            return tax;
        }
    }

    private int orderInt(String orderInput) {
        return Integer.parseInt(orderInput);
    }

    private String countyInput() {
        System.out.print("What county do you live in? ");
        String county = in.nextLine();
        return county;
    }

    private String stateInput() {
        System.out.print("What state do you live in? ");
        String state = in.nextLine();
        return state;
    }

    private String orderInput() {
        System.out.print("What is the order amount? ");
        String order = in.nextLine();
        return order;
    }
}
