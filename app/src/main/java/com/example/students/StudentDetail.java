package com.example.students;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentDetail extends AppCompatActivity {

    private Intent intent;
    private ArrayList<Student> students;
    private TextView id, name, last_name, n1, n2, n3, promedio;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);

        intent = getIntent();
        students = Data.get();

        int position = intent.getIntExtra("position", 0);
        id = (TextView)findViewById(R.id.id_value);
        name = (TextView)findViewById(R.id.name_value);
        last_name = (TextView)findViewById(R.id.last_name_value);
        n1 = (TextView)findViewById(R.id.nota1_value);
        n2 = (TextView)findViewById(R.id.nota2_value);
        n3 = (TextView)findViewById(R.id.nota3_value);
        promedio = (TextView)findViewById(R.id.promedio_value);
        Log.e(""+position, "onCreate: "+position );
        loadData(students.get(position));
    }

    private void loadData(Student student) {
        id.setText("ID: "+student.getId());
        name.setText("Nombre: "+student.getNombre());
        last_name.setText("Apellido: "+student.getApellido());
        n1.setText("Nota 1: "+student.getNota1());
        n2.setText("Nota 2: "+student.getNota2());
        n3.setText("Nota 3: "+student.getNota3());
        promedio.setText("Promedio: "+student.getPromedio());

    }
}
