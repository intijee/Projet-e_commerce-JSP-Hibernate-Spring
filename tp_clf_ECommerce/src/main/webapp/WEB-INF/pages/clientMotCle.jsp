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
	<h1 style="color: fuchsia;">Chercher un produit à l'aide d'un mot
		clé</h1>

	<form:form method="POST" action="soumettreMotCle" modelAttribute="produitMotCle">
			Mot clé : 
			<form:input path="designation" />

		<button type="submit" class="btn btn-default">Rechercher</button>
	</form:form>




</body>
</html>