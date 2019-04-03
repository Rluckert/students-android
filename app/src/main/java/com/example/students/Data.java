package com.example.students;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void save(Student s) {
        students.add(s);
    }

    public static ArrayList<Student> get() {
        return students;
    }
}
