package com.terresaalicia.belajarhewanwithkakterre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.terresaalicia.belajarhewanwithkakterre.helpers.BaseActivity;

public class LoginActivity extends BaseActivity {
    private EditText EditTextUsername;
    private EditText EditTextPassword;
    private Button ButtonLogin;
//    private Button ButtonTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupViews();
    }

    @Override
    protected void SetupViews() {
        EditTextUsername = findViewById(R.id.EditTextUsername);
        EditTextPassword = findViewById(R.id.EditTextPassword);
        ButtonLogin = findViewById(R.id.ButtonLogin);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = EditTextUsername.getText().toString();
                String password = EditTextPassword.getText().toString();

                if (username.equals("terresaalicia") && password.equals("onedayonejuta")) {
                    Log.d("LoginActivity", "Credentials are correct. Navigating to DashboardActivity.");
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, "Selamat datang!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Maaf, Username dan Password yang anda masukan salah! mohon ulangi kembali", Toast.LENGTH_SHORT).show();
                    Log.d("LoginActivity", "Invalid credentials.");
                }
            }
        });
    }
}