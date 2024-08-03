package entities;

public class Employee {

    private String name;
    private Integer hour;
    private Double valuePerHour;

    public Employee(String name, Integer hour, Double valuePerHour) {
        this.name = name;
        this.hour = hour;
        this.valuePerHour = valuePerHour;
    }

    public String getName() {
        return name;
    }

    public Integer getHour() {
        return hour;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Double payment(){
        return hour * valuePerHour;
    }
}
