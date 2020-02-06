package com.alex.task49;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private static HashMap<Integer, Order> orders = new HashMap<>();
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Type your order id:");
            int id = Integer.parseInt(reader.readLine());
            if(orders.get(id) != null) {
                Order order = orders.get(id);
                System.out.println("Current status:" + order.getOrderStatus());
                System.out.println("Type new status:");
                String status = reader.readLine().toUpperCase().replace("\\s", "_");
                Order.ORDER_STATUS order_status = Order.ORDER_STATUS.valueOf(status);
                if(order_status.compareTo(order.getOrderStatus()) > 0) {
                    order.setOrderStatus(order_status);
                    if(order_status == Order.ORDER_STATUS.FINISHED) orders.remove(order.getId());
                    else orders.put(order.getId(), order);
                }
                else {
                    System.out.println("Cannot set this status");
                }
            } else {
                orders.put(id, new Order(id));
            }
            start();
        } catch (IOException e) {
            e.printStackTrace();
            start();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Cannot find this status");
            start();
        }
    }
}
