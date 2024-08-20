package tech.kibetimmanuel.studmanagementsystem.dao;

import tech.kibetimmanuel.studmanagementsystem.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "iamkibeh", "122021994");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> searchStudents(String query) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name LIKE '%" + query + "%' OR phone_number LIKE '%" + query + "%'";
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql);
//              var stmt = conn.prepareStatement(sql);
//              var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                students.add(new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("phone_number"), rs.getInt("current_class"), rs.getString("latest_result")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public String getLatestResult(String studentId) {
        String latestResult = null;
        System.out.println("===================================");
        System.out.println("Student ID: " + studentId);
        System.out.println("===================================");
        String sql = "SELECT latest_result FROM students WHERE student_id = " + studentId;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("===================================");
                System.out.println("There was a results set");
                System.out.println("===================================");
                 latestResult = rs.getString("latest_result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latestResult;
    }

}
