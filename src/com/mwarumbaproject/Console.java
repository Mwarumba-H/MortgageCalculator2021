package com.mwarumbaproject;

import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max){
        double value; //this is a generic name to replace the specified variables.
        while(true){
            System.out.print(prompt);
            value = input.nextDouble();
            if (value>=min && value <= max)
                break;
            System.out.println("Enter value between " + min + " and " + max);
        }
        return value;
    }
}
