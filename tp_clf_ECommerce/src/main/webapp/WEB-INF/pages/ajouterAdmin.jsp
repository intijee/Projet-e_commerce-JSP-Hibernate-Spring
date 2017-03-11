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

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreFormAjouterAdmin"
			modelAttribute="ajouterFormAdmin">
			<!-- commandName ou modelAttribute -->
			<table>

				<tr>
					<td><form:label path="mail" cssStyle="color:white">Mail</form:label></td>
					<td><form:input path="mail" /></td>
				</tr>

				<tr>
					<td><br />
					<br /></td>
				</tr>

				<tr>
					<td><form:label path="password" cssStyle="color:white">Password</form:label></td>
					<td><form:input path="password" /></td>
				</tr>
				
				<tr>
					<td><br />
					<br /></td>
				</tr>

				<tr style="margin-left: 120px">
					<td><form:select path="nomRole">
							<option>ROLE_ADMIN_CAT</option>
							<option>ROLE_ADMIN_PROD</option>
					</form:select></td>
				</tr>

				<tr>
					<td><br />
					<br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Ajouter"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>
</body>
</html>