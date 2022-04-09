package model;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class Account implements Serializable {
    private int id;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(String password) {
        return this.password.equals(password);
    }

    @NonNull
    @Override
    public String toString() {
        return "AccountResponse{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
