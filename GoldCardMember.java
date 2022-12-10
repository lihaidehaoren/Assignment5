public class GoldCardMember extends Member {
    private double totalCost;

    public GoldCardMember(String info) {
        super(info);
        this.totalCost = 0;
    }

    @Override
    public double consume(int amount) {
        double actualPrice = amount;
        if (amount >= 2000 && amount < 5000) {
            actualPrice = amount * 0.95;
        } else if (amount >= 5000 && amount < 10000) {
            actualPrice = 2000 + (amount - 2000) * 0.9;
        } else if (amount >= 10000 && amount < 20000) {
            actualPrice = 2000 + 3000 * 0.95 + (amount - 5000) * 0.85;
        } else if (amount >= 20000) {
            actualPrice = 2000 + 3000 * 0.95 + 5000 * 0.9 + (amount - 10000) * 0.8;
        }
        this.totalCost += actualPrice;
        return actualPrice;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public String getGenderAgeCost() {
        return String.format("%s %c %d %.1f", this.memberId, this.gender, this.age, this.totalCost);
    }

    @Override
    public String toString() {
        return String.format("GoldCardMember: %s %c %d", this.memberId, this.gender, this.age);
    }
}