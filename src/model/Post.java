package model;

public class Post implements FinanceStructureInterface, SendMoneyInterFace{
    int commissionSend = 2;

    private String name = null;
    private String address = null;

    public Post(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void sendMoney(int uah) {
        System.out.println(uah - ((uah / 100) * this.commissionSend));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
