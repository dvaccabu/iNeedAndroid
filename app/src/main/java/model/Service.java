package model;

import java.io.Serializable;

public class Service implements Serializable {
    private int id;
    private String name;
    private int categoryId;

    @Override
    public String toString() {
        return name;
    }
}
