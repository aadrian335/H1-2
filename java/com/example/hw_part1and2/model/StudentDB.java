package com.example.hw_part1and2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> mStudents;

    static public StudentDB getInstance() { return ourInstance; }

    private StudentDB() { createStudentObjects(); }

    public ArrayList<Student> getmStudents() { return mStudents; }

    public void setmStudents(ArrayList<Student> students) { mStudents = students; }

    protected void createStudentObjects() {
        // Create Student object
        Student p = new Student("John", "Smith", 445343221);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411", "A"));
        p.setmCourses(courses);
        mStudents = new ArrayList<Student>();
        mStudents.add(p);
        //ArrayList<Student> personList = new ArrayList<Student>();
        //personList.add(p);
        // Create another Student object
        p = new Student("William", "Lee", 445343256);
        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC359", "B+"));
        p.setmCourses(courses);
        mStudents.add(p);
        //personList.add(p);
        //
        //StudentDB.getInstance().setmStudents(personList);
    }
}
