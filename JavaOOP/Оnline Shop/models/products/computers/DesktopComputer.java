package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer{
public static final double DESKTOP_OVERALL_PERFORMANCE = 15;
    public DesktopComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
    }
}
