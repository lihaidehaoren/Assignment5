public class Order {
    private ProductCategory category;
    private int originalPrice;
    private double actualPayment;

    public Order(ProductCategory category, int originalPrice, double actualPayment) {
        this.category = category;
        this.originalPrice = originalPrice;
        this.actualPayment = actualPayment;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public double getActualPayment() {
        return actualPayment;
    }

    public  String toString(String memberId){
        return memberId + " " + category + " " + originalPrice+ " " +String.format("%.0f", actualPayment) ;
    }
}
