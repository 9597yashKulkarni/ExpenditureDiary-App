package com.example.yash.expediturediary;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class Calender extends AppCompatActivity
{

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        DatePicker dp= (DatePicker) findViewById(R.id.datePicker);
        Button insert= (Button) findViewById(R.id.button);
        Button display= (Button) findViewById(R.id.button2);

        final Calendar c =Calendar.getInstance();

        final int year=c.get(Calendar.YEAR);
        final int month=c.get(Calendar.MONTH);
        final int day=c.get(Calendar.DAY_OF_MONTH);

        System.out.print(year+" "+month+" "+day);
        /*
        final int day=dp.getDayOfMonth();
        final int month=dp.getMonth()+1;
        final int year=dp.getYear();*/

        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(Calender.this,Insert.class);
                i.putExtra("Day",day);
                i.putExtra("Month",month);
                i.putExtra("Year",year);
                startActivity(i);
            }
         });

        display.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i1=new Intent(Calender.this,Display.class);
                i1.putExtra("Day",day);
                i1.putExtra("Month",month);
                i1.putExtra("Year",year);
                startActivity(i1);
            }
        });
    }
}
