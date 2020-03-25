<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zakazivanje sminkanja</title>
<link href="<c:url value='/static/css/sminker.css' />" rel="stylesheet"></link>
</head>
<body>

	<a href="/Klijent/OdjavaServlet"> <button class="btnTabela" type="submit"> Odjavi se </button> </a>

	<h1> Sminkerski salon </h1> <br>
	<h3> Moji termini </h3> <br>
	<table id="t01">
		<tr>
    		<th>Ime sminkera</th>
    		<th>Prezime sminkera</th> 
    		<th>Datum termina</th>
    		<th>Komentar</th>
    		<th> </th>
		<c:forEach var="termin" items="${mojiTerminiSminkeri}">
			<tr>
				<td>
					${termin.sminker.ime}
				</td>
				<td>
					${termin.sminker.prezime}
				</td>
				<td>
					${termin.datum}
				</td>
				<td>
					${termin.komentar}
				</td>
				<td>
					<c:if test="${not empty termin.komentar}" >  
						
					</c:if>
					<c:if test="${empty termin.komentar}" >  
						<center> <a href="/Klijent/DodajKomentarServlet?terminIdSminkerskiKomentar=${termin.id}"> <button class="btnTabela" type="submit"> Napisi komentar </button> </a> </center>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3> Sminkeri </h3> <br>
	<table id="t01">
		<tr>
    		<th>Ime</th>
    		<th>Prezime</th> 
    		<th>Staz</th>
    		<th> </th>
    		<th> </th>
  		</tr>
		<c:forEach var="sminker" items="${sminkeri}">
			<tr>
				<td>
					${sminker.ime}
				</td>
				<td>
					${sminker.prezime}
				</td>
				<td>
					${sminker.staz}
				</td>
				<td>
					<center> <a href="/Klijent/VidiTermineSminkerServlet?sminkerId=${sminker.id}"> <button class="btnTabela" type="submit"> Slobodni termini </button> </a> </center>
				</td>
				<td>
					<center> <a href="/Klijent/VidiKomentareServlet?sminkerId=${sminker.id}"> <button class="btnTabela" type="submit"> Ocene </button> </a> </center>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test = "${zatrazeniTerminiSminkera}">
		<c:if test = "${imaTerminaSminkera}">
			<center> <div class="kontejner">
				<form action="/Klijent/ZakaziServlet" method="post">
					<select name="terminIdS" >
						<c:forEach var="termin" items="${terminiSminkera}">
							<option value="${termin.id }"> ${termin.datum } </option>
						</c:forEach> 
					</select> <br>
					<input type="submit" value="Zakazi">
				</form>
			</div> <center> 
		</c:if>
		<c:if test="${!imaTerminaSminkera}">
			<center> <div class="kontejner">
				Ovaj sminker trenutno nema slobodnih termina.
			</div> </center>
		</c:if>
	</c:if>
	
	<c:if test = "${zatrazeniKomentari}">
		<c:if test = "${imaKomentara}">
			<h3> Komentari </h3> <br>
			<table id="t01">
				<c:forEach var="kom" items="${komentari}">
					<tr>
						<td>
							${kom}
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${!imaKomentara}">
			<center> <div class="kontejner">
				Ovaj sminker trenutno nema komentara.
			</div> </center>
		</c:if>
	</c:if>
	<br>
	<c:if test = "${uspesno}">
		<center> <div class="kontejner">
			Uspesno ste zakazali.
		</div> </center>
	</c:if>
	
</body>
</html>