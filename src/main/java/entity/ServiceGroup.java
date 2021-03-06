package entity;

public class ServiceGroup {
    private int id;
    private String name;

    public ServiceGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServiceGroup() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceGroup that = (ServiceGroup) o;

        if (id != that.id) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ServiceGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
