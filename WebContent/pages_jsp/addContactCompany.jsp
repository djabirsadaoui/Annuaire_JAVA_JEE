<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AddContactCompany">
<table align="center">
<tr><td>Nom :</td><td><input type="text" name="nom" value="rihane"></td></tr>
<tr><td> Prénom :</td><td><input type="text" name="prenom" value="amine"></td></tr>
<tr><td> Email :</td><td><input type="text" name="mail" value="rihane.amine@hotmail.com"> </td></tr>
<tr><td> pays :</td><td> <input type="text" name="pays" value="france"></td></tr>
<tr><td> Rue :</td><td> <input type="text" name="rue" value="jussieu"></td></tr>
<tr><td> Ville :</td><td><input type="text" name="ville" value="cretiel"></td></tr>
<tr><td> Zip</td><td><input type="text" name="zip" value="95000"></td></tr>

<tr><td> Phone Kind :</td><td><input type="text" name="PhoneKind" value="0763456798"></td></tr>
<tr><td> Phone Number</td><td><input type="text" name="PhoneNumber" value="04123568790"></td></tr>
<tr><td> Group contacts</td><td><input type="text" name="GroupContacts"></td></tr>
<tr><td> NumSiret :</td><td><input type="text" name ="numsiret" value="99"></td></tr>
<tr><td rowspan="2"><input type="submit" value="Send"></td></tr>
</table>
</form>
</body>
</html>