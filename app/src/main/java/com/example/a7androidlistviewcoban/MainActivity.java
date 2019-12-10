package com.example.a7androidlistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView listView1;
    EditText editText1;
    Button butTon1, butTon2, butTon3;
    ArrayList<String> arrayList;
    int viTri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = findViewById(R.id.listView1);
        editText1 = findViewById(R.id.editText1);
        butTon1 = findViewById(R.id.butTon1);
        butTon2 = findViewById(R.id.butTon2);
        butTon3 = findViewById(R.id.butTon3);
        arrayList = new ArrayList<>();
        arrayList.add("Android");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("IOS");
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
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
        butTon1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String aaa = editText1.getText().toString();
                arrayList.add(aaa);
                adapter.notifyDataSetChanged();
            }
        });
        // đọc dữ liệu listview đưa lên edittext
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                editText1.setText(arrayList.get(position));
                viTri = position;
            }
        });
        butTon2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                arrayList.set(viTri, editText1.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
