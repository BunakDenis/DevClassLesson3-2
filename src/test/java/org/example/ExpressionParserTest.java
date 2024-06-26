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
        Expression actual = parser.parse("3+5");

        Expression expected = Expression
                .builder()
                .a(3)
                .b(5)
                .operator(Expression.Operator.plus)
                .build();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMinus2minus4ParseWorkOk () {
        Expression actual = parser.parse("-2-4");

        Expression expected = Expression
                .builder()
                .a(-2)
                .b(4)
                .operator(Expression.Operator.minus)
                .build();

        Assertions.assertEquals(expected, actual);

    }

}
