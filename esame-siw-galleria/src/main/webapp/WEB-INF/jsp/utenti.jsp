<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista degli utenti registrati</title>
</head>
<body>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Nome Utente</th>
				<th>Operazioni</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${utenti}" var="utente">
				<tr>
					<td><a href="<spring:url value="/utenti/${utente.id}.html" />">
							<c:out value="${utente.name}" />
					</a></td>
					<td><a
						href="<spring:url value="/utenti/remove/${utente.id}.html" />"
						class="btn btn-danger triggerRemove"> remove </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>