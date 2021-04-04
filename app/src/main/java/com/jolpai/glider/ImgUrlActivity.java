package com.jolpai.glider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class ImgUrlActivity extends AppCompatActivity {

    ImageView imageView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_url);
        this.getSupportActionBar().setTitle("Image from Url");
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar2);

        Glide.with(this)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4sWBBKYir6yUYpW1KEWZlaDcLq6.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            })
            .into(imageView);
    }
}