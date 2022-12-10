public class Membertest {
    public static void main(String[] args){
        // Create a SilverCardMember object
        SilverCardMember member = new SilverCardMember("H01 F 35");
        GoldCardMember member1 =new GoldCardMember("H01 F 35");

// Calculate the actual price after applying the discount for an item with an original price of 2000
        double actualPrice = member.consume(2000); // The actual price should be 2000

// Calculate the actual price after applying the discount for an item with an original price of 3000
        actualPrice = member.consume(3000); // The actual price should be 2934

// Calculate the actual price after applying the discount for an item with an original price of 6000
        actualPrice = member.consume(6000); // The actual price should be 5900

// Calculate the actual price after applying the discount for an item with an original price of 3000
        actualPrice = member.consume(3000); // The actual price should be 2800

// Calculate the actual price after applying the discount for an item with an original price of 4000
        actualPrice = member.consume(4000); // The actual price should be 3850

// Calculate the actual price after applying the discount for an item with an original price of 50
        actualPrice = member.consume(50); // The actual price should be 0

// Get the member's information and the points owned by the member
        String info = member.getGenderAgeCost(); // The string should be "H01 F 35 151.0"
        System.out.println(info);

// Get the string representation of the member
        String str = member.toString(); // The string should be "SilverCardMember: H01 F 35 points=151.0"
        System.out.println(str);
    }
}
