package model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private int id;
    private String name;
    private List<Service> services;

    @Override
    public String toString() {
        return name;
    }
}
