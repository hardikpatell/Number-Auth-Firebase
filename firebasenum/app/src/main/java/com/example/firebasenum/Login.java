package com.example.firebasenum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etNum=findViewById(R.id.l_etNum);

        etNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etNum.getText().toString().trim();
                if(number.isEmpty()){
                    etNum.setError("Enter Number");
                    etNum.requestFocus();
                    return;

                }
                String phoNenumber= "+91"+number;
                Intent intent=new Intent(getApplicationContext(),Otp.class);
                intent.putExtra("phoneNumber",phoNenumber);
                startActivity(intent);
            }
        });
    }
}
