package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MathApp {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "D:\\Java\\IDEProjects\\Developer\\DevClassLesson3-2\\src\\input.txt";
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            Expression parse = new ExpressionParser().parse(expression);

            int result = new Calculator().calculate(parse);
            System.out.println("result = " + result);
        }
    }

}
