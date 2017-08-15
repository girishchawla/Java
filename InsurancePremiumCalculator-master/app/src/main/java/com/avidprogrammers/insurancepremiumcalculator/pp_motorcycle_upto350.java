package com.avidprogrammers.insurancepremiumcalculator;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Abhishek on 26-Mar-17.
 */

public class pp_motorcycle_upto350 extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    private static final String TAG = "pp_motorcycle_upto350";
    private AdView mAdView;

    private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;

    long diffInDays;
    String selected;

    Button pp_motorcycle_upto350;

    EditText pp_motorcycle_upto350_idv_value;
    EditText pp_motorcycle_upto350_date_value;
    EditText pp_motorcycle_upto350_cc_value;
    EditText pp_motorcycle_upto350_nd_value;
    EditText pp_motorcycle_upto350_uwd_value;

    RadioGroup zoneRadioGroup;
    RadioGroup ndRadioGroup;

    static final int DATE_DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pp_motorcycle_upto350);
        getSupportActionBar().setTitle("Motorcycle Package Policy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        RadioButton nd_no = (RadioButton) findViewById(R.id.pp_motorcycle_upto350_nd_no);
        nd_no.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                EditText ed1=(EditText)findViewById(R.id.pp_motorcycle_upto350_nd_value);
                ed1.setEnabled(false);
                ed1.setText("0");



            }
        });
        RadioButton nd_yes = (RadioButton) findViewById(R.id.pp_motorcycle_upto350_nd_yes);
        nd_yes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                EditText ed1=(EditText)findViewById(R.id.pp_motorcycle_upto350_nd_value);
                long diffInDays=CalculateDifferenceInDays();
                double nd_value1=0.00;
                if (diffInDays < 365) {
                    nd_value1=15;
                }else if (diffInDays >= 365 ) {
                    if(diffInDays < 1825){
                        nd_value1 = 25;
                    }
                    else if (diffInDays >= 1825 ){
                        nd_value1 = 0;
                    }
                }
                int  nd_value1_int =(int) nd_value1;
                ed1.setText(String.valueOf(nd_value1_int));

                ed1.setEnabled(false);
                ed1.setVisibility(View.VISIBLE);
            }
        });

        //Date-start
        mDateDisplay = (TextView) findViewById(R.id.pp_motorcycle_upto350_date_value);
        mPickDate = (Button) findViewById(R.id.pp_motorcycle_upto350_date_btn);


        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });


        java.util.Calendar c = java.util.Calendar.getInstance();
        mYear = c.get(java.util.Calendar.YEAR);
        mMonth = c.get(java.util.Calendar.MONTH);
        mDay = c.get(java.util.Calendar.DAY_OF_MONTH);

        updateDisplay();
        //Date-end


        //spinner-start
        Spinner spin = (Spinner) findViewById(R.id.pp_motorcycle_upto350_ncb);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ncb);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        //spinner-end


        findViewById(R.id.pp_motorcycle_upto350_btn).setOnClickListener(listener_pp_motorcycle_upto350);


        //start-passvalues
        //Get the ids of view objects
        findAllViewsId();

        pp_motorcycle_upto350.setOnClickListener(this);
        //stop-passvalues
    };


    View.OnClickListener listener_pp_motorcycle_upto350 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(pp_motorcycle_upto350.this, ppdisplay_motorcycle_upto350.class);
            startActivity(intent);
        }
    };


    //start-passvalues
    private void findAllViewsId() {
        pp_motorcycle_upto350 = (Button) findViewById(R.id.pp_motorcycle_upto350_btn);

        pp_motorcycle_upto350_idv_value = (EditText) findViewById(R.id.pp_motorcycle_upto350_idv_value);
        pp_motorcycle_upto350_date_value = (EditText) findViewById(R.id.pp_motorcycle_upto350_date_value);
        pp_motorcycle_upto350_cc_value = (EditText) findViewById(R.id.pp_motorcycle_upto350_cc_value);
        pp_motorcycle_upto350_nd_value = (EditText) findViewById(R.id.pp_motorcycle_upto350_nd_value);
        pp_motorcycle_upto350_uwd_value = (EditText) findViewById(R.id.pp_motorcycle_upto350_uwd_value);

        zoneRadioGroup = (RadioGroup) findViewById(R.id.pp_motorcycle_upto350_zone);
        ndRadioGroup = (RadioGroup) findViewById(R.id.pp_motorcycle_upto350_nd);

    }


    @Override
    public void onClick(View v) {
        //Check for any EditText being null
        String idv_value = pp_motorcycle_upto350_idv_value.getText().toString();

        String uwd_value = pp_motorcycle_upto350_uwd_value.getText().toString();


        if (idv_value.equals("") || uwd_value.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), ppdisplay_motorcycle_upto350.class);
            //Create a bundle object
            Bundle b = new Bundle();

            //Inserts a String value into the mapping of this Bundle
            b.putString("pp_motorcycle_upto350_idv_value", pp_motorcycle_upto350_idv_value.getText().toString());
            b.putString("pp_motorcycle_upto350_date_value", pp_motorcycle_upto350_date_value.getText().toString());
            b.putString("pp_motorcycle_upto350_cc_value", pp_motorcycle_upto350_cc_value.getText().toString());
            b.putString("pp_motorcycle_upto350_nd_value", pp_motorcycle_upto350_nd_value.getText().toString());
            b.putString("pp_motorcycle_upto350_uwd_value", pp_motorcycle_upto350_uwd_value.getText().toString());

            int id1 = zoneRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton1 = (RadioButton) findViewById(id1);
            b.putString("pp_motorcycle_upto350_zone", radioButton1.getText().toString());

            int id2 = ndRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton2 = (RadioButton) findViewById(id2);
            b.putString("pp_motorcycle_upto350_nd", radioButton2.getText().toString());

            //Spinner value selected
            b.putString("pp_motorcycle_upto350_spinner_value", selected);

            //
            b.putInt("year", mYear);
            b.putInt("month", mMonth);
            b.putInt("day", mDay);
            //Add the bundle to the intent.
            intent.putExtras(b);

            //start the DisplayActivity
            startActivity(intent);
        }
    }
    //stop-passvalues


    //Date-start
    private void updateDisplay() {
        mDateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("-")
                        .append(mMonth + 1).append("-")
                        .append(mYear).append(" "));
        EditText ed1=(EditText)findViewById(R.id.pp_motorcycle_upto350_nd_value);
        long diffInDays=CalculateDifferenceInDays();
        double nd_value1=0.00;
        if (diffInDays < 365) {
            nd_value1=15;
        }else if (diffInDays >= 365 ) {
            if(diffInDays < 1825){
                nd_value1 = 25;
            }
            else if (diffInDays >= 1825 ){
                nd_value1 = 0;
            }
        }
        int  nd_value1_int =(int) nd_value1;
        ed1.setText(String.valueOf(nd_value1_int));
    }

    public long  CalculateDifferenceInDays(){

        int mYear_now,mMonth_now,mDay_now;
        // Create Calendar instance
        java.util.Calendar calendar1 = java.util.Calendar.getInstance();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        mYear_now = calendar1.get(java.util.Calendar.YEAR);
        mMonth_now = calendar1.get(java.util.Calendar.MONTH);
        mDay_now = calendar1.get(java.util.Calendar.DAY_OF_MONTH);

        // Set the values for the calendar fields YEAR, MONTH, and DAY_OF_MONTH.
        calendar2.set(mYear, mMonth, mDay);
        calendar1.set(mYear_now, mMonth_now, mDay_now);

            /*
            * Use getTimeInMillis() method to get the Calendar's time value in
            * milliseconds. This method returns the current time as UTC
            * milliseconds from the epoch
            */
        long miliSecondForDate1 = calendar1.getTimeInMillis();
        long miliSecondForDate2 = calendar2.getTimeInMillis();

        // Calculate the difference in millisecond between two dates
        long diffInMilis = miliSecondForDate1 - miliSecondForDate2;

             /*
              * Now we have difference between two date in form of millsecond we can
              * easily convert it Minute / Hour / Days by dividing the difference
              * with appropriate value. 1 Second : 1000 milisecond 1 Hour : 60 * 1000
              * millisecond 1 Day : 24 * 60 * 1000 milisecond
              */

        long diffInSecond = diffInMilis / 1000;
        long diffInMinute = diffInMilis / (60 * 1000);
        long diffInHour = diffInMilis / (60 * 60 * 1000);
        diffInDays = diffInMilis / ( 24 * 60 * 60 * 1000);

        return diffInDays;


    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }
    //Date-end


    //BackButton in title bar
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }




    //Spinner
    String[] ncb={"0","20","25","35","45","50"};

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View arg1, int position,long id) {

        Toast.makeText(getApplicationContext(), ncb[position], Toast.LENGTH_LONG);
        selected=parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }

}
