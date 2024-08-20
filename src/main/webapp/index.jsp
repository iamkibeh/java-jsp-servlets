<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="tech.kibetimmanuel.studmanagementsystem.model.Student" %>
<%--<%@page import="Student" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Student Search</title>
</head>
<body>
<h2>Search Student</h2>
<form action="search" method="get">
    <label for="query">Name/ Student ID/ Phone Number:</label>
    <input type="text" name="query" placeholder="Enter name, student ID, or phone number" id="query">
    <input type="submit" value="Search">
</form>

<hr/>

<h3>Search Results:</h3>
<table style="border: 1px">
    <tr>
        <th>Name</th>
        <th>Student ID</th>
        <th>Phone Number</th>
        <th>Current Class</th>
        <th>Action</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student student : students) {
    %>
    <tr>
        <td><%= student.getName() %></td>
        <td><%= student.getStudentId() %></td>
        <td><%= student.getPhoneNumber() %></td>
        <td><%= student.getCurrentClass() %></td>
        <td>
            <form action="viewResult.jsp" method="get">
                <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                <input type="submit" value="View Result">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<div id="result">
    <jsp:include page="viewResult.jsp"/>
</div>
</body>
</html>