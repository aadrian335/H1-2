package com.example.hw_part1and2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hw_part1and2.model.Course;
import com.example.hw_part1and2.model.Student;
import com.example.hw_part1and2.model.StudentDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createStudentObjects();
        setContentView(R.layout.student_summary);

        root = findViewById(R.id.student_summary);

        ArrayList<Student> studentList = StudentDB.getInstance().getmStudents();
        for (int i = 0; i < studentList.size(); i++) {
            Student p = studentList.get(i);
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);
            TextView firstNameView = (TextView) row_view.findViewById(R.id.first_name);
            firstNameView.setText(p.getmFirstName());
            TextView lastNameView = (TextView) row_view.findViewById(R.id.last_name);
            lastNameView.setText(p.getmLastName());
            TextView cwidView = (TextView) row_view.findViewById(R.id.cwid);
            cwidView.setText(p.getmCwid());

            root.addView(row_view);
        }
    }

    protected void createStudentObjects() {
        // Create Student object
        Student p = new Student("Joe", "Smith", 445343221);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411", "A"));
        p.setmCourses(courses);
        ArrayList<Student> personList = new ArrayList<Student>();
        personList.add(p);
        // Create another Student object
        p = new Student("William", "Lee", 445343256);
        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC359", "B+"));
        p.setmCourses(courses);
        personList.add(p);
        //
        StudentDB.getInstance().setmStudents(personList);
    }
}
