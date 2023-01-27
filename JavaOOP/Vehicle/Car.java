package vehicle;

public class Car extends Vehicle{
private final static double SUMMER_FUEL = 0.9;

    public Car(double fuelQuantity, double littersPerKilometer) {
        super(fuelQuantity, littersPerKilometer);
   super.setFuelConsumption(super.getFuelConsumption() + SUMMER_FUEL);
    }
}
