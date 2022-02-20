package services.response;

import androidx.annotation.NonNull;

public class AccountResponse {
    int id;
    String email;
    String password;

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
