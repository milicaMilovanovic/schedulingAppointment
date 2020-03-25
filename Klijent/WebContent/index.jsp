<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="<c:url value='/static/css/login.css' />" rel="stylesheet"></link>
</head>

<body>

	<c:if test="${loginFailed && pokusanLogin}" >
	<div id="greske">
		<div> Niste uneli dobru sifru ili username. </div>
	</div>
	</c:if>
	
	<c:if test="${nijeUneto && pokusanLogin}" >  
	<div id="greske">
		<div> Niste popunili sva polja za login. </div>
	</div>
	</c:if>
	
	<div class="kontejnerLog">
		<h2> Login </h2>
		<form action="/Klijent/LoginServlet" method="POST">
			Ime: <input type="text" name="ime"> <br>
			Sifra: <input type="password" name="password"> <br>
			<input type="submit" value="Login">
		</form>
	</div>

</body>
</html>