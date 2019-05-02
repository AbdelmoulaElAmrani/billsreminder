package com.bills.billsreminder;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

public class DB_Controller extends SQLiteOpenHelper {

    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "bills.db", factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BILLS(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , DAY INTEGER ,AMOUNT REAL ) ;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists bills");
        onCreate(db);
    }

    public void insert_bill(EditText name , EditText day , EditText amount){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME" , String.valueOf(name));
        contentValues.put("DAY" , String.valueOf(day));
        contentValues.put("AMOUNT" , String.valueOf(amount));


        this.getWritableDatabase().insertOrThrow("BILLS" ,"", contentValues);


    }

    public void delete_bill(Integer id){
        this.getWritableDatabase().delete("bills", "id='"+id+"'", null);
    }

//    public void update_bill(){
//        this
//    }

    public void list_all_bills(TextView textView){
        Cursor cursor  = this.getReadableDatabase().rawQuery("select * from bills" , null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1)+""+cursor.getString(2));
        }
    }

}
