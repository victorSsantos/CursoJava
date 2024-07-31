package application;
import entities.Triangle;

public class Program {
    public static void main(String[] args) {

        Triangle x, y;
        x = new Triangle(5, 6, 8);
        y = new Triangle(4, 9, 6);

        System.out.println("Area X: " + x.area());
        System.out.println("Area Y: " + y.area());
    }
}