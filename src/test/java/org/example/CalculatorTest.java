package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    public void testThatPlusCalculatedCorrectly() {

        Expression expression = Expression.builder()
                .a(3)
                .b(4)
                .operator(Expression.Operator.plus)
                .build();

        Assertions.assertEquals(7, calculator.calculate(expression));
    }

    @Test
    public void testThatMinusCalculatedCorrectly() {

        Expression expression = Expression.builder()
                .a(10)
                .b(6)
                .operator(Expression.Operator.minus)
                .build();

        Assertions.assertEquals(4, calculator.calculate(expression));
    }

    @Test
    public void testThatMultiplyCalculatedCorrectly() {

        Expression expression = Expression.builder()
                .a(6)
                .b(7)
                .operator(Expression.Operator.multiply)
                .build();

        Assertions.assertEquals(42, calculator.calculate(expression));
    }

    @Test
    public void testThatDivideCalculatedCorrectly() {

        Expression expression = Expression.builder()
                .a(13)
                .b(3)
                .operator(Expression.Operator.divide)
                .build();

        Assertions.assertEquals(4, calculator.calculate(expression));
    }

    @Test
    public void testThatCalculatorThrowException() {

        Expression[] expected = {
                Expression.builder()
                        .a(10)
                        .b(0)
                        .operator(Expression.Operator.divide)
                        .build(),
                Expression.builder().build(),
                null
        };

        for (Expression expression : expected) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> calculator.calculate(expression),
                    "Invalid input value " + expression);
        }
    }
}