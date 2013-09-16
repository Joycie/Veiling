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
					<div><a href="../jsp/login.jsp">Inloggen/Registreren</a>
					</div>
					<form>
						<input type="search" placeholder="Zoeken" />
					</form>
				</div>
				<h1><img src="../css/images/logo.jpg"/> Multatuli Boekenveiling</h1>
				<ul class="menu">
				<li><a href="../index.jsp">Home</a></li>
				<li><a href="#">Literatuur</a></li>
				<li><a href="#">Geschiedenis</a></li>
				<li><a href="#">Toerisme</a></li>
				<li><a href="#">Techniek</a></li>
				<li><a href="#">Kookboeken</a></li>
				<li><a href="#">Flora en fauna</a></li>
				<li><a href="#">Kunst en cultuur</a></li>
				<li><a href="#">Naslagwerken</a></li>
				</ul>
				<div class="clear">
				</div>
			</div>
			<div class="content">
				<h3>Inloggen</h3>
				<form action="/Veilingsite/Inloggen.do" method="post">
				<input class="form_input" type="text" name="email" id="email" placeholder="Email-adres..." > <br>
				<input class="form_input" type="password" name="wachtwoord" id="wachtwoord" placeholder="Wachtwoord...">
				<br><input type="submit" value="Inloggen" name="inloggen" />
				<hr>
				</form>
				<h3>Nog geen account? Registreren</h3>
				<form action="/Veilingsite/Inloggen.do" method="post">
				<input class="form_input" type="text" name="voornaam" id="voornaam" placeholder="Voornaam..." > <span class="verplicht">*</span><br>
				<input class="form_input" type="text" name="tussenvoegsel" id="tussenvoegsel" placeholder="Tussenvoegsel..." > <br>
				<input class="form_input" type="text" name="achternaam" id="achternaam" placeholder="Achternaam..." > <span class="verplicht">*</span><br>
				<input class="form_input" type="text" name="adres" id="adres" placeholder="Straat + huisnummer..." > <span class="verplicht">*</span><br>
				<input class="form_input" type="text" name="postcode" id="postcode" placeholder="Postcode" > <span class="verplicht">*</span><br>
				<input class="form_input" type="text" name="plaats" id="plaats" placeholder="Plaats..."> <span class="verplicht">*</span><br>
				<input class="form_input" type="text" name="email" id="email" placeholder="Email..." > <span class="verplicht">*</span><br>
				<input class="form_input" type="password" name="wachtwoord" id="wachtwoord" placeholder="Wachtwoord..."> <span class="verplicht">*</span>
				<input class="form_input" type="password" name="wachtwoordher" id="wachtwoordher" placeholder="Wachtwoord herhalen..."> <span class="verplicht">*</span><br>
				<input class="form_input" type="text" name="telefoonnummer" id="telefoonnummer" placeholder="Telefoonnummer..." > <br>
				<input class="form_input" type="text" name="rekeningnummer" id="rekeningnummer" placeholder="Rekeningnummer..." > <br>
				<span class="verplicht">* = verplicht.</span>
				<br><input type="submit" value="Registreren" name="registreren" />
				</form>
			</div>
			<div class="footer">
				<div class="options">Onderdeel <i>van De Doorgezakte Boekenplank</i>
				</div>&copy; Multatuli Boekenveiling 2013
			</div>
		</div>
	</body>
</html>