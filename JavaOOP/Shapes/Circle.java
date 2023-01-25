package shapes;

public class Circle extends Shape{
   private Double radius;

    public Circle(Double perimeter, Double area, Double radius) {
        super(perimeter, area);
        this.radius = radius;
        super.setPerimeter(this.calculatePerimeter());
        super.setArea(this.calculateArea());
    }

    @Override
   public Double calculatePerimeter() {
        return 2*Math.PI*this.radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI*this.radius*this.radius;
    }
}
