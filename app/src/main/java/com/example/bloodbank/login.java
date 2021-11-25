package com.example.bloodbank;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText uname, pass;
    Button b1;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.org));


            auth = FirebaseAuth.getInstance();

            uname = findViewById(R.id.uname);
            pass = findViewById(R.id.pass);
            b1 = findViewById(R.id.b1);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = uname.getText().toString();
                    String password = pass.getText().toString();
                    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                        Toast.makeText(login.this, "All the filds must be filled", Toast.LENGTH_SHORT).show();

                    } else {
                        auth.signInWithEmailAndPassword(name, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(login.this, homepage.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(login.this, "Autheication failed", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                });
                    }
                }
            });


        }
    }

    public void on(View view) {
        Intent intent = new Intent(login.this, sign_up.class);
        startActivity(intent);
        finish();

    }
}