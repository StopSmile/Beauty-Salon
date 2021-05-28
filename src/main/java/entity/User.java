package entity;

public class User {
    private int id;
    private int roleId;
    private int serviceGroupId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private int rating;

    public User(int id, int roleId, int serviceGroupId, String firstName, String lastName, String login, String password, String email, int rating) {
        this.id = id;
        this.roleId = roleId;
        this.serviceGroupId = serviceGroupId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.rating = rating;
    }
    public User(){

    }

    public User(int roleId, int serviceGroupID, String firstName, String lastName, String login, String password, String email, int rating) {
        this.roleId = roleId;
        this.serviceGroupId = serviceGroupID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getServiceGroupId() {
        return serviceGroupId;
    }

    public void setServiceGroupId(int serviceGroupId) {
        this.serviceGroupId = serviceGroupId;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (roleId != user.roleId) return false;
        if (serviceGroupId != user.serviceGroupId) return false;
        if (rating != user.rating) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roleId;
        result = 31 * result + serviceGroupId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", serviceGroupId=" + serviceGroupId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                '}';
    }
}
