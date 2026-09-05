import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StockMarket market = new StockMarket();
        User user = new User("Student", 10000);

        List<Transaction> transactions = new ArrayList<>();

        boolean running = true;

        System.out.println("==================================");
        System.out.println("       STOCK TRADING PLATFORM");
        System.out.println("==================================");

        while (running) {

            System.out.println("\n----------- MENU -----------");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transaction History");
            System.out.println("6. View Portfolio Performance");
            System.out.println("7. Exit");
            System.out.println("----------------------------");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    market.displayMarketData();
                    break;

                case 2:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.next().toUpperCase();

                    Stock buyStock = market.getStock(buySymbol);

                    if (buyStock == null) {
                        System.out.println("Stock not found.");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();

                    if (buyQuantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                        break;
                    }

                    double buyAmount = buyStock.getCurrentPrice() * buyQuantity;

                    if (user.deductBalance(buyAmount)) {

                        user.getPortfolio().addStock(buyStock, buyQuantity);

                        transactions.add(
                                new Transaction(
                                        buyStock,
                                        "BUY",
                                        buyQuantity,
                                        buyStock.getCurrentPrice()
                                )
                        );

                        System.out.println("Stock purchased successfully.");
                        System.out.printf("Amount paid: $%.2f%n", buyAmount);

                    } else {
                        System.out.println("Insufficient balance.");
                    }

                    break;

                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.next().toUpperCase();

                    Stock sellStock = market.getStock(sellSymbol);

                    if (sellStock == null) {
                        System.out.println("Stock not found.");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();

                    if (sellQuantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                        break;
                    }

                    if (user.getPortfolio().removeStock(sellStock, sellQuantity)) {

                        double sellAmount =
                                sellStock.getCurrentPrice() * sellQuantity;

                        user.addBalance(sellAmount);

                        transactions.add(
                                new Transaction(
                                        sellStock,
                                        "SELL",
                                        sellQuantity,
                                        sellStock.getCurrentPrice()
                                )
                        );

                        System.out.println("Stock sold successfully.");
                        System.out.printf("Amount received: $%.2f%n", sellAmount);

                    } else {
                        System.out.println("You do not have enough shares.");
                    }

                    break;

                case 4:
                    System.out.println("\n========== PORTFOLIO ==========");

                    if (user.getPortfolio().getHoldings().isEmpty()) {
                        System.out.println("No stocks in portfolio.");
                    } else {

                        for (String symbol :
                                user.getPortfolio().getHoldings().keySet()) {

                            Stock stock = market.getStock(symbol);
                            int quantity =
                                    user.getPortfolio().getQuantity(symbol);

                            double value =
                                    quantity * stock.getCurrentPrice();

                            System.out.printf(
                                    "%-6s Quantity: %-5d Value: $%.2f%n",
                                    symbol,
                                    quantity,
                                    value
                            );
                        }
                    }

                    System.out.printf(
                            "Available Balance: $%.2f%n",
                            user.getBalance()
                    );

                    System.out.println("===============================");

                    break;

                case 5:
                    System.out.println("\n======= TRANSACTION HISTORY =======");

                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {

                        for (Transaction transaction : transactions) {

                            System.out.printf(
                                    "%s | %s | Quantity: %d | Price: $%.2f | Total: $%.2f%n",
                                    transaction.getType(),
                                    transaction.getStock().getSymbol(),
                                    transaction.getQuantity(),
                                    transaction.getPrice(),
                                    transaction.getTotalAmount()
                            );
                        }
                    }

                    System.out.println("===================================");

                    break;

                case 6:
                    double portfolioValue =
                            user.getPortfolio()
                                    .calculatePortfolioValue(market.getStocks());

                    double totalValue =
                            user.getBalance() + portfolioValue;

                    System.out.println("\n===== PORTFOLIO PERFORMANCE =====");

                    System.out.printf(
                            "Available Balance : $%.2f%n",
                            user.getBalance()
                    );

                    System.out.printf(
                            "Stock Value       : $%.2f%n",
                            portfolioValue
                    );

                    System.out.printf(
                            "Total Portfolio   : $%.2f%n",
                            totalValue
                    );

                    System.out.println("==================================");

                    break;

                case 7:
                    running = false;
                    System.out.println(
                            "\nThank you for using Stock Trading Platform!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select between 1 and 7."
                    );
            }
        }

        scanner.close();
    }
}