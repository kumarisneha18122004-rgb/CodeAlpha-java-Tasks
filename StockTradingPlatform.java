import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Stock> market = new HashMap<>();
        Map<String, Integer> portfolio = new HashMap<>();
        double balance = 10000.00; // Initial balance in USD

        market.put("AAPL", new Stock("AAPL", 180.50));
        market.put("GOOGL", new Stock("GOOGL", 140.20));
        market.put("TSLA", new Stock("TSLA", 210.00));

        while (true) {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("Balance: $" + balance);
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n--- Market Data ---");
                for (Stock s : market.values()) {
                    System.out.println(s.symbol + " - $" + s.price);
                }
            } else if (choice == 2) {
                System.out.print("Enter stock symbol to buy: ");
                String symbol = scanner.next().toUpperCase();
                if (market.containsKey(symbol)) {
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    double cost = market.get(symbol).price * qty;
                    if (balance >= cost) {
                        balance -= cost;
                        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + qty);
                        System.out.println("Bought " + qty + " shares of " + symbol);
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                } else {
                    System.out.println("Stock not found!");
                }
            } else if (choice == 3) {
                System.out.print("Enter stock symbol to sell: ");
                String symbol = scanner.next().toUpperCase();
                if (portfolio.containsKey(symbol) && portfolio.get(symbol) > 0) {
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    if (qty <= portfolio.get(symbol)) {
                        double earnings = market.get(symbol).price * qty;
                        balance += earnings;
                        portfolio.put(symbol, portfolio.get(symbol) - qty);
                        System.out.println("Sold " + qty + " shares of " + symbol);
                    } else {
                        System.out.println("You don't own that many shares!");
                    }
                } else {
                    System.out.println("You don't own this stock!");
                }
            } else if (choice == 4) {
                System.out.println("\n--- Your Portfolio ---");
                for (String sym : portfolio.keySet()) {
                    System.out.println(sym + ": " + portfolio.get(sym) + " shares");
                }
            } else if (choice == 5) {
                System.out.println("Exiting Platform. Goodbye!");
                break;
            }
        }
        scanner.close();
    }
}
