package com.example.ineed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        // call api searching in account
        // https://butter-enormous-talon.glitch.me/accounts?email=dvaccabu@gmail.com

    }
}