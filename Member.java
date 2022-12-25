import java.util.ArrayList;

public abstract class Member {
    protected String memberId;
    protected char gender;
    protected int age;
    private ArrayList<Order> orders = new ArrayList<>();

    public Member(String info) {
        String[] parts = info.split(" ");
        this.memberId = parts[0];
        this.gender = parts[1].charAt(0);
        this.age = Integer.parseInt(parts[2]);
    }

    public abstract double consume(int amount);

    public double getTotalCost() {
        return 0;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getGenderAgeCost() {
        return memberId + " " + gender + " " + age + " " + String.format("%.1f",getTotalCost());
    }

    public  String toString(){
        return memberId + " " + gender + " " + age;
    }

   public ArrayList<Order> getOrders(){
       return orders;
   }

   public void addOder(Order order){
        orders.add(order);
   }
}