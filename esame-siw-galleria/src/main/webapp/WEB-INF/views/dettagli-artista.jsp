<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="../layout/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli ${artista.nome}</title>
</head>
<body>

	<h1>${artista.nome}</h1>
	
	<security:authorize access="hasRole('RUOLO_AMMINISTRATORE)">
		<a href="<spring:url value="artista/rimuovi/${artista.id}.html" />" class="btn btn-danger" > Rimuovi </a>
	</security:authorize>
	
	<h3> Opere dell'artista</h3>
	<c:forEach items="${artista.opere}" var="opera">
		
		<a href="<spring:url value="opera/${opera.id}" /> " > ${opera.nome} </a>
		
	</c:forEach>
	

</body>
</html>