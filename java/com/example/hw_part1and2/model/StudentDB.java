package com.example.hw_part1and2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    static public ArrayList<Student> mStudents; //changed from protected

    static public StudentDB getInstance() { return ourInstance; }

    private StudentDB() { createStudentObjects(); }

    public ArrayList<Student> getmStudents() { return mStudents; }

    public void setmStudents(ArrayList<Student> students) { mStudents = students; }

    static public void setStudentObjects(String fn, String ln, int cwid) {
        Student p = new Student(fn, ln, cwid);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411", "A"));
        p.setmCourses(courses);
        //mStudents = new ArrayList<Student>();
        mStudents.add(p);
    }

    protected void createStudentObjects() {
        // Create Student object



        Student p = new Student("First Name:   ", "   Last Name:   ", 0);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411", "A"));
        p.setmCourses(courses);
        mStudents = new ArrayList<Student>();
        mStudents.add(p);
        //ArrayList<Student> personList = new ArrayList<Student>();
        //personList.add(p);
        // Create another Student object
        /*
        p = new Student("", "", 0);
        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC359", "B+"));
        p.setmCourses(courses);
        mStudents.add(p);
        */


        //personList.add(p);
        //
        //StudentDB.getInstance().setmStudents(personList);
    }
}
