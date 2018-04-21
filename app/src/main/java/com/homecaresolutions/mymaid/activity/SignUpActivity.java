package com.homecaresolutions.mymaid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.homecaresolutions.mymaid.R;

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText mInputEmail;
    private TextInputEditText mInputPassword;
    private Button mSignUp;
    private TextView mSignIn;
    private TextView mForgotPassword;
    private ProgressBar mProgressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /* get Firebase Instance */
        auth = FirebaseAuth.getInstance();

        /* Finding elements from XML file */
        mInputEmail = findViewById(R.id.email);
        mInputPassword = findViewById(R.id.password);
        mSignUp = findViewById(R.id.signup);
        mSignIn = findViewById(R.id.signin);
        mForgotPassword = findViewById(R.id.forgort_password);
        mProgressBar = findViewById(R.id.progressBar);

        /* Handling onClick listeners */
        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, ResetPasswordActivity.class));
            }
        });

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mInputEmail.getText().toString().trim();
                String password = mInputPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    /* Add code to set TextInputLayout show error message instead of Toasts */
                    Toast.makeText(SignUpActivity.this,"Please enter email address",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    /* Add code to set TextInputLayout show error message instead of Toasts */
                    Toast.makeText(SignUpActivity.this,"Please enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mProgressBar.setVisibility(View.VISIBLE);

                /* creating user */
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUpActivity.this, "SignUp done!", Toast.LENGTH_SHORT).show();
                                mProgressBar.setVisibility(View.INVISIBLE);

                                if(!task.isSuccessful()){
                                    Toast.makeText(SignUpActivity.this, "signup failed!", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.GONE);
    }
}
