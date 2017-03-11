<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Super Admin</title>
<script type="text/javascript" src='<c:url value="/resources/bootstrap.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/jquery-3.1.1.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/resources/bootstrap.css"/>'/>
</head>
<body background='<c:url value="/resources/fonecran.jpg"/>'>

<%@include file="/resources/include/menuAdminProd.html"%>

<div style="width: 400px;height: 500px;margin: auto; margin-top: 50px">
	<form:form method="POST" action="soumettreFormAjouterProduit" modelAttribute="ajouterFormProduit">
		<!-- commandName ou modelAttribute -->
		<table>
		
			<tr>
				<td><form:label path="designation" cssStyle="color:white">Nom</form:label></td>
				<td><form:input path="designation" /></td>
			</tr>
			
			<tr><td><br/><br/></td></tr>
			
			<tr>
				<td><form:label path="description" cssStyle="color:white">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>

			<tr><td><br/><br/></td></tr>
			
				<tr>
				<td><form:label path="prix" cssStyle="color:white">Prix</form:label></td>
				<td><form:input path="prix" /></td>
			</tr>
			
			<tr><td><br/><br/></td></tr>
			
			<tr>
				<td><form:label path="quantite" cssStyle="color:white">Quantite</form:label></td>
				<td><form:input path="quantite" /></td>
			</tr>
			
				<tr><td><br/><br/></td></tr>
			
				<tr>
				<td><form:label path="nomCat" cssStyle="color:white">Categorie</form:label></td>
					<td><form:select path="nomCat">
					<c:forEach var="cat" items="${listeCat}">
							<option>${cat.nom}</option>
							</c:forEach>
					</form:select></td>
				</tr>

			<tr><td><br/><br/></td></tr>
			
			<tr>
			<td colspan="2">
			<input type="submit" value="Ajouter" style="margin-left: 120px">
			</td>
			</tr>
			
		</table>
		
	</form:form>

</div>
</body>
</html>