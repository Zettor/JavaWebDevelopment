package by.ysenko.finaltask.bean;

import java.sql.Timestamp;

public class User extends Bean {

    private String login;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private Timestamp createDate;
    private int status;
    private Integer role;
    private Country country;
    private City city;

    public User() {
    }

    public User(String login, String password, String salt, String email, Timestamp createDate, int status, Integer role) {
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.createDate = createDate;
        this.status = status;
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", role=" + role +
                '}';
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
