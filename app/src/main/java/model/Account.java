package model;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class Account implements Serializable {
    int id;
    String email;
    String password;

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
