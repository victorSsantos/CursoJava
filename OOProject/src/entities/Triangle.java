package entities;
import java.text.DecimalFormat;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Triangle (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String area() {
        DecimalFormat df = new DecimalFormat("#0.00");
        double p = (a + b + c)/ 2.0;
        return df.format(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}
