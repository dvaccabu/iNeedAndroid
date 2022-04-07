package model;

public class ServiceOffer {
    private int id;
    private int serviceId;
    private float price;
    private ServiceProvider serviceprovider;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ServiceProvider getServiceprovider() {
        return serviceprovider;
    }

    public void setServiceprovider(ServiceProvider serviceprovider) {
        this.serviceprovider = serviceprovider;
    }

    @Override
    public String toString() {
        return serviceprovider + "\t$ " + price;
    }
}
