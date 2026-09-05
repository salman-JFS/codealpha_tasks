public class User {

    private String name;
    private double balance;
    private Portfolio portfolio;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new Portfolio();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public boolean deductBalance(double amount) {

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}