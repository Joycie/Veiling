<html>
	<head>
		<title>Multatuli - Inloggen
		</title>
		<link href="../css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="page">
			<div class="header">
				<div class="options">
					<div><a href="../jsp/login.jsp">Inloggen</a>
					</div>
					<form>
						<input type="search" placeholder="Zoeken" />
					</form>
				</div>
				<h1><img src="../css/images/logo.jpg"/> Multatuli Boekenveiling</h1>
				<ul class="menu">
					<li class="selected"><a href="#">Home</a></li>
					<li><a href="#">Literatuur</a></li>
					<li><a href="#">Naslagwerken</a></li>
					<li><a href="#">Kookboeken</a></li>
					<li><a href="#">Kunst en cultuur</a></li>
				</ul>
				<div class="clear">
				</div>
			</div>
			<div class="content">
				<h2>Inloggen</h2>
				<form action="/Veilingsite/Inloggen.do" method="post">
				<p>
				<input class="form_input" type="text" name="email" id="email" placeholder="Email-adres..." > <br>
				<input class="form_input" type="text" name="wachtwoord" id="wachtwoord" placeholder="Wachtwoord..."></p>
				<input type="submit" value="Inloggen" name="inloggen" />
				</form>
				</div>
			<div class="footer">
				<div class="options">Onderdeel <i>van De Doorgezakte Boekenplank</i>
				</div>&copy; Multatuli Boekenveiling 2013
			</div>
		</div>
	</body>
</html>