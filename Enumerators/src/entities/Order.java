package entities;

import entities.enums.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private Integer id;
    private LocalDateTime date;
    private OrderStatus status;

    public Order() {
    }

    public Order(Integer id, LocalDateTime date, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime moment) {
        this.date = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return "Order [id=" + id + ", date=" + fmt.format(date) + ", status=" + status + ']';
    }
}
