public class Membertest {
    public static void main(String[] args){
        // Create a SilverCardMember object
        GoldCardMember member1 = new GoldCardMember("M01 M 28");
        System.out.println(member1.consume(1500)); // 1500
        System.out.println(member1.consume(3000)); // 2950
        System.out.println(member1.consume(8000)); // 7550
        System.out.println(member1.consume(12000)); // 11050
        System.out.println(member1.consume(40000)); // 33850
        System.out.println(member1.getTotalCost()); // 33850
        System.out.println(member1.getGenderAgeCost()); // M01 M 28 33850
        System.out.println(member1.toString()); // GoldCardMember: M01 M 28

        SilverCardMember member2 = new SilverCardMember("H01 F 35");
        System.out.println(member2.consume(2000)); // 2000
        System.out.println(member2.consume(3000)); // 2934
        System.out.println(member2.consume(6000)); // 5900
        System.out.println(member2.consume(3000)); // 2800
        System.out.println(member2.consume(4000)); // 3850
        System.out.println(member2.consume(50)); // 0
        System.out.println(member2.getTotalCost()); // 19950
        System.out.println(member2.getGenderAgeCost()); // H01 F 35 19950
        System.out.println(member2.toString()); // SilverCardMember: H01 F 35 points=151
        }
}
