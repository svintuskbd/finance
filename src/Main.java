import model.Exchange;

public class Main {

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        exchange.exchange(100, Exchange.USD);
        exchange.reverseExchange(100, Exchange.USD);
    }
}
