package com.example.janspinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    boolean Spinning;
    Random ramdom = new Random();
    int lastDir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle =findViewById(R.id.bottle);

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Spinning){
                    int newDir = ramdom.nextInt(1800);
                    float pivotx = bottle.getWidth() / 2 ;
                    float pivoty = bottle.getHeight() / 2 ;

                    Animation rotate = new RotateAnimation(lastDir,newDir,pivotx,pivoty);
                    rotate.setDuration(2500);
                    rotate.setFillAfter(true);

                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            Spinning =true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Spinning=false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    lastDir = newDir;
                    bottle.startAnimation(rotate);
                }
            }
        });

    }
}