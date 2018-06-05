package com.example.yash.expediturediary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.yash.expediturediary.R.id.button8;
import static java.lang.Integer.parseInt;

public class Account extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

private DrawerLayout mdrawer2;
    private ActionBarDrawerToggle mtoggle2;
    int Day,Month,Year;
    EditText deposit,transfer,withdraw;
    TextView balance;
    Button save,display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mdrawer2=(DrawerLayout)findViewById(R.id.drawera);
        mtoggle2=new ActionBarDrawerToggle(this,mdrawer2,R.string.open,R.string.close);
        mdrawer2.addDrawerListener(mtoggle2);
        mtoggle2.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv=(NavigationView)findViewById(R.id.navigation_viewa);
        nv.setNavigationItemSelectedListener(this);

        Day=getIntent().getIntExtra("Day",0);
        Month=getIntent().getIntExtra("Month",0);
        Year=getIntent().getIntExtra("Year",0);
        final String CDate=Day+"/"+Month+"/"+Year;

        deposit= (EditText) findViewById(R.id.editText2);
        withdraw= (EditText) findViewById(R.id.editText4);
        transfer= (EditText) findViewById(R.id.editText6);
        balance= (TextView) findViewById(R.id.textView5);
        save= (Button) findViewById(R.id.button3);
        display= (Button) findViewById(button8);

        final DbAccount dbAccount=new DbAccount(this);

        save.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                dbAccount.open();
                int upBal=parseInt(balance.getText().toString());
                long id=dbAccount.insertDatabase(Day,Month,Year,parseInt(withdraw.getText().toString()),upBal,parseInt(deposit.getText().toString()),parseInt(transfer.getText().toString()));
                dbAccount.close();
                if(id>0)
                {
                    Toast.makeText(Account.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Account.this, "Data is not inserted properly", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle2.onOptionsItemSelected(item))
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
            Intent i1=new Intent(Account.this,Account.class);
            i1.putExtra("Day",Day);
            i1.putExtra("Month",Month);
            i1.putExtra("Year",Year);
            startActivity(i1);
            finish();
        }

        if (id== R.id.Petrol)
        {
            Toast.makeText(this,"This is Petrol",Toast.LENGTH_SHORT).show();
            Intent i2=new Intent(Account.this,Petrol.class);
            i2.putExtra("Day",Day);
            i2.putExtra("Month",Month);
            i2.putExtra("Year",Year);
            startActivity(i2);
            finish();
        }

        if (id== R.id.Mess)
        {
            Toast.makeText(this,"This is Mess",Toast.LENGTH_SHORT).show();
            Intent i3=new Intent(Account.this,Mess.class);
            i3.putExtra("Day",Day);
            i3.putExtra("Month",Month);
            i3.putExtra("Year",Year);
            startActivity(i3);
            finish();
        }

        if (id== R.id.Borrowed)
        {
            Toast.makeText(this,"This is Borrowed / Given",Toast.LENGTH_SHORT).show();
            Intent i4=new Intent(Account.this,Borrowed.class);
            i4.putExtra("Day",Day);
            i4.putExtra("Month",Month);
            i4.putExtra("Year",Year);
            startActivity(i4);
            finish();
        }

        if (id== R.id.Daily)
        {
            Toast.makeText(this,"This is Daily Expenses",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Account.this,Insert.class);
            i.putExtra("Day",Day);
            i.putExtra("Month",Month);
            i.putExtra("Year",Year);
            startActivity(i);
            finish();
        }

        return false;
    }
}
