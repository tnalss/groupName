package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_p1_name, tv_p2_name, tv_p3_name, tv_p4_name,
             tv_p1_price, tv_p2_price, tv_p3_price, tv_p4_price,
             tv_p1_qty, tv_p2_qty, tv_p3_qty, tv_p4_qty, tv_r_money;
    ProductDTO p_dto;
    MoneyDTO m_dto;
    ArrayList<ProductDTO> list;
    ArrayList<ResultDTO> result;
    EditText et_insert;
    Button btn_order_p1, btn_order_p2, btn_order_p3, btn_order_p4,
           btn_insert, btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_dto = new MoneyDTO(0);
        list = new ArrayList<>();
        result = new ArrayList<>();
        // 아이디 값 가져와서 초기화

        start();

        list.add(new ProductDTO(tv_p1_name.getText().toString(), Integer.parseInt(tv_p1_price.getText().toString()), Integer.parseInt(tv_p1_qty.getText().toString())));
        list.add(new ProductDTO(tv_p2_name.getText().toString(), Integer.parseInt(tv_p2_price.getText().toString()), Integer.parseInt(tv_p2_qty.getText().toString())));
        list.add(new ProductDTO(tv_p3_name.getText().toString(), Integer.parseInt(tv_p3_price.getText().toString()), Integer.parseInt(tv_p3_qty.getText().toString())));
        list.add(new ProductDTO(tv_p4_name.getText().toString(), Integer.parseInt(tv_p4_price.getText().toString()), Integer.parseInt(tv_p4_qty.getText().toString())));
        result.add(new ResultDTO(0,Integer.parseInt(tv_p1_price.getText().toString()),tv_p1_name.getText().toString()));
        result.add(new ResultDTO(0,Integer.parseInt(tv_p2_price.getText().toString()),tv_p2_name.getText().toString()));
        result.add(new ResultDTO(0,Integer.parseInt(tv_p3_price.getText().toString()),tv_p3_name.getText().toString()));
        result.add(new ResultDTO(0,Integer.parseInt(tv_p4_price.getText().toString()),tv_p4_name.getText().toString()));


        btn_order_p1.setOnClickListener(this);
        btn_order_p2.setOnClickListener(this);
        btn_order_p3.setOnClickListener(this);
        btn_order_p4.setOnClickListener(this);
        btn_insert.setOnClickListener(this);
        btn_return.setOnClickListener(this);


    }




//    // ----------- 현우 -------------
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_order_p1){
            if(list.get(0).getQty()==0) {
                Toast.makeText(MainActivity.this, "현재 품절 상품입니다.", Toast.LENGTH_SHORT).show();
            }else if(list.get(0).getPrice() > m_dto.getMoney()){
                Toast.makeText(MainActivity.this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }else{
                m_dto.setMoney(m_dto.getMoney() - list.get(0).getPrice());
                list.get(0).setQty(list.get(0).getQty()-1);
                tv_p1_qty.setText(""+list.get(0).getQty());
                tv_r_money.setText(""+m_dto.getMoney());
                // 구매한 개수더해줌
                result.get(0).setQty(result.get(0).getQty()+1);

            }
        }else if (v.getId() == R.id.btn_order_p2) {
            if(list.get(1).getQty()==0) {
                Toast.makeText(MainActivity.this, "현재 품절 상품입니다.", Toast.LENGTH_SHORT).show();
            }else if(list.get(1).getPrice() > m_dto.getMoney()){
                Toast.makeText(MainActivity.this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }else{
                m_dto.setMoney(m_dto.getMoney() - list.get(0).getPrice());
                list.get(1).setQty(list.get(1).getQty()-1);
                tv_p2_qty.setText(""+list.get(1).getQty());
                tv_r_money.setText(""+m_dto.getMoney());
                // 구매한 개수더해줌
                result.get(1).setQty(result.get(1).getQty()+1);
            }
        }else if (v.getId() == R.id.btn_order_p3) {
            if(list.get(2).getQty()==0) {
                Toast.makeText(MainActivity.this, "현재 품절 상품입니다.", Toast.LENGTH_SHORT).show();
            }else if(list.get(2).getPrice() > m_dto.getMoney()){
                Toast.makeText(MainActivity.this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }else{
                m_dto.setMoney(m_dto.getMoney() - list.get(2).getPrice());
                list.get(2).setQty(list.get(2).getQty()-1);
                tv_p3_qty.setText(""+list.get(2).getQty());
                tv_r_money.setText(""+m_dto.getMoney());
                // 구매한 개수더해줌
                result.get(2).setQty(result.get(2).getQty()+1);
            }
        }else if (v.getId() == R.id.btn_order_p4){
            if(list.get(3).getQty()==0) {
                Toast.makeText(MainActivity.this, "현재 품절 상품입니다.", Toast.LENGTH_SHORT).show();
            }else if(list.get(3).getPrice() > m_dto.getMoney()){
                Toast.makeText(MainActivity.this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }else{
                m_dto.setMoney(m_dto.getMoney() - list.get(3).getPrice());
                list.get(3).setQty(list.get(3).getQty()-1);
                tv_p4_qty.setText(""+list.get(3).getQty());
                tv_r_money.setText(""+m_dto.getMoney());
                // 구매한 개수더해줌
                result.get(3).setQty(result.get(3).getQty()+1);
            }
        }else if (v.getId() == R.id.btn_insert){
            int money = m_dto.getMoney();
            int insert = Integer.parseInt(et_insert.getText().toString());
            m_dto.setMoney(money+insert);
            tv_r_money.setText("잔액 : "+ m_dto.getMoney());

        }else if (v.getId() == R.id.btn_return){
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("m_dto", m_dto);
            intent.putExtra("r_dto", result);
            startActivity(intent);
        }
    }
    void start(){
        tv_p1_name =findViewById(R.id.tv_p1_name);
        tv_p2_name =findViewById(R.id.tv_p2_name);
        tv_p3_name =findViewById(R.id.tv_p3_name);
        tv_p4_name =findViewById(R.id.tv_p4_name);
        tv_p1_price =findViewById(R.id.tv_p1_price);
        tv_p2_price =findViewById(R.id.tv_p2_price);
        tv_p3_price =findViewById(R.id.tv_p3_price);
        tv_p4_price =findViewById(R.id.tv_p4_price);
        tv_p1_qty = findViewById(R.id.tv_p1_qty);
        tv_p2_qty = findViewById(R.id.tv_p2_qty);
        tv_p3_qty = findViewById(R.id.tv_p3_qty);
        tv_p4_qty = findViewById(R.id.tv_p4_qty);
        tv_r_money = findViewById(R.id.tv_r_money);
        et_insert = findViewById(R.id.et_insert);
        btn_order_p1 = findViewById(R.id.btn_order_p1);
        btn_order_p2 = findViewById(R.id.btn_order_p2);
        btn_order_p3 = findViewById(R.id.btn_order_p3);
        btn_order_p4 = findViewById(R.id.btn_order_p4);
        btn_insert = findViewById(R.id.btn_insert);
        btn_return = findViewById(R.id.btn_return);
    }
}