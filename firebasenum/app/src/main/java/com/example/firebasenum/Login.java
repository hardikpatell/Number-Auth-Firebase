package com.example.firebasenum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    private EditText etNum;
    private Button btnContinue;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etNum=findViewById(R.id.l_etNum);
        btnContinue=findViewById(R.id.l_btncontinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etNum.getText().toString().trim();
                if(number.isEmpty() || number.length()!=10){
                    etNum.setError("Enter Number");
                    etNum.requestFocus();
                    return;

                }
                String phoNenumber="+91"+number;
                Intent intent=new Intent(getApplicationContext(),Otp.class);
                intent.putExtra("phoneNumber",phoNenumber);
                startActivity(intent);

            }
        });
    }
}
