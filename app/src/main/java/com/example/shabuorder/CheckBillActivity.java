package com.example.shabuorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Dell on 5/12/2560.
 */


public class CheckBillActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbilllayout);


        Intent intent = getIntent();
        String total = intent.getStringExtra("total_value"); //(keyต้องตรงกัน,ค่าดีฟอล)

        TextView tv = (TextView)findViewById(R.id.price1);
        tv.setText(total);


    }
}
