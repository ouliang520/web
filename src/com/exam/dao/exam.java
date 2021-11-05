package com.exam.dao;

public class exam {
    private String name;
    private int grades;
    private String time;

    public exam(String name, int grades, String time) {
        this.name = name;
        this.grades = grades;
        this.time = time;
    }

    public exam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
