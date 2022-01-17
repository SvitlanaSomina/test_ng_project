import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public int getIntNumber() {
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        } else {
            System.out.println("You made a mistake while entering the number. Please try again.");
            scanner.next();
            number = getIntNumber();
        }
        return number;
    }

    public char getOperation() {
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("You made a mistake while entering an operation. Please try again.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }

    public int subtract(int numberA, int numberB) {
        return numberA - numberB;
    }

    public int multiply(int numberA, int numberB) {
        return numberA * numberB;
    }

    public double divide(int numberA, int numberB) {
        if (numberB == 0) {
            throw new ArithmeticException("Division by zero is not possible");
        }
        return Double.valueOf(numberA) / Double.valueOf(numberB);
    }

    public double calculate(int numberA, int numberB, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = add(numberA, numberB);
                break;
            case '-':
                result = subtract(numberA, numberB);
                break;
            case '*':
                result = multiply(numberA, numberB);
                break;
            case '/':
                result = divide(numberA, numberB);
                break;
            default:
                System.out.println("Operation not recognized. Repeat input.");
                result = calculate(numberA, numberB, operation);
        }
        return result;
    }
}

