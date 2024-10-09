package org.example;
import java.util.Comparator;
import java.util.List;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {

    // Метод для розрахунку загального балансу
    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    // Тут будуть інші методи для аналізу транзакцій

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }
    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Вибірка лише витрат (від'ємні значення)
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортування за сумою
                .limit(10) // Обмеження результату першими 10 записами
                .collect(Collectors.toList()); // Збір результату в список
    }

    public static Transaction findMaxExpense(List<Transaction> transactions) {
        Transaction maxExpense = null; // Змінна для зберігання найбільшої витрати

        for (Transaction transaction : transactions) {
            // Перевіряємо, чи це витрата і якщо це найбільша витрата
            if (transaction.getAmount() < 0) {
                if (maxExpense == null || transaction.getAmount() > maxExpense.getAmount()) {
                    maxExpense = transaction;
                }
            }
        }

        return maxExpense; // Повертаємо найбільшу витрату
    }

    public static Transaction findMinExpense(List<Transaction> transactions) {
        Transaction minExpense = null; // Змінна для зберігання найменшої витрати

        for (Transaction transaction : transactions) {
            // Перевіряємо, чи це витрата і якщо це найменша витрата
            if (transaction.getAmount() < 0) {
                if (minExpense == null || transaction.getAmount() < minExpense.getAmount()) {
                    minExpense = transaction;
                }
            }
        }

        return minExpense; // Повертаємо найменшу витрату
    }

}