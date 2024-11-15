import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // Запитуємо у користувача два числа
            System.out.print("Введіть перше число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введіть друге число: ");
            double num2 = scanner.nextDouble();

            // Запитуємо у користувача операцію
            System.out.print("Введіть операцію (+, -, *, /, sqrt): ");
            String operation = scanner.next();

            double result = 0;
            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    System.out.println("Результат додавання: " + result);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    System.out.println("Результат віднімання: " + result);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    System.out.println("Результат множення: " + result);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    System.out.println("Результат ділення: " + result);
                    break;
                case "sqrt":
                    // Виконуємо квадратний корінь тільки з першого числа
                    result = calculator.sqrt(num1);
                    System.out.println("Квадратний корінь з числа: " + result);
                    break;
                default:
                    System.out.println("Невірна операція.");
            }

        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Помилка: введено некоректне число.");
        } finally {
            System.out.println("Операція завершена.");
            scanner.close();
        }
    }
}
