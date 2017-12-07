package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exchange implements BaseExchangeInterface, FinanceStructureInterface {
    public static final String USD = "usd";
    public static final String EUR = "eur";

    private String name;
    private String address;

    private Map<String, Float> currenciesTo = new HashMap<>();
    private Map<String, Float> currenciesToReverse = new HashMap<>();

    private float courseUsdToUah = 26.6f;
    private float courseEurToUah = 30.0f;
    private float courseUahToUsd = 26.8f;
    private float courseUahToEur = 31.0f;

    @Override
    public String toString() {
        return "Exchange{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", currenciesTo=" + currenciesTo +
                ", currenciesToReverse=" + currenciesToReverse +
                '}';
    }

    public Exchange(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void exchange(int uah, String currName) {
        this.setCurrenciesTo();
        Set<Map.Entry<String, Float>> set = this.currenciesTo.entrySet();
        for (Map.Entry<String, Float> currency : set) {
            if (currency.getKey().equals(currName)) {
                System.out.println(uah / currency.getValue());
            }
        }
    }

    @Override
    public void reverseExchange(int curr, String currName) {
        this.setCurrenciesToReverse();
        Set<Map.Entry<String, Float>> set = this.currenciesToReverse.entrySet();
        for (Map.Entry<String, Float> currency : set) {
            if (currency.getKey().equals(currName)) {
                System.out.println(curr * currency.getValue());
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

    private void setCurrenciesTo() {
        this.currenciesTo.put(USD, this.courseUsdToUah);
        this.currenciesTo.put(EUR, this.courseEurToUah);
    }

    private void setCurrenciesToReverse() {
        this.currenciesToReverse.put(USD, this.courseUahToUsd);
        this.currenciesToReverse.put(EUR, this.courseUahToEur);
    }
}
