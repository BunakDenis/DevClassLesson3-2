package org.example;

import java.util.Arrays;

public class ExpressionParser {

    public Expression parse(String expression) {

        ParseState state = ParseState.a;

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        Expression.Operator operator = null;
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (i == 0) {
                a.append(c);
            } else {
                switch (state) {
                    case a:
                        if (isOperator(c)) {
                            operator = getOperator(c);
                            state = ParseState.b;
                        } else {
                            a.append(c);
                        }
                        break;
                    case b:
                        b.append(c);
                        break;
                }
            }
        }

        String[] parts = expression.split("\\+");

        return Expression.builder()
                .a(Integer.parseInt(a.toString()))
                .b(Integer.parseInt(b.toString()))
                .operator(operator)
                .build();
    }

    public enum ParseState {
        a, b;

    }

    private boolean isOperator(char c) {
        return Arrays.stream(Expression.Operator.values())
                .mapToInt(Expression.Operator::toChar)
                .anyMatch(it -> it == c);
    }

    private Expression.Operator getOperator(char c) {
        return Arrays.stream(Expression.Operator.values())
                .filter(it -> it.toChar() == c)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
