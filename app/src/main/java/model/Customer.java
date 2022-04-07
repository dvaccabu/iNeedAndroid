package model;

public class Customer {
    int id;
    String fname;
    String lname;
    String phone;
    String address;
    int accountId;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", accountId=" + accountId +
                '}';
    }

}
