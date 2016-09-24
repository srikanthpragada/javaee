<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Factors</title>
</head>
<body>

	<h2>Factors</h2>
	<form action="factors.jsp">
		Number : <input type="text" name="number"  value="${param.number}" />
		<p />
		<input type="submit" value="Factors" />
	</form>

	<%
		// read input from client
		String input  = request.getParameter("number");
	    if (input == null)  // no input 
	    	return;  // stop jsp
	    	
	    int number  = Integer.parseInt(input);
	%>
	
	<ul>

		<%
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0)
					out.println("<li>" + i + "</li>");
			}
		%>

	</ul>


</body>
</html>
