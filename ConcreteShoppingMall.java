import java.util.ArrayList;
import java.util.List;

public class ConcreteShoppingMall implements ShoppingMall{
    private List<Member> members;

    public ConcreteShoppingMall() {
        this.members = new ArrayList<>();
    }
    @Override
    public void addMember(String info) {
        String[] parts = info.split(" ");
        char type = parts[3].charAt(0);
        Member member;
        if (type == 'G') {
            member = new GoldCardMember(info);
        } else {
            member = new SilverCardMember(info);
        }
        members.add(member);
    }

    @Override
    public void addMember(List<String> infos) {
        for (String info : infos) {
            addMember(info);
        }
    }

    @Override
    public Member getMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public double placeOrder(String memberId, int cost, ProductCategory category) {
        Member member = getMember(memberId);
        double actualPayment=member.consume(cost);
        Order order =new Order(category,cost,actualPayment);
        member.addOder(order);
        return actualPayment;
    }

    @Override
    public List<String> getMemberRecords(String memberId) {
        Member member = getMember(memberId);
        List<String> records = new ArrayList<>();
        for (Order order : member.getOrders()) {
                records.add(order.toString(memberId));
        }
        return records;
    }

    @Override
    public List<String> getCostByCategory() {
        List<String> results = new ArrayList<>();
        for (ProductCategory category : ProductCategory.values()) {
            double totalCost = 0;
            int orderCount = 0;
            for (Member member : members) {
                for (Order order : member.getOrders()) {
                    if (order.getCategory() == category) {
                        totalCost += order.getActualPayment();
                        orderCount++;
                    }
                }
            }
            results.add(category + " " + orderCount + " " + String.format("%.0f", totalCost));
        }
        return results;
    }

    @Override
    public List<String> getMemberRecordByGenderAndAge(char gender, int lowerAge, int upperAge) {
        List<Member> filteredMembers = new ArrayList<>();
        for (Member member : members) {
            if (member.getGender() == gender && member.getAge() >= lowerAge && member.getAge() <= upperAge) {
                filteredMembers.add(member);
            }
        }
        filteredMembers.sort((m1, m2) -> {
            if (m1.getAge() != m2.getAge()) {
                return Integer.compare(m1.getAge(), m2.getAge());
            }
            return Double.compare(m2.getTotalCost(), m1.getTotalCost());
        });
        List<String> results = new ArrayList<>();
        for (Member member : filteredMembers) {
            results.add(member.getGenderAgeCost());
        }
        List<String> filteredResults = new ArrayList<>();
        for (String strings : results) {
            String[] parts = strings.split(" ");
            String type = parts[3];
            if (!type.equals("0.0")) {
                filteredResults.add(strings);
            }
        }
        return filteredResults;
    }

    @Override
    public double getTotalCost(String memberId) {
        Member member = getMember(memberId);
        return member.getTotalCost();
    }

    @Override
    public double getTotalIncome() {
        double totalIncome = 0;
        for (Member member : members) {
            totalIncome += member.getTotalCost();
        }
        return totalIncome;
    }

    @Override
    public String toString() {
        return "Shopping mall with " + members.size() + " members and total income of " + getTotalIncome() + " yuan";
    }
}
