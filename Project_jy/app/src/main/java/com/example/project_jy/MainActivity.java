package com.example.project_jy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

Button btn_order_p1,btn_order_p2, btn_order_p3, btn_order_p4, btn_insert, btn_return;
TextView tv_p1_name, tv_p2_name,tv_p3_name,tv_p4_name,tv_p1_price,tv_p2_price,tv_p3_price,tv_p4_price,tv_p1_qty,tv_p3_qty,tv_p4_qty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}