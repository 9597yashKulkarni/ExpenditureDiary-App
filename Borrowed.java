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

import java.io.Closeable;

public class Borrowed extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

   DrawerLayout mdrawer1;
    ActionBarDrawerToggle mtoggle1;
    int Day,Month,Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrowed);

        Day=getIntent().getIntExtra("Day",0);
        Month=getIntent().getIntExtra("Month",0);
        Year=getIntent().getIntExtra("Year",0);

        mdrawer1=(DrawerLayout)findViewById(R.id.drawerb);
       mtoggle1=new ActionBarDrawerToggle(this,mdrawer1,R.string.open,R.string.close);
        //mtoggle1=new ActionBarDrawerToggle(this,mdrawer1,"Open","Close");
        mdrawer1.addDrawerListener(mtoggle1);
        mtoggle1.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv=(NavigationView)findViewById(R.id.navigation_viewb);
        nv.setNavigationItemSelectedListener(this);
        Day=getIntent().getIntExtra("Day",0);
        Month=getIntent().getIntExtra("Month",0);
        Year=getIntent().getIntExtra("Year",0);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle1.onOptionsItemSelected(item))
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
            Intent i1=new Intent(Borrowed.this,Account.class);
            i1.putExtra("Day",Day);
            i1.putExtra("Month",Month);
            i1.putExtra("Year",Year);
            startActivity(i1);
            finish();
        }

        if (id== R.id.Petrol)
        {
            Toast.makeText(this,"This is Petrol",Toast.LENGTH_SHORT).show();
            Intent i2=new Intent(Borrowed.this,Petrol.class);
            i2.putExtra("Day",Day);
            i2.putExtra("Month",Month);
            i2.putExtra("Year",Year);
            startActivity(i2);
            finish();
        }

        if (id== R.id.Mess)
        {
            Toast.makeText(this,"This is Mess",Toast.LENGTH_SHORT).show();
            Intent i3=new Intent(Borrowed.this,Mess.class);
            i3.putExtra("Day",Day);
            i3.putExtra("Month",Month);
            i3.putExtra("Year",Year);
            startActivity(i3);
            finish();
        }

        if (id== R.id.Borrowed)
        {
            Toast.makeText(this,"This is Borrowed / Given",Toast.LENGTH_SHORT).show();
            Intent i4=new Intent(Borrowed.this,Borrowed.class);
            i4.putExtra("Day",Day);
            i4.putExtra("Month",Month);
            i4.putExtra("Year",Year);
            startActivity(i4);
            finish();
        }

        if (id== R.id.Daily)
        {
            Toast.makeText(this,"This is Daily Expenses",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Borrowed.this,Insert.class);
            i.putExtra("Day",Day);
            i.putExtra("Month",Month);
            i.putExtra("Year",Year);
            startActivity(i);
            finish();
        }

        return false;
    }
}
