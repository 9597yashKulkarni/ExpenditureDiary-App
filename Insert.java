package com.example.yash.expediturediary;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class Insert extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DbAdapter dbAdapter;
    private Button back,save,add;
    private EditText Amt,Data;

    DrawerLayout mdrawer;
    ActionBarDrawerToggle mtoggle;

    int Day,Month,Year;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Amt= (EditText) findViewById(R.id.editText5);
        Data= (EditText) findViewById(R.id.editText3);

        back=(Button) findViewById(R.id.button5);
        add=(Button) findViewById(R.id.button6);
        save=(Button) findViewById(R.id.button4);

        mdrawer=(DrawerLayout)findViewById(R.id.drawer);
        mtoggle=new ActionBarDrawerToggle(this,mdrawer,R.string.open,R.string.close);
        mdrawer.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv=(NavigationView)findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(this);

        dbAdapter=new DbAdapter(this);

         Day=getIntent().getIntExtra("Day",0);
         Month=getIntent().getIntExtra("Month",0);
         Year=getIntent().getIntExtra("Year",0);

        final String CDate=Day+"/"+Month+"/"+Year;

      //  final Menu menu=nv.getMenu();
      //  menu.add("Yash"+2);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(Insert.this,Calender.class);
                startActivity(i);
                finish();
            }

        });

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                dbAdapter.open();
                long id=dbAdapter.insertDatabase(Day,Month,Year,Data.getText().toString(),parseInt(Amt.getText().toString()));
                dbAdapter.close();
                if(id>0)
                {
                    Toast.makeText(Insert.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Insert.this, "Data is not inserted properly", Toast.LENGTH_SHORT).show();
                }
                Data.setText("");
                Amt.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Insert.this,Display.class);
                startActivity(i1);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item))
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
            Intent i1=new Intent(Insert.this,Account.class);
            i1.putExtra("Day",Day);
            i1.putExtra("Month",Month);
            i1.putExtra("Year",Year);
            startActivity(i1);
            finish();
        }

        if (id== R.id.Petrol)
        {
            Toast.makeText(this,"This is Petrol",Toast.LENGTH_SHORT).show();
            Intent i2=new Intent(Insert.this,Petrol.class);
            i2.putExtra("Day",Day);
            i2.putExtra("Month",Month);
            i2.putExtra("Year",Year);
            startActivity(i2);
            finish();
        }

        if (id== R.id.Mess)
        {
            Toast.makeText(this,"This is Mess",Toast.LENGTH_SHORT).show();
            Intent i3=new Intent(Insert.this,Mess.class);
            i3.putExtra("Day",Day);
            i3.putExtra("Month",Month);
            i3.putExtra("Year",Year);
            startActivity(i3);
            finish();
        }

        if (id== R.id.Borrowed)
        {
            Toast.makeText(this,"This is Borrowed / Given",Toast.LENGTH_SHORT).show();
            Intent i4=new Intent(Insert.this,Borrowed.class);
            i4.putExtra("Day",Day);
            i4.putExtra("Month",Month);
            i4.putExtra("Year",Year);
            startActivity(i4);
            finish();
        }

        if (id== R.id.Daily)
        {
            Toast.makeText(this,"This is Daily Expenses",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Insert.this,Insert.class);
            i.putExtra("Day",Day);
            i.putExtra("Month",Month);
            i.putExtra("Year",Year);
            startActivity(i);
            finish();
        }

        return false;
    }


}
