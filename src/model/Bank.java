package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bank implements
        BaseExchangeInterface,
        FinanceStructureInterface,
        CreditInterface,
        DepositInterface,
        SendMoneyInterFace {

    public static final String USD = "usd";
    public static final String EUR = "eur";
    public static final String RUB = "rub";

    private String name;
    private String address;

    private Map<String, Float> currenciesTo = new HashMap<>();
    private Map<String, Float> currenciesToReverse = new HashMap<>();

    private float courseUsdToUah = 26.6f;
    private float courseEurToUah = 30.0f;
    private float courseRubToUah = 0.41f;
    private float courseUahToUsd = 26.8f;
    private float courseUahToEur = 31.0f;
    private float courseUahToRub = 0.45f;

    private int limitExchange = 12_000;
    private int commissionExchange = 15;
    private int creditLimit = 200_000;
    private int percentYear = 25;
    private int commissionSend = 1;
    private int termDeposit = 12;

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", currenciesTo=" + currenciesTo +
                ", currenciesToReverse=" + currenciesToReverse +
                ", limitExchange=" + limitExchange +
                ", commissionExchange=" + commissionExchange +
                '}';
    }

    @Override
    public void exchange(int uah, String currName) {
        this.setCurrenciesTo();
        Set<Map.Entry<String, Float>> set = this.currenciesTo.entrySet();
        for (Map.Entry<String, Float> currency : set) {
            if (currency.getKey().equals(currName) && uah <= this.limitExchange) {
                System.out.println((uah - this.commissionExchange) / currency.getValue());
            }
        }
    }

    @Override
    public void reverseExchange(int curr, String currName) {
        this.setCurrenciesToReverse();
        Set<Map.Entry<String, Float>> set = this.currenciesToReverse.entrySet();
        for (Map.Entry<String, Float> currency : set) {
            if (
                    currency.getKey().equals(currName)
                            && curr * currency.getValue() <= this.limitExchange
                            && curr * currency.getValue() > this.commissionExchange
                    ) {
                System.out.println((curr * currency.getValue()) - this.commissionExchange);
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void getMoney(int quantityUah) {
        if (quantityUah <= this.creditLimit) {
            System.out.println(quantityUah);
        }
    }

    @Override
    public void putOnDeposit(int uah) {
        System.out.println(uah);
    }

    @Override
    public void sendMoney(int uah) {
        if (uah > 5) {
            System.out.println(uah - ((uah / 100) * this.commissionSend));
        }
        System.out.println(uah);
    }

    private void setCurrenciesTo() {
        this.currenciesTo.put(USD, this.courseUsdToUah);
        this.currenciesTo.put(EUR, this.courseEurToUah);
        this.currenciesTo.put(RUB, this.courseRubToUah);
    }

    private void setCurrenciesToReverse() {
        this.currenciesToReverse.put(USD, this.courseUahToUsd);
        this.currenciesToReverse.put(EUR, this.courseUahToEur);
        this.currenciesToReverse.put(RUB, this.courseUahToRub);
    }
}
