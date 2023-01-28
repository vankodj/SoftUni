package onlineShop.models.products.computers;

public class Laptop extends BaseComputer{
public static final double LAPTOP_OVERALL_PERFORMANCE = 10;
    public Laptop(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
    }
}
