package com.example.androidcomback;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button add,update;
    EditText input;
    int count=0;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv= (ListView) findViewById(R.id.list);
        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);
        input = (EditText) findViewById(R.id.edit);
        arrayList = new ArrayList<>();


        ArrayAdapter lista= new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(lista);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                input.setText(arrayList.get(i).toString());
                count= i;
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                lista.notifyDataSetChanged();
                return false;
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(count,input.getText().toString());
                lista.notifyDataSetChanged();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().length()!=0){
                    arrayList.add(String.valueOf(input.getText()));
                    lista.notifyDataSetChanged();
                }

            }
        });
    }
}