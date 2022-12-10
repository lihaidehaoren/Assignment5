public class SilverCardMember extends Member {
    private double totalCost;
    private double points;

    public SilverCardMember(String info) {
        super(info);
        this.totalCost = 0;
        this.points = 0;
    }

    @Override
    public double consume(int amount) {
        double actualPrice = amount;
        int pointsGained = (int)Math.floor(amount / 30);
        if (this.points >= actualPrice / 30) {
            this.points -= actualPrice / 30;
            actualPrice = 0;
        } else {
            this.points += pointsGained;
        }
        if (this.totalCost >= 10000) {
            pointsGained = (int)Math.floor(amount / 30 * 1.5);
            this.points += pointsGained;
            actualPrice -= this.points;
        }
        this.totalCost += actualPrice;
        return actualPrice;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public String getGenderAgeCost() {
        return String.format("%s %c %d %.1f", this.memberId, this.gender, this.age, this.points);
    }

    @Override
    public String toString() {
        return String.format("SilverCardMember: %s %c %d points=%.1f", this.memberId, this.gender, this.age, this.points);
    }
}