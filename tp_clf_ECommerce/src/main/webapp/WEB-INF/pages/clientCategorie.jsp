<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Model</title>
<script type="text/javascript"
	src='<c:url value="/resources/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/jquery-3.1.1.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/resources/bootstrap.css"/>' />
</head>
<body background='<c:url value="/resources/fonecran.jpg"/>'>

	<%@include file="/resources/include/menuClient.html"%>

	<div style="width: 700px; margin: auto; margin-top: 80px">
		<h2 style="color:fuchsia">Liste des categories</h2>

		<table class="table table-hover" style="color: white">
			<tr>
				<th>Nom</th>
				<th>Description</th>
			</tr>

			<tr>
				<td><c:forEach var="cat" items="${catListe}">
						<tr>
							<td>${cat.nom}</td>
							<td>${cat.description}</td>
						</tr>
					</c:forEach>
		</table>
	</div>

	<div align="center">
	<form:form method="POST" action="soumettreCat" modelAttribute="cat">
		<form:select path="nom">
		<c:forEach var="cate" items="${catNomListe}">
			<option>${cate}</option>
		</c:forEach>
		</form:select>
		
		<button type="submit" class="btn btn-default">Rechercher</button>
		</form:form>
	</div>
	
		
	


</body>
</html>