<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
	<html lang="it">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Lista degli Artisti</title>
		</head>
		
		<body>
					<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Nome Artista</th>
						
						<security:authorize access="hasRole('RUOLO_AMMINISTRATORE)">
						<th>Operazioni</th>
						</security:authorize>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${artisti}" var="artista">
						<tr>
						
						
							<td>	
								<a href="<spring:url value="/artisti/${artisti.id}.html" />"> <c:out value="${artista.name}" /> </a>
							</td>
							
							<security:authorize access="hasRole('RUOLO_AMMINISTRATORE)">
							<td>
								<a href="<spring:url value="/artista/rimuovi/${artista.id}.html" />" class="btn btn-danger triggerRemove"> remove </a>
							</td>
							</security:authorize>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</body>
</html>