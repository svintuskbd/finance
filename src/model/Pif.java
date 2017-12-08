package model;

public class Pif implements FinanceStructureInterface, DepositInterface {
    private String name;
    private String address;
    private int yearOfFoundation;
    private int termDeposit = 12;

    public Pif(String name, String address, int yearOfFoundation) {
        this.name = name;
        this.address = address;
        this.yearOfFoundation = yearOfFoundation;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    public int getYearOfFoundation() {
        return this.yearOfFoundation;
    }

    @Override
    public void putOnDeposit(int uah) {
        System.out.println(uah);
    }
}
