<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="../layout/taglib.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Artista</title>
</head>
<body>

	<h1>${artista.nome}</h1>
	
	<c:forEach items="${artista.opere}" var="opera">
		
		<h3> ${opera.nome}</h3>
		
	</c:forEach>
	

</body>
</html>