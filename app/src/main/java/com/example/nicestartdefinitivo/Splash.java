package com.example.nicestartdefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    ImageView imFoto;
    ImageView rayo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openAp();


      rayo = findViewById(R.id.logosplash);

        //esto es para la animacion del logo
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.blink);
        rayo.startAnimation(myanim);

//esto para imagenes
        imFoto = findViewById(R.id.backView);
        Glide.with(this)
                .load("https://images.pexels.com/photos/19027548/pexels-photo-19027548/free-photo-of-pajaro-lago-nadando-cisne.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(imFoto);


    }

    private void openAp(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        },5000);

    }

}