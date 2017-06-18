<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="it">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Galleria De' Galli</title>

	<style>
		body {
    		background-color: black;
		}
	</style>

</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<a class="navbar-brand" href=#> Galleria De' Galli</a>
		</div>

		<ul class="nav navbar-nav">
			<li class="active"><a href='#'>Home</a></li>
			<security:authorize access="hasRole('RUOLO_AMMINISTRATORE)">
				<li><a href=' #'>Utenti</a></li>
			</security:authorize>
			
			<security:authorize access="isAuthenticated()">
				<li><a href="<spring:url value="/account"/>">account</a></li>
				<li><a href=' #'>Artisti</a></li>
				<li><a href=' #'>Opere</a></li>
			</security:authorize>
			
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="<spring:url value="/registratore-utente"/>"><span class="glyphicon glyphicon-user"></span> Registrati </a></li>
		
			
			<security:authorize access="/ isAuthenticated()">
				<li><a href="<spring:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Accedi </a></li>
			</security:authorize>
			
			<security:authorize access="isAuthenticated()">
				<li><a href="<spring:url value="/logout"/>"> <span class="glyphicon glyphicon-log-out"></span> Esci </a></li>
			</security:authorize>
			
		</ul>
	</nav>

	<nav class="nav navbar-inverse navbar-fixed-bottom">
		<p class="navbar-text">Powered by Davide Farioli & Mattias Axel Ricci</p>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center">Benvenuto all'interno della galleria</h1>

		</div>
	</div>

	<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="5000">

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="/resources/tempio.jpg" alt="Quadro_1">
			</div>

			<div class="item">
				<img src="/resources/ship.jpg" alt="Quadro_2">
			</div>

			<div class="item">
				<img src="/resources/sea.jpg" alt="Quadro_3">
			</div>
		</div>

		
	</div>


</body>
</html>