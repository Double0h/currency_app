package com.example.android.doviz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.doviz.R;

public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    Intent intent = new Intent(splash.this, com.example.android.doviz.MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        splashThread.start();
    }
}
