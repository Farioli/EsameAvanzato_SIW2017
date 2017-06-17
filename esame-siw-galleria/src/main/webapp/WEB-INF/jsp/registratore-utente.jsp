<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="../layout/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form comandName="utente" cssClass="form-horizzontal">
		<div class="form-group">
			<label for="nome" class="col-sm-2 control-label">Nome:</label>
				<div class="col-sm-10">
					<form:input path="nome" cssClass="form-control" />
					<form:errors path="nome" />
				</div>
		</div>
		
		<div class="form-group">
			<label for="cognome" class="col-sm-2 control-label">Cognome:</label>
				<div class="col-sm-10">
					<form:input path="cognome" cssClass="form-control" />
					<form:errors path="cognome" />
				</div>
		</div>
		
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email:</label>
				<div class="col-sm-10">
					<form:input path="email" cssClass="form-control" />
					<form:errors path="email" />
				</div>
		</div>
		
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-10">
					<form:input path="password" cssClass="form-control" />
					<form:errors path="password" />
				</div>
		</div>
		
		
		<div class="form-group">
			<div class="col-sm-2">
				<input type="submit" value="Salva" class="btn btn-lg btn-primary" />
			</div>
		</div>
			
			
		
		
	
	</form:form>

</body>
</html> 