package tech.kibetimmanuel.studmanagementsystem.model;

import tech.kibetimmanuel.studmanagementsystem.dao.StudentDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Student {
    private int studentId;
    private String name;
    private String phoneNumber;
    private int currentClass;
    private String latestResult;

    public Student(int studentId, String name, String phoneNumber, int currentClass, String latestResult) {
        this.studentId = studentId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentClass = currentClass;
        this.latestResult = latestResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(int currentClass) {
        this.currentClass = currentClass;
    }

    public String getLatestResult() {
        return latestResult;
    }

    public void setLatestResult(String latestClass) {
        this.latestResult = latestClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


}
