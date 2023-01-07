package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private void setLength(double length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (height < 1) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }
//       Volume = lwh
//      Lateral Surface Area = 2lh + 2wh
//       Surface Area = 2lw + 2lh + 2wh

    public double calculateSurfaceArea(){
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }
    public double calculateLateralSurfaceArea (){
        return 2*this.height *(this.width + this.length);
    }
    public double calculateVolume (){
        return this.width* this.length * this.height;
    }
}
