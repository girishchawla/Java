package com.avidprogrammers.insurancepremiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class lp_motorcycle_350above extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lp_motorcycle_350above);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Motorcycle Liability Policy");

        findViewById(R.id.homebtn350above).setOnClickListener(listener_homebtn350above);
    }

    View.OnClickListener listener_homebtn350above = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(lp_motorcycle_350above.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
