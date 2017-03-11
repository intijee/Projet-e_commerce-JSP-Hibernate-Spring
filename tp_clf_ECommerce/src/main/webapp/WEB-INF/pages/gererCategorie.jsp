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
<h2 style="color:white" align="center">Liste des categories</h2>
<br/>

<table class="table table-hover" style="color: white" >
<tr>
<th>Id</th>
<th>Nom</th>
<th>Description</th>
<th>Supp/Edit</th>
</tr>


<c:forEach var="cat" items="${catListe}">
<tr>
<td>${cat.id}</td>
<td>${cat.nom}</td>
<td>${cat.description}</td>
<td><a href="soumettreFormSupprimerCategorie?nom_param=${cat.nom}">Supprimer</a> | <a href="afficherFormModifierCategorie?cat_id_param=${cat.id}">Editer</a>
</tr>
</c:forEach>

</table>
</div>

</body>
</html>