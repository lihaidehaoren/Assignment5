import java.util.List;

public interface ShoppingMall {
    void addMember(String info);
    void addMember(List<String> infos);
    Member getMember(String memberId);
    double placeOrder(String memberId, int cost, ProductCategory category);
    List<String> getMemberRecords(String memberId);
    List<String> getCostByCategory();
    List<String> getMemberRecordByGenderAndAge(char gender, int lowerAge, int upperAge);
    double getTotalCost(String memberId);
    double getTotalIncome();
    String toString();
}
