<%@ page language="java" 
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="oracle.jdbc.rowset.OracleCachedRowSet"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
<style>
   .header { background-color:red; color:white; font-bold:true}
   body {font-family : verdana; font-size : 11pt}
   .stock { background-color:gray}
</style>
</head>
<body>
  <h2>List Of Jobs</h2>
  <table border="1">
     <tr class="header"><th>Id </th><th>Title </th> <th>Max Salary </th> </tr>
     
     <%
        OracleCachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select job_id, job_title, max_salary from jobs");
		crs.execute();
		
		while (crs.next())
		{
			if ( crs.getString("job_id").startsWith("ST"))
				out.println("<tr class='stock'>");
			else
				out.println("<tr>");
      %>
      
         <td> <%=crs.getString(1)%> </td> <td> <%=crs.getString(2)%> </td>
         <td style="text-align:right"> <%=crs.getInt(3) %> </td> </tr>
         
      <%			
		}
		
		crs.close();
      %>
      
  </table>
</body>
</html>
