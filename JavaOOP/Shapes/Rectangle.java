package shapes;

public class Rectangle extends Shape{
  private Double height;
  private Double width;
    public Rectangle(Double perimeter, Double area,Double height,Double width) {
        super(perimeter, area);
        this.height = height;
        this.width = width;
   super.setPerimeter(this.calculatePerimeter());
   super.setArea(this.calculateArea());
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2*(this.height+this.width);
    }

    @Override
    public Double calculateArea() {
        return this.height*this.width;
    }
}
