package com.example.calculatorius;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorUnitTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        calculator.appendNumber(3);
        calculator.setOperator("+");
        calculator.appendNumber(7);
        assertEquals("10.0", calculator.calculate());
    }

    @Test
    public void testSubtraction() {
        calculator.appendNumber(10);
        calculator.setOperator("-");
        calculator.appendNumber(3);
        assertEquals("7.0", calculator.calculate());
    }

    @Test
    public void testMultiplication() {
        calculator.appendNumber(4);
        calculator.setOperator("*");
        calculator.appendNumber(2);
        assertEquals("8.0", calculator.calculate());
    }

    @Test
    public void testDivision() {
        calculator.appendNumber(9);
        calculator.setOperator("/");
        calculator.appendNumber(3);
        assertEquals("3.0", calculator.calculate());
    }

    @Test
    public void testDivisionByZero() {
        calculator.appendNumber(5);
        calculator.setOperator("/");
        calculator.appendNumber(0);
        assertEquals("Error", calculator.calculate());
    }
}
