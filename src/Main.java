import model.Exchange;

public class Main {

    public static void main(String[] args) {
        Exchange exchange = new Exchange("Exchange1", "address street 3");
        exchange.exchange(100, Exchange.USD);
        exchange.reverseExchange(100, Exchange.EUR);
        System.out.println(exchange.toString());
    }
}
