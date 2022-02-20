package com.example.ineed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;
import services.response.AccountResponse;

public class Login extends AppCompatActivity {
    Button btLogin, btRegister;
    EditText edUsername, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        btLogin = findViewById(R.id.btLogin);
        btRegister = findViewById(R.id.btRegister);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);

        btLogin.setOnClickListener(view -> login());
    }

    private void login() {
        // call api searching in account
        // https://butter-enormous-talon.glitch.me/accounts?email=dvaccabu@gmail.com
        Call<List<AccountResponse>> call = MyApiAdapter.getApiService().getAccount("dvaccabu@gmail.com");
        call.enqueue(new Callback<List<AccountResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<AccountResponse>> call, @NonNull Response<List<AccountResponse>> response) {
                if(response.isSuccessful()){
                    List<AccountResponse> res = response.body();
                    if (res == null) throw new AssertionError();
                    AccountResponse ar = res.get(0);
                    Toast.makeText(Login.this, ar.toString(), Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Login.this, "Test1", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<AccountResponse>> call, @NonNull Throwable t) {
                Toast.makeText(Login.this, "Test2", Toast.LENGTH_LONG).show();
            }
        });
    }
}