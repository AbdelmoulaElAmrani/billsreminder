package com.bills.billsreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DB_Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btn behavior


        final Button myBtn = findViewById(R.id.button) ;

        final TextView txt = findViewById(R.id.text) ;


        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        controller = new DB_Controller(this , "",null , 1);

        controller.list_all_bills(txt);

    }
    public void openActivity2(){
        Intent intent = new Intent(this , AddBillActivity.class);
        startActivity(intent);


    }
}
