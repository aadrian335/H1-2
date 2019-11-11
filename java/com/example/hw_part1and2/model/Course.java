package com.example.hw_part1and2.model;

public class Course {

    protected String mCourseID;
    protected String mGrade;

    public Course(String mCourseID, String mGrade) {
        this.mCourseID = mCourseID;
        this.mGrade = mGrade;
    }

    public String getmCourseID() {
        return mCourseID;
    }

    public void setmCourseID(String mCourseID) {
        this.mCourseID = mCourseID;
    }

    public String getmGrade() {
        return mGrade;
    }

    public void setmGrade(String mGrade) {
        this.mGrade = mGrade;
    }
}
