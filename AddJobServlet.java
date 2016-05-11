AddJob.html
=============

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
</head>
<body>

	<h2>Add New Job</h2>

	<form action="addjob" method="post">
		Job Id <br /> 
		<input type="text" name="jobid" required="required" />
		<p/>
		Job Title <br /> 
		<input type="text" name="jobtitle" required="required" />
		<p />
		Min Salary <br /> 
		<input type="text" name="minsalary" />
		<p />
		Max Salary <br /> 
		<input type="text" name="maxsalary"  />
		<p />
		
		<p />
		<input type="submit" value="Add Job" />
	</form>

</body>
</html>


AddJobServlet.java
===================

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addjob")
public class AddJobServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("insert into jobs values(?,?,?,?)");
			ps.setString(1, request.getParameter("jobid"));
			ps.setString(2, request.getParameter("jobtitle"));

			String minsal = request.getParameter("minsalary");
			if (minsal.length() == 0)
				ps.setNull(3, Types.NUMERIC);
			else
				ps.setInt(3, Integer.parseInt(minsal));

			String maxsal = request.getParameter("maxsalary");
			if (maxsal.length() == 0)
				ps.setNull(4, Types.NUMERIC);
			else
				ps.setInt(4, Integer.parseInt(maxsal));

			ps.executeUpdate();
			pw.println("<h2>Added new job successfully! </h2>");

		} catch (Exception ex) {
			pw.println("<h2>Error : " + ex.getMessage() + "</h2>");
		}

	}
}
