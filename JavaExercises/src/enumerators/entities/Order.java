package enumerators.entities;

import enumerators.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final Date date;
    private OrderStatus status;
    private final Client client;
    private final List<OrderItem> orderItems;

    public Order(Date date, OrderStatus status, Client client) {
        this.date = date;
        this.status = status;
        this.client = client;
        this.orderItems = new ArrayList<>();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    Double total(){
        Double total = 0.0;
        for(OrderItem item : orderItems){
            total+=item.subTotal();
        }
        return total;
    }

    public void printSummary(){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + fmt.format(date));
        System.out.println("Order status: " + status);
        System.out.println("Client: " + client.toString());
        System.out.println("Order items:");
        for(var item : orderItems) {
            System.out.println(item.toString());
        }
        System.out.println("Total price: " + String.format("%.2f", total()));
    }
}
