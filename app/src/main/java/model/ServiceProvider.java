package model;

import java.util.List;

public class ServiceProvider {
    private int id;
    private String fname;
    private String lname;
    private String phone;
    private String address;
    private List<Integer> servicelanguages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getServicelanguages() {
        return servicelanguages;
    }

    public void setServicelanguages(List<Integer> servicelanguages) {
        this.servicelanguages = servicelanguages;
    }

    @Override
    public String toString() {
        return fname + ' ' + lname;
    }
}
