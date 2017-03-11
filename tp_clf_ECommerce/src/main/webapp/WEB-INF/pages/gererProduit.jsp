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

<div style="width: 700px; margin: auto; margin-top: 80px">


<h2 style="color:white" align="center">Liste des produits</h2>
<br/>
<table class="table table-hover" style="color: white" >
<tr>
<th>Id</th>
<th>Nom</th>
<th>Description</th>
<th>Quantite</th>
<th>Prix</th>
<th>Supp/Edit</th>
</tr>



<c:forEach var="prod" items="${prodListe}">
<tr>
<td>${cat.id}</td>
<td>${prod.designation}</td>
<td>${prod.description}</td>
<td>${prod.quantite}</td>
<td>${prod.prix}</td>
<td><a href="soumettreFormSupprimerProduit?nom_param=${prod.designation}">Supprimer</a> | <a href="afficherFormModifierProduit?prod_id_param=${prod.id}">Editer</a>
</tr>
</c:forEach>

</table>
</div>

</body>
</html>