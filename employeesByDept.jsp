<%@page
	import="javax.sql.rowset.CachedRowSet,oracle.jdbc.rowset.OracleCachedRowSet"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee By Department</title>
</head>
<body>

	<h2>Employees By Department</h2>

	<form>
		Department Id : <input type="text" name="dept" value="${param.dept}"
			required="required" /> <input type="submit" value="Employees" />
		<p />
	</form>

	<%
		String dept = request.getParameter("dept");
		if (dept == null)
			return;

		// search for employees by name 
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setCommand("select * from employees where department_id = ?");
		crs.setString(1, dept);
		crs.execute();

		if (!crs.first()) {
			out.println("<h3>Sorry! No employees found!</h3>");
			crs.close();
			return;
		}
	%>

	<table border="1" style="width: 100%">
		<tr>
			<th>Name</th>
			<th>Job</th>
			<th>Salary</th>
		</tr>

		<%
			crs.beforeFirst();
			while (crs.next()) {
		%>
		<tr>
			<td><%=crs.getString("first_name")%></td>
			<td><%=crs.getString("job_id")%></td>
			<td><%=crs.getInt("salary")%></td>
		</tr>
		<%
			}
			crs.close();
		%>
	</table>

</body>
</html>
