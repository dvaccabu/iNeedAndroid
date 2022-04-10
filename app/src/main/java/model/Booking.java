package model;

public class Booking {
    int id;
    int customerId;
    int serviceproviderId;
    int serviceId;
    String bookingdate;
    String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceproviderId() {
        return serviceproviderId;
    }

    public void setServiceproviderId(int serviceproviderId) {
        this.serviceproviderId = serviceproviderId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getBookingDate() {
        return bookingdate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingdate = bookingDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", serviceproviderId=" + serviceproviderId +
                ", serviceId=" + serviceId +
                ", bookingDate='" + bookingdate + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
