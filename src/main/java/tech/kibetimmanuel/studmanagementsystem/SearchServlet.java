package tech.kibetimmanuel.studmanagementsystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.kibetimmanuel.studmanagementsystem.dao.StudentDAO;
import tech.kibetimmanuel.studmanagementsystem.model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private final StudentDAO studentDAO = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var query = req.getParameter("query");
        List<Student> students = studentDAO.searchStudents(query);
        req.setAttribute("students", students);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
