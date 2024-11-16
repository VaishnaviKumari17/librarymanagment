/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vaishnavi
 */
@WebServlet(urlPatterns = {"/display"})
public class display extends HttpServlet {

    protected void doDisplay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String bookid = request.getParameter("bookid");

        String url = "jdbc:mysql://localhost:3306/libary"; 
        String user = "root";
        String pwd = "";

        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(url, user, pwd);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM stock WHERE bookid = ?");
            ps.setString(1, bookid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                out.print("<h3>Book Details is below..:</h3>");
                out.print("<p>Book ID: " + rs.getString("bookid") + "</p>");
                out.print("<p>Book Name: " + rs.getString("bookname") + "</p>");
                out.print("<p>Author Name: " + rs.getString("authorname") + "</p>");
                out.print("<p>Category: " + rs.getString("catgry") + "</p>");
            } else {
                out.print("<h3>This book id is not exit in the database.. Which you want to search you</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("<h3>Database Connection Error</h3>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doDisplay(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that displays product details by ID";
    }
}