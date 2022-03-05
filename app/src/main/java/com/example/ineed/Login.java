package com.example.ineed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;
import model.Account;

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
        Call<List<Account>> call = MyApiAdapter.getApiService().getAccount(edUsername.getText().toString());
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(@NonNull Call<List<Account>> call, @NonNull Response<List<Account>> response) {
                if(response.isSuccessful()){
                    List<Account> res = response.body();
                    if (res == null) throw new AssertionError();
                    Account ac = res.get(0);
                    Toast.makeText(Login.this, ac.toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(Login.this, edPassword.getText().toString(), Toast.LENGTH_LONG).show();
                    if(ac.validate(edPassword.getText().toString())){
                        goToHome(ac);
                    } else {
                        Toast.makeText(Login.this, "Wrong credentials", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Login.this, "Error in response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Account>> call, @NonNull Throwable t) {
                Toast.makeText(Login.this, "Fail calling service", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void goToHome(Account ac) {
        Intent intent = new Intent(this, Search.class);
        intent.putExtra("account", ac);
        startActivity(intent);
    }
}