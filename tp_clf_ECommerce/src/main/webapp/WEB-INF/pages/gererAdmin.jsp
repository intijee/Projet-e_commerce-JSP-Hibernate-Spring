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
<h2 style="color:white" align="center">Liste des Admins</h2>




<table class="table table-hover" style="color: white" >
<tr>
<th>Id</th>
<th>Nom</th>
<th>Role</th>
<th>Supp/Edit</th>
</tr>

<tr>
<td>
<c:forEach var="ad" items="${adminListe}">
<tr>
<td>${ad.id}</td>
<td>${ad.mail}</td>
<td>${ad.pRole.designation}</td>
<td><a href="soumettreFormSupprimerAdmin?mail_param=${ad.mail}">Supprimer</a>
</tr>
</c:forEach>
</td>
</tr>
</table>
</div>
</body>
</html>