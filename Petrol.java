package com.example.yash.expediturediary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Petrol extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    DrawerLayout mdrawer3;
    ActionBarDrawerToggle mtoggle3;
    int Day,Month,Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petrol);



        mdrawer3=(DrawerLayout)findViewById(R.id.drawerp);
        mdrawer3.addDrawerListener(mtoggle3);
        mtoggle3=new ActionBarDrawerToggle(this,mdrawer3,R.string.open,R.string.close);
        mtoggle3.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv=(NavigationView)findViewById(R.id.navigation_viewp);
        nv.setNavigationItemSelectedListener(this);

        Day=getIntent().getIntExtra("Day",0);
        Month=getIntent().getIntExtra("Month",0);
        Year=getIntent().getIntExtra("Year",0);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle3.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id== R.id.Account)
        {
            Toast.makeText(this,"This is Account",Toast.LENGTH_SHORT).show();
            Intent i1=new Intent(Petrol.this,Account.class);
            i1.putExtra("Day",Day);
            i1.putExtra("Month",Month);
            i1.putExtra("Year",Year);
            startActivity(i1);
            finish();
        }

        if (id== R.id.Petrol)
        {
            Toast.makeText(this,"This is Petrol",Toast.LENGTH_SHORT).show();
            Intent i2=new Intent(Petrol.this,Petrol.class);
            i2.putExtra("Day",Day);
            i2.putExtra("Month",Month);
            i2.putExtra("Year",Year);
            startActivity(i2);
            finish();
        }

        if (id== R.id.Mess)
        {
            Toast.makeText(this,"This is Mess",Toast.LENGTH_SHORT).show();
            Intent i3=new Intent(Petrol.this,Mess.class);
            i3.putExtra("Day",Day);
            i3.putExtra("Month",Month);
            i3.putExtra("Year",Year);
            startActivity(i3);
            finish();
        }

        if (id== R.id.Borrowed)
        {
            Toast.makeText(this,"This is Borrowed / Given",Toast.LENGTH_SHORT).show();
            Intent i4=new Intent(Petrol.this,Borrowed.class);
            i4.putExtra("Day",Day);
            i4.putExtra("Month",Month);
            i4.putExtra("Year",Year);
            startActivity(i4);
            finish();
        }

        if (id== R.id.Daily)
        {
            Toast.makeText(this,"This is Daily Expenses",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Petrol.this,Insert.class);
            i.putExtra("Day",Day);
            i.putExtra("Month",Month);
            i.putExtra("Year",Year);
            startActivity(i);
            finish();
        }

        return false;
    }
}
