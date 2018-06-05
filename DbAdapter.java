package com.example.yash.expediturediary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import java.time.Month;

/**
 * Created by yash on 12/12/17.
 */

public class DbAdapter
{
    public static final String Row_keyid="id";
    public static final String Key_Day="Day";
    public static final String Key_Month="Month";
    public static final String Key_Year="Year";
    public static final String Key_Data="Data";
    public static final String Key_Amt="Amt";
    String[] Column_name=new String[]{Row_keyid,Key_Day,Key_Month,Key_Year,Key_Data,Key_Amt};

    public static final String DB_name="Expenditure_Diary";
    public static final String Table_name="Expenditure";
    public static final int DB_version=1;

    private final Context context;
    private SQLiteDatabase db;
    private DbHelper dbhelper;

    private static final String Db_create="create table "+Table_name +"("+Row_keyid+" integer primary key autoincrement, " +Key_Day+" integer, "+
            Key_Month+" integer, "+Key_Year+" integer, "+ Key_Data+" text not null, "+Key_Amt+" integer);";

    public DbAdapter(Context context)
    {
        this.context=context;
        dbhelper=new DbHelper(context);
    }

    private static class DbHelper extends SQLiteOpenHelper
    {
        public DbHelper(Context context)
        {
            super(context, DB_name, null,DB_version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase)
        {
            sqLiteDatabase.execSQL(Db_create);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Drop table if exists Expenditure");
            onCreate(sqLiteDatabase);
        }
    }

    public DbAdapter open()
    {
        db=dbhelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        db.close();
    }

    public long insertDatabase(int Day,int Month,int Year,String Data,int Amt)
    {
        ContentValues values=new ContentValues();
        values.put(Key_Day,Day);
        values.put(Key_Month,Month);
        values.put(Key_Year,Year);
        values.put(Key_Data,Data);
        values.put(Key_Amt,Amt);

        return db.insert(Table_name,null,values);
    }

    public Cursor getAllStudent()
    {
        return db.query(Table_name,Column_name,null,null,null,null,null);
    }

    public Cursor getbyMonth()
    {
        String selection=Key_Month+" like ?";
        String sel_arg[]={"12"};
        return db.query(Table_name,Column_name,selection,sel_arg,null,null,null);
    }
}
