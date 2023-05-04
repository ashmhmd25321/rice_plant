package com.example.ricebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ricebuddy.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(v -> {
            String email = binding.signupEmail.getText().toString();
            String password = binding.signupPassword.getText().toString();
            String conPassword = binding.signupConfirmPassword.getText().toString();

            if (email.equals("") || password.equals("") || conPassword.equals("")) {
                Toast.makeText(this, "All fields are mandatory ", Toast.LENGTH_SHORT).show();
            } else {
                if (password.equals(conPassword)) {
                    Boolean checkUserEmail = databaseHelper.checkEmail(email);

                    if (checkUserEmail == false) {
                        Boolean insert = databaseHelper.insertData(email, password);

                        if (insert == true) {
                            Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "User already exists. Try login", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Passwords must match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.loginRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });

    }
}