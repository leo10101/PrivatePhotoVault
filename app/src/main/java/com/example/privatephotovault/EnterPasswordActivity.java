package com.example.privatephotovault;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        EditText editText=findViewById(R.id.enteredPassword);
        Button button=findViewById(R.id.button2);
        SharedPreferences settings=getSharedPreferences("PREFS",0);
        String password=settings.getString("password","");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=editText.getText().toString();
                if(text.equals(password))
                {
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(EnterPasswordActivity.this,"Wrong password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}