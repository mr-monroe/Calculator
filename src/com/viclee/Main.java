package com.viclee;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CalculatorException {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        String [] slicedExp = expression.split(" ");

        String result = Calculator.Calculate(slicedExp[0], slicedExp[2], slicedExp[1]);
        System.out.println(result);
    }
}
