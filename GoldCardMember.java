public class GoldCardMember extends Member {
    private double totalCost;

    public GoldCardMember(String info) {
        super(info);
    }

    @Override
    public double consume(int amount) {
        double cost;
        if (amount < 2000) {
            cost=amount;
        }
        else if (amount>=2000&&amount < 5000) {
            cost =2000+(amount-2000)*0.95;
        }
        else if (amount>=5000&&amount < 10000) {
            cost =2000+3000*0.95+(amount-5000)*0.9;
        }
        else if (amount>=10000&&amount < 20000) {
            cost =2000+3000*0.95+5000*0.9+(amount-10000)*0.85;
        }
        else {
            cost =2000+3000*0.95+5000*0.9+10000*0.85+(amount-20000)*0.8;
        }
        totalCost += cost;
        return cost;
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "GoldCardMember: " + memberId + " " + gender + " " + age;
    }
}