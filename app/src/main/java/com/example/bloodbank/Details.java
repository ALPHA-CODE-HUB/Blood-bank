package com.example.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
    Button b1;
    String tv2;
    TextView tv,name1,email1,phno1,gender1,btype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);




        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.org));
            b1 = findViewById(R.id.b1);
            tv = findViewById(R.id.ddnum);
            tv2 = tv.getText().toString();
            name1=findViewById(R.id.ddname);
            email1=findViewById(R.id.ddmail);
            phno1=findViewById(R.id.ddnum);
            gender1=findViewById(R.id.ddgen);
            btype=findViewById(R.id.ddbt);

            Bundle extras = getIntent().getExtras();
            String name=extras.getString("name");
            String email=extras.getString("e_mail");
            String phno=extras.getString("phonenumber");
            String gender=extras.getString("gender");
            String bType=extras.getString("bType");

            name1.setText(name);
            email1.setText(email);
            phno1.setText(phno);
            gender1.setText(gender);
            btype.setText(bType);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phno));
                    startActivity(intent);
                }
            });
        }
    }
}