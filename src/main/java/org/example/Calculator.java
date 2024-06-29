package org.example;

public class Calculator {

    public int calculate(Expression expression) {

        try {

            return switch (expression.getOperator()) {
                case plus -> expression.getA() + expression.getB();
                case minus -> expression.getA() - expression.getB();
                case divide -> expression.getA() / expression.getB();
                case multiply -> expression.getA() * expression.getB();
            };

        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid input value " + expression);
        }
    }
}