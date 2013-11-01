<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Multatuli</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="page">
		<!-- %=session.getAttribute("gebruiker")%> -->
		<div class="header">
			<ul class="options">
				<s:if test="#session.gebruiker != null">
					<s:iterator value="#session.gebruiker">
						<li><a
							href="<%=request.getContextPath()%>/member/AccountWijzigenForm.action"><s:property
									value="voornaam" /> <s:property value="tussenvoegsel" /> <s:property
									value="achternaam" /></a>
							<ul class="sub">
								<li><a
									href="<%=request.getContextPath()%>/member/MijnVeilingen.action">Mijn
										veilingen</a></li>
								<li><a
									href="<%=request.getContextPath()%>/member/AccountWijzigenForm.action">Account
										wijzigen</a></li>
								<li><a
									href="<%=request.getContextPath()%>/member/KredietOpwaarderenForm.action">Saldo
										wijzigen (<s:property value="krediet" />)
								</a></li>
								<s:if test="#session.gebruiker.rol == 1">
									<li><a
										href="<%=request.getContextPath()%>/admin/GetStatistieken.action">Statistieken</a></li>
								</s:if>
								<li><a
									href="<%=request.getContextPath()%>/member/Logout.action">Uitloggen</a>
								</li>
							</ul></li>
					</s:iterator>
				</s:if>
				<s:else>
					<li><a
						href="<%=request.getContextPath()%>/jsp/visitor/login.jsp">Inloggen</a>
					</li>
					<li><a
						href="<%=request.getContextPath()%>/jsp/visitor/register.jsp">Registreren</a>
					</li>
				</s:else>
				<li><s:form action="AanbiedingZoeken" namespace="/visitor">
						<s:textfield type="search" name="invoer" placeholder="Zoeken" />
						<input type="submit" style="position: absolute; left: -9999px" />
					</s:form></li>
			</ul>
			<a href="<%=request.getContextPath()%>">
				<h1>
					<img src="<%=request.getContextPath()%>/css/images/logo.jpg" />
					Multatuli Boekenveiling
				</h1>
			</a>
			<ul class="menu">
				<li><a href="<%=request.getContextPath()%>">Home</a></li>
				<li class="categorie"><a href="#">Boeken</a>
					<ul class="sub">
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=1">Literatuur</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=2">Geschiedenis</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=3">Toerisme</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=4">Techniek</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=5">Kookboeken</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=6">Flora
								en fauna</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=7">Kunst
								en cultuur</a></li>
						<li><a
							href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=8">Psychologie</a></li>
					</ul></li>
				<s:if test="#session.gebruiker != null">
					<li><a
						href="<%=request.getContextPath()%>/<s:url action='BoekToevoegenForm' namespace="member"/>">Boek
							toevoegen</a></li>
					<li><a
						href="<%=request.getContextPath()%>/<s:url action='HuidigeVeilingen' namespace="visitor"/>">Huidige
							veilingen</a></li>
					<li><a
						href="<%=request.getContextPath()%>/jsp/member/veilingtoevoegen.jsp">Veiling
							toevoegen</a></li>
				</s:if>
				<s:if test="#session.gebruiker.rol == 1">
					<li><a
						href="<%=request.getContextPath()%>/<s:url action='UserList' namespace="admin"/>">Userlist</a></li>
				</s:if>
			</ul>
			<div class="clear"></div>
		</div>