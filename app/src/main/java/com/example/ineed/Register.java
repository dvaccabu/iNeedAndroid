package com.example.ineed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import model.Account;
import model.Customer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;

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
                if(checkDataEntered()) {
                    register();
                }
            }
        });
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private boolean checkDataEntered() {
        boolean flag = true;
        if (isEmpty(firstName)){
            Toast t = Toast.makeText(this, "Please Enter First Name to register", Toast.LENGTH_SHORT);
            t.show();
            flag = false;
        }

        if (isEmpty(lastName)){
            Toast t = Toast.makeText(this, "Please Enter Last Name to register", Toast.LENGTH_SHORT);
            t.show();
            flag = false;
        }

        if (isEmpty(username)){
            Toast t = Toast.makeText(this, "Please Enter UserName to register", Toast.LENGTH_SHORT);
            t.show();
            flag = false;
        }

        if (isEmpty(password)){
            Toast t = Toast.makeText(this, "Please Enter Password to register", Toast.LENGTH_SHORT);
            t.show();
            flag = false;
        }

        return flag;
    }

    private void register() {
        Call<Account> call = MyApiAdapter.getApiService().postNewAccount(username.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(@NonNull Call<Account> call, @NonNull Response<Account> response) {
                if(response.isSuccessful()){
                    Account res = response.body();
                    if (res == null) throw new AssertionError();
                    createCustomer(res.getId());
                }else {
                    Toast.makeText(Register.this, "Error in response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Account> call, @NonNull Throwable t) {
                Toast.makeText(Register.this, "Fail calling service", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createCustomer(int idAccount) {
        Call<Customer> call = MyApiAdapter.getApiService().postNewCustomer(firstName.getText().toString(), lastName.getText().toString(), idAccount);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(@NonNull Call<Customer> call, @NonNull Response<Customer> response) {
                if(response.isSuccessful()){
                    Customer res = response.body();
                    if (res == null) throw new AssertionError();
                    Toast.makeText(Register.this, "Register success", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Register.this.finish();
                        }
                    }, 2000);
                }else {
                    Toast.makeText(Register.this, "Error in response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Customer> call, @NonNull Throwable t) {
                Toast.makeText(Register.this, "Fail calling service", Toast.LENGTH_LONG).show();
            }
        });
    }


}