<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Super Admin</title>
<script type="text/javascript"
	src='<c:url value="/resources/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/jquery-3.1.1.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/resources/bootstrap.css"/>' />
</head>
<body background='<c:url value="/resources/fonecran.jpg"/>'>

	<%@include file="/resources/include/menuAdminCat.html"%>
<h1 style="color: fuchsia;">Coordonnées du client</h1>
	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreClient"
			modelAttribute="client">
			<!-- commandName ou modelAttribute -->
			<table>

				<tr>
					<td><form:label path="nomClient" cssStyle="color:white">Nom</form:label></td>
					<td><form:input path="nomClient" /></td>
				</tr>

				<tr>
					<td></td>
				</tr>

				<tr>
					<td><form:label path="prenomClient" cssStyle="color:white">Prénom</form:label></td>
					<td><form:input path="prenomClient" /></td>
				</tr>

				<tr>
					<td></td>
				</tr>
				<tr>
					<td><form:label path="mail" cssStyle="color:white">Mail</form:label></td>
					<td><form:input path="mail" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><form:label path="adresse" cssStyle="color:white">Adresse</form:label></td>
					<td><form:input path="adresse" /></td>
				</tr>
				<tr>
				<td></td>
				</tr>
				<tr>
					<td><form:label path="tel" cssStyle="color:white">Téléphone</form:label></td>
					<td><form:input path="tel" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Enregistrer"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>
</body>
</html>