import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockMarket {

    private Map<String, Stock> stocks;

    public StockMarket() {
        stocks = new HashMap<>();

        stocks.put("AAPL", new Stock("AAPL", "Apple", 220.00));
        stocks.put("MSFT", new Stock("MSFT", "Microsoft", 420.00));
        stocks.put("GOOGL", new Stock("GOOGL", "Google", 175.00));
        stocks.put("AMZN", new Stock("AMZN", "Amazon", 190.00));
        stocks.put("TSLA", new Stock("TSLA", "Tesla", 250.00));
    }

    public void displayMarketData() {

        System.out.println("\n========== MARKET DATA ==========");

        for (Stock stock : stocks.values()) {

            System.out.printf(
                    "%-6s %-12s $%.2f%n",
                    stock.getSymbol(),
                    stock.getCompanyName(),
                    stock.getCurrentPrice()
            );
        }

        System.out.println("=================================");
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol.toUpperCase());
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }

    public void updateStockPrice(String symbol, double newPrice) {

        Stock stock = getStock(symbol);

        if (stock != null && newPrice > 0) {
            stock.setCurrentPrice(newPrice);
        }
    }
}