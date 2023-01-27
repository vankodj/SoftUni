package vehicle;

public class Truck extends Vehicle {
private final static double SUMMER_FUEL = 1.6;


    public Truck(double fuelQuantity, double littersPerKilometer) {
        super(fuelQuantity, littersPerKilometer);
super.setFuelConsumption(super.getFuelConsumption() + SUMMER_FUEL);

    }

    @Override
    public void refuel(double litters){
        litters = litters * 0.95;
        super.refuel(litters);
    }
}
