package com.example.dalellegamlek_admin.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.dalellegamlek_admin.R;

public class Login extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);


        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEmailView.getText().toString();
                String passsword = mPasswordView.getText().toString();
                if (name.equalsIgnoreCase("admin") && passsword.equalsIgnoreCase("aaaa1111A@")) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }
                if (name.equalsIgnoreCase("admin") && passsword.equalsIgnoreCase("dalale@7793")) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }
                if (name.equalsIgnoreCase("admin") && passsword.equalsIgnoreCase("gmalek@7793")) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }

            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }
}
