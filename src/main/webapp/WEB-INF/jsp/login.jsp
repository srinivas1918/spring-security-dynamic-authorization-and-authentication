<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="j_spring_security_check" method="post">
<table>
	<tr>
	 <td>UserName :</td>
	 <td><input id="j_username" name="j_username" type="text" /></td>
	</tr>
	<tr>
	 <td>password :</td>
	 <td><input id="j_password" name="j_password" type="password" /></td>
	</tr>
</table>
<input  type="submit" value="Login"/>
</form>
</body>
</html>