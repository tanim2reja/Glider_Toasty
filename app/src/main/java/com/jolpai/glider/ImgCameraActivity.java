package com.jolpai.glider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;

public class ImgCameraActivity extends AppCompatActivity {
    Button button ;
    ImageView imageView ;
    Intent intent ;
    public  static final int RequestPermissionCode  = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_camera);
        this.getSupportActionBar().setTitle("Image by Camera");
        imageView =findViewById(R.id.imageView);

        EnableRuntimePermission();
        openCamera();
    }

    private void openCamera() {
       Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, 7);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            Glide.with(this)
                    .asBitmap()
                    .load(stream.toByteArray())
                    .into(imageView);
            //imageView.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA))
        {
            Toast.makeText(this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
        switch (RC) {
            case RequestPermissionCode:
                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(this,"Permission Granted, Now your " +
//                            "application can access CAMERA.", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(this,"Permission Canceled, Now your " +
                            "application cannot access CAMERA.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}