package com.alex.task49;

import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
public class Order {
    private int id;
    private ORDER_STATUS orderStatus = ORDER_STATUS.NEW;

    public enum ORDER_STATUS {
        NEW, IN_PROGRESS, FINISHED, FAILED
    }

    public int getId() {
        return id;
    }

    public Order(int id) {
        this.id = id;
    }

    public ORDER_STATUS getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ORDER_STATUS orderStatus) {
        this.orderStatus = orderStatus;
    }
}
