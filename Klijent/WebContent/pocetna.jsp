<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zakazivanje frizera</title>
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>

<body>

	<a href="/Klijent/OdjavaServlet"> <button class="btnTabela" type="submit"> Odjavi se </button> </a>

	<h1> Frizerski salon </h1> <br>

	<h3> Moji termini </h3> <br>
	<table id="t01">
		<tr>
    		<th>Ime frizera</th>
    		<th>Prezime frizera</th> 
    		<th>Datum termina</th>
    		<th>Sisanje</th>
    		<th>Feniranje</th>
    		<th>Farbanje</th>
  		</tr>
		<c:forEach var="termin" items="${mojiTerminiFrizeri}">
			<tr>
				<td>
					${termin.frizer.ime}
				</td>
				<td>
					${termin.frizer.prezime}
				</td>
				<td>
					${termin.datum}
				</td>
				<td>
					<c:if test = "${termin.frizura.sisanje}">
						Da
					</c:if>
					<c:if test = "${!termin.frizura.sisanje}">
						Ne
					</c:if>
				</td>
				<td>
					<c:if test = "${termin.frizura.feniranje}">
						Da
					</c:if>
					<c:if test = "${!termin.frizura.feniranje}">
						Ne
					</c:if>
				</td>
				<td>
					<c:if test = "${termin.frizura.farbanje}">
						Da
					</c:if>
					<c:if test = "${!termin.frizura.farbanje}">
						Ne
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3> Frizeri </h3> <br>
	<table id="t01">
		<tr>
    		<th>Ime</th>
    		<th>Prezime</th> 
    		<th>Staz</th>
    		<th> </th>
  		</tr>
		<c:forEach var="frizer" items="${frizeri}">
			<tr>
				<td>
					${frizer.ime}
				</td>
				<td>
					${frizer.prezime}
				</td>
				<td>
					${frizer.staz}
				</td>
				<td>
					<center> <a href="/Klijent/VidiTermineFrizerServlet?frizerId=${frizer.id}"> <button class="btnTabela" type="submit"> Slobodni termini </button> </a> </center>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br> <br>
	
	<c:if test = "${zatrazeniTerminiFrizera}">
		<c:if test = "${imaTerminaFrizera}">
		<center> <div class="kontejner">
			<form action="/Klijent/SacuvajTerminFrizerski" method="post">
				<select name="terminId" >
					<c:forEach var="termin" items="${terminiFrizera}">
						<option value="${termin.id }"> ${termin.datum } </option>
					</c:forEach> 
				</select> <br> <br>
				Odaberite vrstu usluge: <br>
				<input type="checkbox" name="sisanje" value="true"> Sisanje <br>
				<input type="checkbox" name="feniranje" value="feniranje"> Feniranje <br>
				<input type="checkbox" name="farbanje" value="farbanje" > Farbanje <br>
				<input type="submit" value="Dalje">
			</form>
		</div> </center>
		</c:if>	
		<c:if test="${!imaTerminaFrizera}">
			<center> <div class="kontejner">
				Ovaj frizer trenutno nema slobodnih termina.
			</div> </center>
		</c:if>
		<c:if test="${cuvaSeTermin}" >
			  <c:if test="${!izabranaUsluga}">
			  <center>
				<div class="kontejner">
					<div>Niste izabrali uslugu. </div>
				</div>
			  </center>
			  </c:if>
		</c:if>
	</c:if>
	
	
</body>
</html>