<!DOCTYPE html>
<html>
<head>
<title>Factors</title>
</head>
<body>

	<h2>Factors</h2>
	<form action="factors.jsp">
		Number : <input type="text" name="number" value="${param.number}" />
		<p />
		<input type="submit" value="Submit" />
	</form>

	<%
		String num = request.getParameter("number");
		if (num == null)
			return; // stop jsp

		int number = Integer.parseInt(num);

		for (int i = 2; i <= number / 2; i++)
			if (number % i == 0)
				out.println("<p/>" + i);
	%>

</body>
</html>
