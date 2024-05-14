package com.geeks.lesson2_month3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText emailAddress;
    EditText emailTheme;
    EditText emailText;
    Button btn_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailAddress = findViewById(R.id.emailAddress);
        emailTheme = findViewById(R.id.emailAddressTheme);
        emailText = findViewById(R.id.emailAddressText);
        View Button = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emailAddress.getText().toString().isEmpty() && !emailTheme.getText().toString().isEmpty() && !emailText.getText().toString().isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{emailAddress.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT,new String[]{emailTheme.getText().toString()});
                    intent.putExtra(Intent.EXTRA_TEXT,new String[]{emailText.getText().toString()});
                    intent.setData(Uri.parse("mailto:"));

                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "NO APP IS INSTALLED", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this,"Please complete the form",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

