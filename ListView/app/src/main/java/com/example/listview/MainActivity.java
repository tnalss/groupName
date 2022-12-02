package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
      /*  ArrayList<CountryDTO> list = new ArrayList<>();
       list.add(new CountryDTO(R.drawable.img0,"대한민국","Korea Republic"));
       list.add(new CountryDTO(R.drawable.img1,"아르헨티나","Argentina"));
       list.add(new CountryDTO(R.drawable.img2,"호주","Australia"));
       list.add(new CountryDTO(R.drawable.img3,"벨기에","Belgium"));
       list.add(new CountryDTO(R.drawable.img4,"브라질","Brazil"));
       list.add(new CountryDTO(R.drawable.img5,"카메룬","Cameroon"));
       list.add(new CountryDTO(R.drawable.img6,"캐나다","Canada"));
       list.add(new CountryDTO(R.drawable.img7,"코스타리카","Costa Rica"));
       list.add(new CountryDTO(R.drawable.img8,"크로아티아","Croatia"));
       list.add(new CountryDTO(R.drawable.img9,"덴마크","Denmark"));
       list.add(new CountryDTO(R.drawable.img10,"에콰도르","Ecuador"));
       list.add(new CountryDTO(R.drawable.img11,"잉글랜드","England"));
       list.add(new CountryDTO(R.drawable.img12,"프랑스","France"));*/

        //Adapter adapter = new Adapter(list,getLayoutInflater());

        count = getResources().obtainTypedArray(R.array.countries).length();

        Adapter adapter = new Adapter(getLayoutInflater(),count );
        listView.setAdapter(adapter);

    }
}