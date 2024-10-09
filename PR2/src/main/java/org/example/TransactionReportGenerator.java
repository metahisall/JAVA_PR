package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printExpenseReportByCategoryAndMonth(List<Transaction> transactions) {
        // Словник для зберігання витрат за категоріями та місяцями
        Map<String, Map<String, Double>> report = new HashMap<>();

        for (Transaction transaction : transactions) {
            // Якщо це витрата (від'ємна сума)
            if (transaction.getAmount() < 0) {
                String month = transaction.getDate().substring(3); // Отримати місяць
                String description = transaction.getDescription(); // Отримати опис

                // Додаємо витрати до звіту
                report.putIfAbsent(description, new HashMap<>()); // Додаємо категорію, якщо її немає
                report.get(description).putIfAbsent(month, 0.0); // Додаємо місяць, якщо його немає
                // Додаємо витрати
                double currentAmount = report.get(description).get(month);
                report.get(description).put(month, currentAmount + Math.abs(transaction.getAmount()));
            }
        }

        // Виведення звіту
        System.out.println("Звіт про витрати:");
        for (String category : report.keySet()) {
            System.out.print(category + ": ");
            for (String month : report.get(category).keySet()) {
                double amount = report.get(category).get(month);
                System.out.print(month + " - " + amount + " грн ");
                // Виводимо зірки
                int stars = (int) (amount / 1000);
                System.out.print("(" + "*".repeat(stars) + ") ");
            }
            System.out.println(); // Перехід на новий рядок після кожної категорії
        }
    }

}
