package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	  @Override protected void doGet(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	  rd.forward(request, response); }
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter o =response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			String n =request.getParameter("username");
			String p =request.getParameter("password");
			 PreparedStatement pst = con.prepareStatement("select username from user where username=? and password=?");
			 pst.setString(1, n);
			 pst.setString(2, p);
			 ResultSet rs = pst.executeQuery();
			 if(rs.next())
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				 rd.forward(request, response);
			 }
			 else {
				 o.println("<font color=red size=18>Login Failed<br>");
				 o.println("<a href=Login.jsp>Try Again</a>");
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
