package com.example.calculatorius;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public void appendNumber(double number) {
        if (operator == null || operator.isEmpty()) {
            firstNumber = number;
        } else {
            secondNumber = number;
        }
    }

    public void setOperator(String op) {
        operator = op;
    }

    public String calculate() {
        double result;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    return "Error";
                }
                result = firstNumber / secondNumber;
                break;
            default:
                return "Invalid Operation";
        }
        return String.valueOf(result);
    }

    public void reset() {
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
    }
}
