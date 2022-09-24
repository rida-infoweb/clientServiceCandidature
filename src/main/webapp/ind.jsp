<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Candidature</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<% final String admis = (String) request.getAttribute("admis"); 
//out.println(admis);
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<h2 class="page-section-heading text-center text-uppercase">Vérification
				de l'admission</h2>
			<div class="row text-center">
				<div class="col-lg-10 ms-auto">
					<p class="lead">Cette application permet la vérification de
						l'admission de la candidature des bacheliers à l' UIT
				</div>
			</div>
		</div>
	</nav>

	<div class="d-flex justify-content-around mt-3">
		<form name="form" action="verificationCandidature" method="get">
			<div class="form-group">
				<label for="cin">CIN : </label> <input type="text"
					class="form-control" id="exampleInputEmail1" name="cin">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Numéro d'étudiant : </label> <input
					type="text" class="form-control" id="exampleInputEmail1" name="num">
			</div>
			<button type="submit" class="btn btn-primary">Vérifier</button>
		</form>
		<div class="card">
			<h5 class="card-header">Vérification</h5>
			<div class="card-body">
				<h5 class="card-title text-center">Résultat</h5>
				<%
				if (admis==null){
					
				%>
				<h1><span class="badge badge-secondary">
				Remplissez le formulaire
				</span></h1>
				<%
				}else {
				%>
				<h1><span class="badge badge-secondary">
				<%=admis %>
				</span></h1>
				<% } %>
				
			</div>
		</div>
	</div>



	<script src="static/js/bootstrap.bundle.min.js"></script>
</body>
</html>