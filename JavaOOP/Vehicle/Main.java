package vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] tokens = scan.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(tokens[1]);
        double carFuelConsumption = Double.parseDouble(tokens[2]);
        Vehicle car = new Car(carFuelQuantity,carFuelConsumption);
        tokens = scan.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(tokens[1]);
        double truckFuelConsumption = Double.parseDouble(tokens[2]);
        Vehicle truck = new Truck(truckFuelQuantity,truckFuelConsumption);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicle = tokens[1];
            switch (command){
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    if (vehicle.equals("Car")){
                        System.out.println(car.drive(distance));
                    }else{
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    if (vehicle.equals("Car")){
                        car.refuel(fuelAmount);
                    }else{
                        truck.refuel(fuelAmount);
                    }
                    break;
            }

        }
        System.out.print(car.toString());
        System.out.print(truck.toString());
    }
}
