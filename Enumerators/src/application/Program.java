package application;

import entities.Order;
import entities.enums.OrderStatus;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        Order order = new Order(1080, LocalDateTime.now(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);

    }
}