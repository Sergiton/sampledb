/*Git Hub*/

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessLogin
 */
@WebServlet("/NewServletC")
public class NewServletC extends HttpServlet {
	//before
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/emp";
	   //127.0.0.1

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "admin";
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String email = request.getParameter("email");
		
         login_valid(id,username,password,email);
		
		pw.println("Successfully Registered");
		
		pw.close();
	}
	


private boolean login_valid(int id,String u_name, String u_pwd,String u_mail) {
	Connection conn = null;
	Statement stmt = null;
	try{
	   //STEP 2: Register and Load JDBC driver
	   Class.forName("com.mysql.jdbc.Driver");
	
	   //STEP 3: Open a connection to database server
	   System.out.println("Connecting to database...");
	   conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	   System.out.println("Connected to database...");
	   //STEP 4: Execute a query
	   System.out.println("Creating statement...");
	
	  
	   String sql; 
	   sql = "insert into empa values(?,?,?,?)";
	   
	   PreparedStatement pst1=conn.prepareStatement(sql);
	   pst1.setInt(1, id);
	   pst1.setString(2, u_name);
	   pst1.setString(3, u_pwd);
	   pst1.setString(4,u_mail);
	   pst1.execute();
	   
	 

		
	  
	  
	}catch(SQLException se){
	   //Handle errors for JDBC
	   se.printStackTrace();
	}catch(Exception e){
	   //Handle errors for Class.forName
	   e.printStackTrace();
	}
	System.out.println("Done...");
	return false;
	
	
}//end main

}
