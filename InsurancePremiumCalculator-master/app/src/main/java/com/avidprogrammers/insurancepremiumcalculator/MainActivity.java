package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.motorcycle).setOnClickListener(listener_motorcycle);
        findViewById(R.id.privatecar).setOnClickListener(listener_privatecar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    View.OnClickListener listener_motorcycle = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, CC_motorcycle.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_privatecar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, CC_car.class);
            startActivity(intent);
        }
    };
}