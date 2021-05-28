package entity;

public class Service {
    private int id;
    private String name;
    private int serviceGroupId;
    private double price;

    public Service(int id, String name, int serviceGroupId, double price) {
        this.id = id;
        this.name = name;
        this.serviceGroupId = serviceGroupId;
        this.price = price;
    }
    public Service(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServiceGroupId() {
        return serviceGroupId;
    }

    public void setServiceGroupId(int serviceGroupId) {
        this.serviceGroupId = serviceGroupId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (id != service.id) return false;
        if (serviceGroupId != service.serviceGroupId) return false;
        if (Double.compare(service.price, price) != 0) return false;
        return name.equals(service.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + serviceGroupId;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceGroupId=" + serviceGroupId +
                ", price=" + price +
                '}';
    }
}
