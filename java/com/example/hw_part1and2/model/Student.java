package com.example.hw_part1and2.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected int mCwid;
    protected ArrayList<Course> mCourses;

    public Student(String mFirstName, String mLastName, int mCwid) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mCwid = mCwid;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmCwid() {
        return mCwid;
    }

    public void setmCwid(int mCwid) {
        this.mCwid = mCwid;
    }

    public ArrayList<Course> getCourses() {
        return mCourses;
    }

    public void setmCourses(ArrayList<Course> courses) {
        mCourses = courses;
    }
}
