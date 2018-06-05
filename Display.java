package com.example.yash.expediturediary;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Display extends AppCompatActivity {

    LineGraphSeries<DataPoint> series=new LineGraphSeries<>(new DataPoint[0]);
    GraphView graphView;
    DbAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        db=new DbAdapter(this);
        init();
      /* double x,y;
        x=-0.5;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series=new LineGraphSeries<DataPoint>();

        for(int i=0;i<500;i++)
        {
            x=x+0.1;
            y=Math.sin(x);
            series.appendData(new DataPoint(x,y),true,500);
        }

        graph.addSeries(series);
         graphView= (GraphView) findViewById(R.id.graph);

        db=new DbAdapter(this);
        series.resetData(getDataPoint());
        graphView.addSeries(series);*/
    }

   /* private DataPoint[] getDataPoint()
    {
        String[] column={"Key_Date","Key_Amt"};
        Cursor cursor=db.getAllStudent();
        DataPoint[] dp=new DataPoint[cursor.getCount()];
        if(cursor.moveToFirst())
        {
            do
            {
                Toast.makeText(Display.this, "id :"+cursor.getString(0)+" Date : "+cursor.getString(1)+"Data :"+cursor.getString(2)+"Amt : "+cursor.getString(3), Toast.LENGTH_SHORT).show();
            }while(cursor.moveToNext());
        }
       // dbAdapter.close();

        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();
            dp[i]=new DataPoint(cursor.getInt(1),cursor.getInt(3));

        }
        return dp;
    }*/
   public void init() {

       db.open();
       Cursor c=db.getAllStudent();
       //Cursor c=db.getbyMonth();
       TableLayout stk = (TableLayout) findViewById(R.id.table_main);
       TableRow tbrow0 = new TableRow(this);
       TextView tv0 = new TextView(this);
       tv0.setText(" Sl.No ");
       tv0.setTextColor(Color.WHITE);
       tv0.setGravity(Gravity.CENTER);
       tbrow0.addView(tv0);
       TextView tv1 = new TextView(this);
       tv1.setText(" Date ");
       tv1.setTextColor(Color.WHITE);
       tv1.setGravity(Gravity.CENTER);
       tbrow0.addView(tv1);
       TextView tv2 = new TextView(this);
       tv2.setText(" Cause ");
       tv2.setTextColor(Color.WHITE);
       tv2.setGravity(Gravity.CENTER);
       tbrow0.addView(tv2);
       TextView tv3 = new TextView(this);
       tv3.setText(" Amount in rs");
       tv3.setTextColor(Color.WHITE);
       tv3.setGravity(Gravity.CENTER);
       tbrow0.addView(tv3);
       stk.addView(tbrow0);

       if(c.moveToFirst())
       {
           do
           {
               //Toast.makeText(Display.this, "id :"+c.getString(0)+" Date : "+c.getString(1)+"Data :"+c.getString(2)+"Amt : "+c.getString(3), Toast.LENGTH_SHORT).show();


                   TableRow tbrow = new TableRow(this);
                   TextView t1v = new TextView(this);
                   t1v.setText(c.getString(0));
                   t1v.setTextColor(Color.WHITE);
                   t1v.setGravity(Gravity.CENTER);
                   tbrow.addView(t1v);
                   TextView t2v = new TextView(this);
                   t2v.setText(" "+c.getString(1)+"/"+c.getString(2)+"/"+c.getString(3)+" ");
                   t2v.setTextColor(Color.WHITE);
                   t2v.setGravity(Gravity.CENTER);
                   tbrow.addView(t2v);
                   TextView t3v = new TextView(this);
                   t3v.setText(" "+c.getString(4)+" ");
                   t3v.setTextColor(Color.WHITE);
                   t3v.setGravity(Gravity.CENTER);
                   tbrow.addView(t3v);
                   TextView t4v = new TextView(this);
                   t4v.setText(" "+c.getString(5)+" ");
                   t4v.setTextColor(Color.WHITE);
                   t4v.setGravity(Gravity.CENTER);
                   tbrow.addView(t4v);
                   stk.addView(tbrow);

           }while(c.moveToNext());
       }
       db.close();


      //for (int i = 0; i < 25; i++) {


    // }

   }
}
