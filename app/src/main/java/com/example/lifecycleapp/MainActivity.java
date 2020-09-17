package com.example.lifecycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button button;
ListView listView;
ArrayList<String> students=new ArrayList<>();
static String json="{\"university\":\"benha\",\"faculity\":\"FCAI\",\"students\":[{\"id\":1,\"name\"" +
        ":\"reem mosad\",\"age\":20,\"phone\":\"011245653333\"},{\"id\":2,\"name\":\"rana mosad\",\"" +
        "age\":16,\"phone\":\"011245156333\"},{\"id\":3,\"name\":\"ahmed mosad\",\"age\":25,\"phone\"" +
        ":\"010145653333\"},{\"id\":4,\"name\":\"medo salah\",\"age\":23,\"phone\":\"0120045653333\"}]}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn_show);
        listView=findViewById(R.id.lv);
        final ArrayAdapter<String>studentsAdapter=new ArrayAdapter<>(getApplicationContext(),R.layout.list_item,students);
        listView.setAdapter(studentsAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.clear();
                try {

                    JSONObject jsonroot=new JSONObject(json);
                    JSONArray jsonArray=jsonroot.getJSONArray("students");
                    for (int i=0;i<jsonArray.length();i++){
JSONObject student=jsonArray.getJSONObject(i);
int id=student.getInt("id");
String name=student.getString("name");
int age=student.getInt("age");
String phone=student.getString("phone");
students.add("Id:"+id+"\nName:"+name+"\n Age:"+age+"\n Phone"+phone);


                    }
                    studentsAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Toast.makeText(getApplicationContext(),"onCreate started",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart started",Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume started",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause started",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop started",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy started",Toast.LENGTH_LONG).show();

    }
}