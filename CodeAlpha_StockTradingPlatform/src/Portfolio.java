import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private Map<String, Integer> holdings;

    public Portfolio() {
        holdings = new HashMap<>();
    }

    public void addStock(Stock stock, int quantity) {

        String symbol = stock.getSymbol();

        if (holdings.containsKey(symbol)) {
            int currentQuantity = holdings.get(symbol);
            holdings.put(symbol, currentQuantity + quantity);
        } else {
            holdings.put(symbol, quantity);
        }
    }

    public boolean removeStock(Stock stock, int quantity) {

        String symbol = stock.getSymbol();

        if (!holdings.containsKey(symbol)) {
            return false;
        }

        int currentQuantity = holdings.get(symbol);

        if (quantity > currentQuantity) {
            return false;
        }

        if (quantity == currentQuantity) {
            holdings.remove(symbol);
        } else {
            holdings.put(symbol, currentQuantity - quantity);
        }

        return true;
    }

    public int getQuantity(String symbol) {
        return holdings.getOrDefault(symbol, 0);
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public double calculatePortfolioValue(Map<String, Stock> stocks) {

        double totalValue = 0;

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            Stock stock = stocks.get(entry.getKey());

            if (stock != null) {
                totalValue += entry.getValue() * stock.getCurrentPrice();
            }
        }

        return totalValue;
    }
}