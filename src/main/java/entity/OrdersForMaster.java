package entity;

import java.sql.Date;
import java.sql.Time;

public class OrdersForMaster {
    private int id;
    private Date date;
    private String firstName;
    private String lastName;
    private String serviceName;
    private Time timeStart;
    private Time timeEnd;
    private String orderName;
    private String masterFirstName;
    private String masterLastName;
    private int masterId;

    public OrdersForMaster(int id, Date date, String firstName, String lastName, String serviceName, Time timeStart, Time timeEnd, String orderName, String masterFirstName, String masterLastName, int masterId) {
        this.id = id;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.serviceName = serviceName;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.orderName = orderName;
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
        this.masterId = masterId;
    }

    public OrdersForMaster() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getMasterFirstName() {
        return masterFirstName;
    }

    public void setMasterFirstName(String masterFirstName) {
        this.masterFirstName = masterFirstName;
    }

    public String getMasterLastName() {
        return masterLastName;
    }

    public void setMasterLastName(String masterLastName) {
        this.masterLastName = masterLastName;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersForMaster that = (OrdersForMaster) o;

        if (id != that.id) return false;
        if (masterId != that.masterId) return false;
        if (!date.equals(that.date)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!serviceName.equals(that.serviceName)) return false;
        if (!timeStart.equals(that.timeStart)) return false;
        if (!timeEnd.equals(that.timeEnd)) return false;
        if (!orderName.equals(that.orderName)) return false;
        if (!masterFirstName.equals(that.masterFirstName)) return false;
        return masterLastName.equals(that.masterLastName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + serviceName.hashCode();
        result = 31 * result + timeStart.hashCode();
        result = 31 * result + timeEnd.hashCode();
        result = 31 * result + orderName.hashCode();
        result = 31 * result + masterFirstName.hashCode();
        result = 31 * result + masterLastName.hashCode();
        result = 31 * result + masterId;
        return result;
    }

    @Override
    public String toString() {
        return "OrdersForMaster{" +
                "id=" + id +
                ", date=" + date +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", orderName='" + orderName + '\'' +
                ", masterFirstName='" + masterFirstName + '\'' +
                ", masterLastName='" + masterLastName + '\'' +
                ", masterId=" + masterId +
                '}';
    }
}
