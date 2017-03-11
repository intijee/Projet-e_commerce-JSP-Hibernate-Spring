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
	<h1 style="color: fuchsia;">Article du panier</h1>
	<div align="right"><a href="supprimerPanier?param=${produit.designation}">Vider le panier</a></div>
	<table class="table table-hover" style="color: white">
			<tr>
				<th>Designation</th>
				<th>Description</th>
				<th>Quantite</th>
				<th>Prix</th>
				
			</tr>

			<tr>
				<td><c:forEach var="produit" items="${prodListeSelection}">
						<tr>
							<td>${produit.designation}</td>
							<td>${produit.description}</td>
							<td>${produit.quantite}</td>
							<td>${produit.prix}</td>
						</tr>
					</c:forEach>
		</table>
		
		<a href="enregistrerClient">Enregistrer la commande</a>





</body>
</html>