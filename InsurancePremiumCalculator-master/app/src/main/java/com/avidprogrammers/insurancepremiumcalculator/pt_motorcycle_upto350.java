package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class pt_motorcycle_upto350 extends AppCompatActivity {

    private static final String TAG = "pt_motorcycle_upto350";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pt_motorcycle_upto350);

        getSupportActionBar().setTitle("Motorcycle Policy Type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        findViewById(R.id.motorcycle_upto350_pp).setOnClickListener(listener_motorcycle_upto350_pp);
        findViewById(R.id.motorcycle_upto350_lp).setOnClickListener(listener_motorcycle_upto350_lp);
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    View.OnClickListener listener_motorcycle_upto350_pp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(pt_motorcycle_upto350.this, pp_motorcycle_upto350.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listener_motorcycle_upto350_lp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(pt_motorcycle_upto350.this, lp_motorcycle_upto350.class);
            startActivity(intent);
        }
    };

}
