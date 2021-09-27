package com.bhavyakukkar.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        final EditText username = (EditText) findViewById(R.id.usernameInput);
        final EditText password = (EditText) findViewById(R.id.passwordInput);

        final Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(username, password);
            }
        });
    }

    private void attemptLogin(EditText username, EditText password) {
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        String correctUsernameText = getString(R.string.admin_username);
        String correctPasswordText = getString(R.string.admin_password);

        if(usernameText == correctUsernameText)
            if(passwordText == correctPasswordText)
                correctLoginAttempt();
            else
                incorrectPassword();
        else
            incorrectUsername();
    }

    private void correctLoginAttempt() {
        String messageText = "Login Successful!";
        Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_SHORT).show();

        Intent switchToFormActivity = new Intent(this, FormActivity.class);
        startActivity(switchToFormActivity);
    }

    private void incorrectUsername() {
        String messageText = "Username not found!";
        Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_LONG).show();
    }

    private void incorrectPassword() {
        String messageText = "Wrong Password!";
        Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_LONG).show();
    }
}