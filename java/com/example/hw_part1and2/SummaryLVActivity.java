package com.example.hw_part1and2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.hw_part1and2.adapter.SummaryLVAdapter;
import com.example.hw_part1and2.model.Course;
import com.example.hw_part1and2.model.Student;
import com.example.hw_part1and2.model.StudentDB;

import java.util.ArrayList;

public class SummaryLVActivity extends Activity {

    protected ListView mSummaryView;
    protected Button mButton;
    protected SummaryLVAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.summary_listview);

        //createStudentObjects();
        mSummaryView = findViewById(R.id.summary_list_view_id);
        ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);
    }

    protected void createStudentObjects() {
        // Create Student object
        Student p = new Student("John", "Smith", 445343221);
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

    public void buttonClickAction(View view) {
        mButton = (Button) findViewById(R.id.buttonClick_id);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVehInputActivity();
            }
        });
    }

    public void openVehInputActivity() {
        Intent intent = new Intent(this, VehInputActivity.class);
        startActivity(intent);
    }
}
