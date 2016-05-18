<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="oracle.jdbc.rowset.*"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"  %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	<form action="updateSalary.jsp">
		Employee Id : <input type="text" name="empid" value="${param.empid}"  required="required" /> 
		New Salary : <input type="text" name="salary" value="${param.salary}" required="required" />
		<input type="submit"value="Update" />
	</form>
	<%
		String empid = request.getParameter("empid");
		if (empid == null) 
			return; // terminate jsp (jspService())
     %>
     
     <sql:setDataSource 
       var="oracle"
       url="jdbc:oracle:thin:@localhost:1521:xe"
       driver="oracle.jdbc.driver.OracleDriver"
       user="hr" 
       password="hr"
    />
    
    <sql:update  dataSource="${oracle}" var="count">
        update employees set salary = ? where employee_id = ?
        <sql:param value="${param.salary}"></sql:param>
        <sql:param value="${param.empid}"></sql:param>
    </sql:update>
    
    <c:if test="${count == 1}">
         <h3>Salary updated successfully!</h3>
    </c:if>
    
    <c:if test="${count == 0}">
         <h3>Sorry! Invalid employee id!</h3>
    </c:if>
    
     
     
    
 
</body>
</html>
