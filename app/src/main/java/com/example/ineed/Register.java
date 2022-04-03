package com.example.ineed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText password;
    EditText username;
    Button btRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize() {
        firstName = findViewById(R.id.edFirstName);
        lastName = findViewById(R.id.edLastName);
        username = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        btRegister = findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });

        btRegister.setOnClickListener(view -> register());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    private void checkDataEntered() {
        if (isEmpty(firstName)){
            Toast t = Toast.makeText(this, "Please Enter First Name to register", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(lastName)){
            Toast t = Toast.makeText(this, "Please Enter Last Name to register", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(username)){
            Toast t = Toast.makeText(this, "Please Enter UserName to register", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(password)){
            Toast t = Toast.makeText(this, "Please Enter Password to register", Toast.LENGTH_SHORT);
            t.show();
        }
    }

    private void register() {



    }


}