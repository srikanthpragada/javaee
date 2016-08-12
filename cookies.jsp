<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cookie Demo</title>
</head>
<body>
 <h1>Cookies Demo</h1>

 <form action="cookie.jsp">
   Cookie Name : <input type="text" name="cname" value="${param.cname}" />
   <input type="submit" value="Get Value" />   
 </form>

 <h2>
 <%
       String cname = request.getParameter("cname");
       if (cname == null || cname.length() == 0)
    	   return;  // stop jsp here 
       
       boolean found = false; 
       for(Cookie c : request.getCookies()) {
    	   if (c.getName().equals(cname))
    	   {
    		    out.println(c.getValue());
    		    found  = true;
    		    break;
    	   }
       }
       
       if(! found)
    	    out.println("Sorry! Cookie not found!");
       
       
   %>
   </h2>
</body>
</html>
