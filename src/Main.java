import model.Bank;
import model.Exchange;

public class Main {

    public static void main(String[] args) {
        Exchange exchange = new Exchange("Exchange1", "address street 3");
        exchange.exchange(100, Exchange.USD);
        exchange.reverseExchange(100, Exchange.EUR);
        System.out.println(exchange.toString());

        Bank bank = new Bank("Bank1", "address 23432");
        bank.exchange(100, bank.RUB);
        bank.reverseExchange(100, bank.RUB);
        System.out.println(bank.toString());
    }
}
