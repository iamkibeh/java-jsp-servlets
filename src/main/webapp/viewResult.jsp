<%@ page import="tech.kibetimmanuel.studmanagementsystem.dao.StudentDAO" %>
<%@ page import="tech.kibetimmanuel.studmanagementsystem.model.Student" %>
<%@ page import="java.util.List" %>
<%
    String studentId = request.getParameter("studentId");
    if (studentId != null) {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.searchStudents(studentId);
        if (!students.isEmpty()) {
            Student student = students.get(0);
%>
<h3>Result for <%= student.getName() %>:</h3>
<p>Latest Result: <%= studentDAO.getLatestResult(studentId) %></p>
<%
        }
    }
%>
