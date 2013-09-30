<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>Multatuli
		</title>
		<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="page">
<%=session.getAttribute("gebruiker")%>
<div class="header">
				<div class="options">
					<div><a href="<%=request.getContextPath()%>/jsp/visitor/login.jsp">Inloggen</a>
					<a href="<%=request.getContextPath()%>/jsp/visitor/register.jsp">Registreren</a>
					</div>
					<form>
						<input type="search" placeholder="Zoeken" />
					</form>
				</div>
				<a href="<%=request.getContextPath()%>">
					<h1><img src="<%=request.getContextPath()%>/css/images/logo.jpg"/> Multatuli Boekenveiling</h1>
				</a>
				<ul class="menu">
				<li><a href="<%=request.getContextPath()%>">Home</a></li>
				<li><a href="#">Literatuur</a></li>
				<li><a href="#">Geschiedenis</a></li>
				<li><a href="#">Toerisme</a></li>
				<li><a href="#">Techniek</a></li>
				<li><a href="#">Kookboeken</a></li>
				<li><a href="#">Flora en fauna</a></li>
				<li><a href="#">Kunst en cultuur</a></li>
				 <li><a href="<%=request.getContextPath()%>/<s:url action='HuidigeVeilingen' namespace="member"/>">Huidige veilingen</a></li>
				</ul>
				<div class="clear">
				</div>
			</div>