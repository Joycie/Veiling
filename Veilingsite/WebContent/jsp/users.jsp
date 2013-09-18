<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Multatuli Boekenveiling</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="page">
		<div class="header">
			<div class="options">
				<div>
					<a href="jsp/login.jsp">Inloggen/Registreren</a>
				</div>
				<form>
					<input type="search" placeholder="Zoeken" />
				</form>
			</div>
			<h1>
				<img src="../css/images/logo.jpg" /> Multatuli Boekenveiling
			</h1>
			<ul class="menu">
				<li class="selected"><a href="#">Home</a></li>
				<li><a href="#">Literatuur</a></li>
				<li><a href="#">Geschiedenis</a></li>
				<li><a href="#">Toerisme</a></li>
				<li><a href="#">Techniek</a></li>
				<li><a href="#">Kookboeken</a></li>
				<li><a href="#">Flora en fauna</a></li>
				<li><a href="#">Kunst en cultuur</a></li>
				<li><a href="#">Naslagwerken</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="content">
			<h2>Users:</h2>
			<table>
		    <tr class="thcolor">
			    <th>Klant nummer</th>
			    <th>Voornaam</th>
			    <th>Achternaam</th>
		    </tr>
		    <s:iterator value="books">
			    <tr class="tdcolor">
				    <td><s:property value="klantnr" /></td>
					<td><s:property value="voornaam" /></td>
		     		<td><s:property value="achternaam" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
		</div>
		<div class="footer">
			<div class="options">
				Onderdeel <i>van De Doorgezakte Boekenplank</i>
			</div>
			&copy; Multatuli Boekenveiling 2013
		</div>
	</div>
</body>
</html>