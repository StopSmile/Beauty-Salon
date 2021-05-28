package entity;

import java.util.Date;

public class Order {
    private int id;
    private int clientId;
    private int masterId;
    private int timeSlotId;
    private Date date;
    private int serviceId;
    private int orderStatusId;


    public Order(int id, int clientId, int masterId, int timeSlotId, Date date, int serviceId, int orderStatusId) {
        this.id = id;
        this.clientId = clientId;
        this.masterId = masterId;
        this.timeSlotId = timeSlotId;
        this.date = date;
        this.serviceId = serviceId;
        this.orderStatusId = orderStatusId;
    }
    public Order(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (clientId != order.clientId) return false;
        if (masterId != order.masterId) return false;
        if (timeSlotId != order.timeSlotId) return false;
        if (serviceId != order.serviceId) return false;
        if (orderStatusId != order.orderStatusId) return false;
        return date.equals(order.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + clientId;
        result = 31 * result + masterId;
        result = 31 * result + timeSlotId;
        result = 31 * result + date.hashCode();
        result = 31 * result + serviceId;
        result = 31 * result + orderStatusId;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", masterId=" + masterId +
                ", timeSlotId=" + timeSlotId +
                ", date=" + date +
                ", serviceId=" + serviceId +
                ", orderStatusId=" + orderStatusId +
                '}';
    }
}
