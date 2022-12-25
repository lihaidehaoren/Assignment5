public class SilverCardMember extends Member {
    private double totalCost;
    private double points;

    public SilverCardMember(String info) {
        super(info);
        points=0;
        totalCost=0;
    }

    @Override
    public double consume(int amount) {
        double cost = amount;
        if (cost>=points){
            cost=cost-points;
            points=0;
        }
        else if (cost<points){
            points=points-cost;
            cost=0;
        }
        if (totalCost<10000){
            points=points+amount/30;
        }
        else if (totalCost>=10000){
            points=points+(amount/30)*1.5;
        }
        totalCost=totalCost+cost;
        return cost;
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "SilverCardMember: " + memberId + " " + gender + " " + age + " points=" + points;
    }
}