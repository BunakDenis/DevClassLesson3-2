package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpressionParserTest {
    private ExpressionParser parser;

    @BeforeEach
    public void beforeEach () {
        parser = new ExpressionParser();
    }

    @Test
    public void test3plus5ParseWorkOk () {

        test("3+5", 3, 5, Expression.Operator.plus);

    }

    private void test(String expression, int expectedA, int expectedB, Expression.Operator operator) {
        Expression actual = parser.parse(expression);
        Expression expected = Expression
                .builder()
                .a(expectedA)
                .b(expectedB)
                .operator(operator)
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMinus2minus4ParseWorkOk () {
        test("-2-4", -2, 4, Expression.Operator.minus);

    }

    @Test
    public void test4MMultiplyMinus5ParseWorkOk () {
        test("4*-5", 4, -5, Expression.Operator.multiply);
    }

    @Test
    public void testMinus6DivideMinus4ParseWorkOk () {
        test("-6/-4", -6, -4, Expression.Operator.divide);
    }

    @Test
    public void testMinus5MinusMinus4ParseWorkOk () {
        test("-5--4", -5, -4, Expression.Operator.minus);
    }

    @Test
    public void testThatWhiteSpacesParseOk() {
            test("   5 -  6  \t\n", 5,6, Expression.Operator.minus);
    }

    @Test
    public void testThatInvalidInputCorrectlyHandled () {

        String [] invalidInputs = {
                null,
                "",
                " ",
                "3",
                "3 6",
                "-",
                "3+hhh",
                "7---6"
        };

        for (String invalidInput : invalidInputs) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> parser.parse(invalidInput),
                    invalidInput);
        }

    }

}

