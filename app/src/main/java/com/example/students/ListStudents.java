package com.example.students;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListStudents extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Student> students;
    private ArrayList<String> studentsNames;
    private TextView txtNoResults;
    private Intent intent;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        listView = (ListView) findViewById(R.id.lvStudents);
        txtNoResults = (TextView)findViewById(R.id.NoStudents);
        students = Data.get();
        studentsNames = new ArrayList<String>();

        txtNoResults.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);

        if (students.size() > 0) {
            listView.setVisibility(View.VISIBLE);
            txtNoResults.setVisibility(View.INVISIBLE);

            for (int i = 0; i < students.size(); i++) {
                studentsNames.add(""+students.get(i).getId());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentsNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(ListStudents.this, StudentDetail.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
