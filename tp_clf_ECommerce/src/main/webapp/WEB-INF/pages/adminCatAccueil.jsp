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

</body>
</html>