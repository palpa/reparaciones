<html>
<head>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body>
	<div class="navbar ">
		<div class="row">
			<div class="col-lg-2">
				<div class="btn-group">
					<button type="button"
						class="btn btn-primary navbar-btn dropdown-toggle"
						data-toggle="dropdown">
						Clientes <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="add">Crear</a></li>
						<li><a href="./">Modificar</a></li>
						<li><a href="./">Eliminar</a></li>
						<li class="divider"></li>
						<li><a href="#">Otros</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<sitemesh:write property='body' />

</body>
</html>