<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<sitemesh:write property='head' />
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<img src="/reparaciones/resources/img/Icon1.png" class="img-rounded"
			height="50" width="50">
	</div>



	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">

		<ul class="navbar-nav">
			<div class="btn-group">
				<button type="button" class="btn btn-warning navbar-btn">Administracion</button>
				<button type="button"
					class="btn btn-warning dropdown-toggle navbar-btn"
					data-toggle="dropdown">
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">Administracion</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li>
				</ul>
			</div>
		</ul>

		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Clientes <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="/reparaciones/clients/add">Crear</a></li> 
					<li><a href="/reparaciones/clients/changeClients/1">Modificar</a></li>
					<li class="divider"></li>
					<li><a href="#">Otra acción</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Reparaciones <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li><a href="#">Separated link</a></li>
					<li><a href="#">One more separated link</a></li>
				</ul></li>
		</ul>
		
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Alquileres <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li><a href="#">Separated link</a></li>
					<li><a href="#">One more separated link</a></li>
				</ul></li>
		</ul>
		
		<!-- Logout -->
		<form class="navbar-form navbar-right" role="search">
			<button type="submit" class="btn btn-default ">
			 <span class="glyphicon glyphicon-off"></span>
			Logout.</button>
			
		
		</form>
		
	</div>
	<!-- /.navbar-collapse --> </nav>

	<sitemesh:write property='body' />
</body>
</html>