package com.example.bloodbank;


import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up extends AppCompatActivity {
    View view;
    Button sign, login;
    private EditText email, password, scpassword, phone, sbt;
    private FirebaseAuth mAuth;
    private String userId;
    private RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.org));

            login = findViewById(R.id.sb);

            email = findViewById(R.id.smails);
            password = findViewById(R.id.spassword);
            phone = findViewById(R.id.snumber);
            scpassword = findViewById(R.id.scpassword);
            sbt = findViewById(R.id.sbt);
            mAuth = FirebaseAuth.getInstance();

            male = findViewById(R.id.malerb);
            female = findViewById(R.id.Femalerb);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registeruser();
                }
            });

        }

    }

    private void registeruser() {
      /*  String phonenumber = phone.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String name = scpassword.getText().toString().trim();
        String bloodtype = sbt.getText().toString().trim();
        String gender = "";
        if (male.isChecked()) {
            gender = "male";
        } else if (female.isChecked()) {
            gender = "female";
        }
        String gender1 = gender;

        if (phonenumber.isEmpty()) {
            phone.setError("Phone number required!");
            phone.requestFocus();
            return;
        }

        if (e_mail.isEmpty()) {
            email.setError("Email required!");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(e_mail).matches()) {
            email.setError("Please provide valid email!");
            email.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            password.setError("Password required!");
            password.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            password.setError("Min password length should be 6 characters!");
        }


        mAuth.createUserWithEmailAndPassword(e_mail, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user User = new user(mAuth.getUid(), e_mail, phonenumber, gender1, name, bloodtype);
                            FirebaseDatabase.getInstance().getReference("Donors")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(sign_up.this, "Account Created Successfully!", Toast.LENGTH_LONG).show();

                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                        user.sendEmailVerification();
                                    } else {
                                        Toast.makeText(sign_up.this, "Failed to create account, Try again", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                        } else {
                            Toast.makeText(sign_up.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });*/
    }
}
