package com.example.android.doviz;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.doviz.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView time;
    private TextView usd;
    private TextView Try;
    private TextView gbp;
    Handler mHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time= (TextView)findViewById(R.id.time);
        usd= (TextView)findViewById(R.id.usd);
        Try= (TextView)findViewById(R.id.aud);
        gbp= (TextView)findViewById(R.id.cad);



        this.mHandler = new Handler();
        m_Runnable.run();



    }

    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://data.fixer.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            com.example.android.doviz.ApiInterface api=retrofit.create(com.example.android.doviz.ApiInterface.class);

            Call<com.example.android.doviz.info> call=api.getInfos();
            call.enqueue(new Callback<com.example.android.doviz.info>() {
                @Override
                public void onResponse(Call<com.example.android.doviz.info> call, Response<com.example.android.doviz.info> response) {
                    com.example.android.doviz.info inf=response.body();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    Time.getCurrentTimezone();
                    String currentDateandTime = sdf.format(new Date());
                    time.setText(currentDateandTime);
                    usd.setText(String.valueOf(inf.getRates().getUSD()));
                    Try.setText(String.valueOf(inf.getRates().getTRY()));
                    gbp.setText(String.valueOf(inf.getRates().getGBP()));

                }

                @Override
                public void onFailure(Call<com.example.android.doviz.info> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

            MainActivity.this.mHandler.postDelayed(m_Runnable,2000);
        }

    };





}

