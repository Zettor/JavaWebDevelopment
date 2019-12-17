package by.ysenko.finaltask.bean;

import java.sql.Timestamp;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getStatus() == user.getStatus() &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword()) &&
                getSalt().equals(user.getSalt()) &&
                getEmail().equals(user.getEmail()) &&
                getPhone().equals(user.getPhone()) &&
                getCreateDate().equals(user.getCreateDate()) &&
                getRole().equals(user.getRole()) &&
                getCountry().equals(user.getCountry()) &&
                getCity().equals(user.getCity());
    }

    @Override
    public int hashCode() {
        return getLogin().hashCode()
                + getPassword().hashCode()
                + getEmail().hashCode()
                + getCreateDate().hashCode()
                + getStatus()
                + getRole();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", role=" + role +
                ", country=" + country +
                ", city=" + city +
                '}';
    }
}
