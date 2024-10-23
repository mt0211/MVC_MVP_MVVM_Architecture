package com.example.mvp_architecture;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements LoginInterface{
    EditText editTextEmail, editTextPassword;
    TextView tvMessage;
    Button btnLogin;

    private LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        tvMessage = findViewById(R.id.tvMessage);
        btnLogin = findViewById(R.id.btnLogin);

        mLoginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        User user = new User(email, password);
        mLoginPresenter.login(user);
    }

    @Override
    public void loginSuccess() {
        tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setText("Login success");
    }

    @Override
    public void loginFailed() {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText("Email or password invalid");
    }
}