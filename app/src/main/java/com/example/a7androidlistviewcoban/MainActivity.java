package com.example.a7androidlistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView listView1;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = findViewById(R.id.listView1);
        arrayList = new ArrayList<>();
        arrayList.add("Android");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("IOS");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView1.setAdapter(adapter);
//        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "Long Click" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
