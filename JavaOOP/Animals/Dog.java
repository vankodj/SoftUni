package animals;

public class Dog extends Animal{
    @Override


    public String explainSelf() {
        return String.format("%s%nDJAAF",this.explainSelf());
    }

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }
}
