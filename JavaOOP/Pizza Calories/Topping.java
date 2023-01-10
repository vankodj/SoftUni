package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.toppingType = toppingType;
        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("meat") || toppingType.equals("veggies")
                || toppingType.equals("cheese") || toppingType.equals("sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format
                    ("Cannot place %s on top of your pizza.", this.toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format
                    ("%s weight should be in the range [1..50].", this.toppingType));
        } else {
            this.weight = weight;
        }
    }
    public double calculateCalories(){
        double toppingTypeCoefficient = 0;
        switch (this.toppingType) {
            case "Meat":
                toppingTypeCoefficient = 1.2;
                break;
            case "Veggies":
                toppingTypeCoefficient = 0.8;
                break;
            case "Cheese":
                toppingTypeCoefficient = 1.1;
                break;
            case "Sauce":
                toppingTypeCoefficient = 0.9;
                break;
        }

        return 2 * this.weight * toppingTypeCoefficient;
    }
    }
