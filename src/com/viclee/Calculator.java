package com.viclee;

public class Calculator {

    public static String Calculate(String operand_1, String operand_2, String operator) throws CalculatorException {
        int a;
        int b;
        int result;
        boolean isRoman = false;
        try{
            a = Integer.parseInt(operand_1);
            b = Integer.parseInt(operand_2);

            if(a < 1 || a > 10 || b < 1 || b > 10){
                throw new CalculatorException("Operands are not valid");
            }
        } catch (NumberFormatException e) {
            try {
                a = NumeralsTranslator.ToArab(operand_1);
                b = NumeralsTranslator.ToArab(operand_2);
                isRoman = true;
            } catch (Exception exception) {
                throw new CalculatorException("Operands are not valid");
            }
        }

        switch(operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new CalculatorException("Operator is not valid");
        }

        return isRoman? (NumeralsTranslator.ToRoman(result)): Integer.toString(result);
    };
}

class CalculatorException extends Exception{
    public CalculatorException(String message){
        super(message);
    }
}