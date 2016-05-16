<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="oracle.jdbc.rowset.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Employees</title>
</head>
<body>

	<form action="listemp.jsp">
		Department : <input type="text" name="deptid" value="${param.deptid}" /> <input type="submit"
			value="Employees" />
	</form>
	<%
		String deptid = request.getParameter("deptid");
		if (deptid == null || deptid.length() == 0)
			return; // terminate jsp (jspService())
			
		OracleCachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from employees where department_id = ?");
		crs.setString(1,deptid);
		crs.execute();
		// check whether rowset has any rows
		if (!crs.next())
		{
			out.println("<h3>Sorry! No employees found in the selected department!</h3>");
			return;
		}
    %>
    
    <h2>List of Employees</h2>
    <table border="1">
	  <tr><th>Employee Id </th><th>First Name </th><th>Salary </th></tr>
    		

   <%	
         crs.beforeFirst();
         while (crs.next()) {
			out.println("<tr><td>"  + crs.getString("employee_id") +
					    "</td><td>" + crs.getString("first_name") +
					    "</td><td>" + crs.getString("salary") + "</td></tr>");
		}
		crs.close();
	%>
</body>
</html>
