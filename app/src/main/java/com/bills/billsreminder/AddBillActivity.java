package com.bills.billsreminder;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddBillActivity extends AppCompatActivity {

    EditText name , day , amount;
    DB_Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        name = findViewById(R.id.name);
        day = findViewById(R.id.day);
        amount = findViewById(R.id.amount);

        controller = new DB_Controller(this , "",null , 1);

        final Button myBtn = findViewById(R.id.add) ;

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.insert_bill(name, day, amount);
                Toast.makeText(AddBillActivity.this , "ADDed", Toast.LENGTH_SHORT).show();

            }
        });


    }

//    public void addBill(){
//        try {
//            controller.insert_bill(name, day, amount);
//        }catch (SQLiteException e){
//            Toast.makeText(AddBillActivity.this , "Ops try Again" , Toast.LENGTH_SHORT).show();
//        }
//    }
}
