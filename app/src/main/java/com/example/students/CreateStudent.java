package com.example.students;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateStudent extends AppCompatActivity {
    private Double promedio;
    private EditText id;
    private EditText name;
    private EditText last_name;
    private EditText nota_1;
    private EditText nota_2;
    private EditText nota_3;

    private Resources resources;
    private ArrayList<Student> list_students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student);


        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.txtName);
        last_name = (EditText) findViewById(R.id.txtLastName);
        nota_1 = (EditText) findViewById(R.id.txtNota1);
        nota_2 = (EditText) findViewById(R.id.txtNota2);
        nota_3 = (EditText) findViewById(R.id.txtNota3);



        resources = this.getResources();
        list_students = Data.get();
    }

    public void saveStudent(View view){

        String id_student = id.getText().toString();
        String name_student = name.getText().toString();
        String last_name_student = last_name.getText().toString();
        Double n1 = Double.parseDouble(nota_1.getText().toString());
        Double n2 = Double.parseDouble(nota_2.getText().toString());
        Double n3 = Double.parseDouble(nota_3.getText().toString());
        Double promedio = (n1+n2+n3)/3;
        if ((n1 < 0 || n1 >5) || (n2 < 0 || n2 >5) || (n3 < 0 || n3 >5)){
            Toast.makeText(this, R.string.Error, Toast.LENGTH_LONG).show();
        }else{
            Student s = new Student(id_student, name_student, last_name_student, n1,n2, n3, promedio);
            s.saveStudent();
            Toast.makeText(this, R.string.done, Toast.LENGTH_LONG).show();
        }



    }
}
