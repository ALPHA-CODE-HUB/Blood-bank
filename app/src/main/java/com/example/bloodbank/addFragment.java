package com.example.bloodbank;

import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class addFragment extends Fragment {
    View v;
    View view;
    Button sign, login;
    private EditText email, Bloodtpe, scpassword, phone, sbu;
    private FirebaseAuth mAuth;
    private String userId;
    private RadioButton male, female;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_add, container, false);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.org));

            login = v.findViewById(R.id.sb);

            email = v.findViewById(R.id.smails);
            Bloodtpe = v.findViewById(R.id.spassword);
            phone = v.findViewById(R.id.snumber);
            scpassword = v.findViewById(R.id.scpassword);
            sbu = v.findViewById(R.id.sbt);
            mAuth = FirebaseAuth.getInstance();

            male = v.findViewById(R.id.malerb);
            female = v.findViewById(R.id.Femalerb);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registeruser();
                }
            });


        }


        return v;
    }

    private void registeruser() {
        String phonenumber = phone.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
        String bt = Bloodtpe.getText().toString().trim();
        String name = scpassword.getText().toString().trim();
        String btu = sbu.getText().toString().trim();
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
        if (bt.isEmpty()) {
            Bloodtpe.setError("Password required!");
            Bloodtpe.requestFocus();
            return;
        }


        user User = new user(mAuth.getUid(), e_mail, phonenumber, gender1, name, bt, btu);
        FirebaseDatabase.getInstance().getReference("Donors")
                .child(name)
                .setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(), "Account Created Successfully!", Toast.LENGTH_LONG).show();

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    user.sendEmailVerification();
                } else {
                    Toast.makeText(getActivity(), "Failed to create account, Try again", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}