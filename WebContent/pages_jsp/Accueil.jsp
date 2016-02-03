<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 String message = (String) request.getAttribute("test");
out.println(message);
%>
<%--<h2>visté :<%= getcompt() %> fois</h2>--%>
<h3> <a href="AddContact.jsp" >Add Contact</a>  
     <a href="RemoveContact.jsp" >Remove Contact</a>
     <a href="UpdateContact.jsp" >Update Contact</a>  
     <a href="SearchContact.jsp" >Search Contact</a> 
     <a href="addContactCompany.jsp" >addContactCompany</a> 
      

</h3>

</body>
</html>