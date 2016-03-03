<%@ page contentType="text/html" %>
<html>
<head>
<title>Prime Number</title>
</head>
<body>

	<h2>Prime Number Test</h2>

	<form action="prime.jsp">
	    Number :  
	    <input type="text" name="number" value="${param.number}"/>
	    <p/>
		<input type="submit" value="Check" />
	</form>
	
	<jsp:useBean id="primeBean" scope="page"  class="beans.PrimeBean"/>
	<jsp:setProperty name="primeBean" property="number" />
	
	<h3>
	   ${primeBean.message} 
	</h3>
	
	
	

</body>
</html>
