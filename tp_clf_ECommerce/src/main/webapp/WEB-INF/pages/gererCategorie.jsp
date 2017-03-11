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

<%@include file="/resources/include/menuAdminCat.html"%>

<div style="width: 700px; margin: auto; margin-top: 80px">
Liste des Categories

<table align="center" >
<tr>
<th>Id</th>
<th>Nom</th>
<th>Description</th>
<th>Supp/Edit</th>
</tr>

<tr>
<td>
<c:forEach var="cat" items="${catListe}">
<tr>
<td>${cat.id}</td>
<td>${cat.nom}</td>
<td>${cat.description}</td>
<td><a href="soumettreFormSupprimerCategorie?nom_param=${cat.nom}">Supprimer</a> | <a href="afficherFormModifierCategorie?cat_id_param=${cat.id}">Editer</a>
</tr>
</c:forEach>
</td>
</tr>
</table>
</div>

</body>
</html>