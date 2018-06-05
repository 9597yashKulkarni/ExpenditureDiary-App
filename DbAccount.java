package com.example.yash.expediturediary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yash on 5/6/18.
 */

public class DbAccount
{
    private DbHelperAccount helperAccount;
    private final Context context;
    private SQLiteDatabase db;

    public static final String Row_keyid="id";
    public static final String Key_Day="Day";
    public static final String Key_Month="Month";
    public static final String Key_Year="Year";
    public static final String Key_balance="balance";
    public static final String Key_withdraw="withdraw";
    public static final String Key_deposit="deposit";
    public static final String Key_transfer="transfer";
    String[] Column_name=new String[]{Row_keyid,Key_Day,Key_Month,Key_Year,Key_balance,Key_withdraw,Key_deposit,Key_transfer};

    public static final String DB_name="Expenditure_Diary";
    public static final String Table_name="Account";
    public static final int DB_version=1;

    private static final String Db_create="create table "+Table_name +"("+Row_keyid+" integer primary key autoincrement, " +Key_Day+" integer, "+
            Key_Month+" integer, "+Key_Year+" integer, "+ Key_balance+" integer, "+Key_withdraw+" integer, "+Key_deposit+" integer, "+Key_transfer+" integer);";

    public DbAccount(Context context)
    {
            this.context=context;
            helperAccount=new DbHelperAccount(context);

    }

    class DbHelperAccount extends SQLiteOpenHelper
    {

        public DbHelperAccount(Context context)
        {
            super(context, DB_name, null,DB_version);

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase)
        {
            sqLiteDatabase.execSQL(Db_create);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
        {
            sqLiteDatabase.execSQL("Drop table if exists Expenditure");
            onCreate(sqLiteDatabase);
        }

    }

    public DbAccount open()
    {
        db=helperAccount.getWritableDatabase();
        return this;
    }

    public void close()
    {
        db.close();
    }

    public long insertDatabase(int Day,int Month,int Year,int withdraw,int balance,int deposit,int transfer)
    {
        ContentValues values=new ContentValues();
        values.put(Key_Day,Day);
        values.put(Key_Month,Month);
        values.put(Key_Year,Year);
        values.put(Key_balance,balance);
        values.put(Key_deposit,withdraw);
        values.put(Key_withdraw,deposit);
        values.put(Key_transfer,transfer);
        return db.insert(Table_name,null,values);
    }

    public Cursor getAllInfo()
    {
        return db.query(Table_name,Column_name,null,null,null,null,null);
    }

}
