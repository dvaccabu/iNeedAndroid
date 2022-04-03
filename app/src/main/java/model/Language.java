package model;

import java.io.Serializable;

public class Language implements Serializable {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
