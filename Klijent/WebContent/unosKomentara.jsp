<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos komentara</title>
<link href="<c:url value='/static/css/sminker.css' />" rel="stylesheet"></link>
</head>

<body>

	<a href="/Klijent/OdjavaServlet"> <button class="btnTabela" type="submit"> Odjavi se </button> </a>

	<center> <div class="kontejner">
		<form action="/Klijent/PostaviKomentarServlet" method="post">
		
			<textarea name="komentar" rows="10" cols="30"> Upisite komentar... </textarea>
			<input type="submit" value="Posaljite komentar">
			
		</form>
	</div> </center>

</body>
</html>