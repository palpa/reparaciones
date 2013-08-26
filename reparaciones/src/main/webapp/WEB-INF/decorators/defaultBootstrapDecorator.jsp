<!DOCTYPE html>
<html>
<head>
<title><sitemesh:write property='title' /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="resources/js/html5shiv.js"></script>
	<script src="resources/js/respond.min.js"></script>
<![endif]-->
		
<sitemesh:write property='head' />
</head>
<body>

	<sitemesh:write property='body' />

	<!-- JavaScript plugins (requires jQuery) -->
	<script src="resources/js/jquery-1.10.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>