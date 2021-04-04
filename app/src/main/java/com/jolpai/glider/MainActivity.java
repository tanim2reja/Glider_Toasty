package com.jolpai.glider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    Button btnImgUrl, btnImgCamera, btnToastyTost ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setTitle("Home");
        btnImgUrl = findViewById(R.id.btnImgUrl);
        btnImgCamera = findViewById(R.id.btnImgCamera);
        btnToastyTost = findViewById(R.id.btnToast);

        btnImgUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ImgUrlActivity.class);
                startActivity(intent);
            }
        });

        btnImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ImgCameraActivity.class);
                startActivity(intent);
            }
        });

        btnToastyTost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.error(MainActivity.this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                //Toasty.success(MainActivity.this, "Success!", Toast.LENGTH_SHORT, true).show();
            }
        });

    }
}