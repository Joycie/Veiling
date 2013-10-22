<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Welkom - Multatuli</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Refresh" CONTENT="0.5;URL=Menu.action">
</head>
<body>
	<div class="page">
		<!-- %=session.getAttribute("gebruiker")%> -->
		<div class="header">
			<div class="options">
				<div>
					<s:if test="#session.gebruiker != null">
						<s:iterator value="#session.gebruiker">
						      Welkom <s:property value="voornaam" />
							<s:property value="tussenvoegsel" />
							<s:property value="achternaam" />! 
						       <a
								href="<%=request.getContextPath()%>/member/Logout.action">Uitloggen</a>
						</s:iterator>
					</s:if>
					<s:else>
						<a href="<%=request.getContextPath()%>/jsp/visitor/login.jsp">Inloggen</a>
						<a href="<%=request.getContextPath()%>/jsp/visitor/register.jsp">Registreren</a>
					</s:else>
				</div>
				<form>
					<input type="search" placeholder="Zoeken" />
				</form>
			</div>
			<a href="<%=request.getContextPath()%>">
				<h1>
					<img src="<%=request.getContextPath()%>/css/images/logo.jpg" />
					Multatuli Boekenveiling
				</h1>
			</a>
			<ul class="menu">
				<li><a href="<%=request.getContextPath()%>">Home</a></li>
				<li><a href="#">Literatuur</a></li>
				<li><a href="#">Geschiedenis</a></li>
				<li><a href="#">Toerisme</a></li>
				<li><a href="#">Techniek</a></li>
				<li><a href="#">Kookboeken</a></li>
				<li><a href="#">Flora en fauna</a></li>
				<li><a
					href="<%=request.getContextPath()%>/<s:url action='BoekToevoegenForm' namespace="member"/>">Boek
						toevoegen</a></li>
				<li><a
					href="<%=request.getContextPath()%>/<s:url action='HuidigeVeilingen' namespace="visitor"/>">Huidige
						veilingen</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="content">
			<span class="cursief">Veilingen laden...</span>
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

</body>
</html>