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
			<div class="options">
				<div>
					<s:if test="#session.gebruiker != null">
						<s:iterator value="#session.gebruiker">
						      Welkom 
						      <a
								href="<%=request.getContextPath()%>/member/AccountForm.action"><s:property
									value="voornaam" /> <s:property value="tussenvoegsel" /> <s:property
									value="achternaam" /></a>! 
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
				<li class="categorie"><a href="#">Boeken</a>
					<ul class="sub">
						<li><a href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=1">Literatuur</a></li>
						<li><a href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=2">Geschiedenis</a></li>
						<li><a href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=3">Toerisme</a></li>
						<li><a href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=4">Techniek</a></li>
						<li><a href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=5">Kookboeken</a></li>
						<li><a href="<%=request.getContextPath()%>/visitor/HuidigeVeilingen.action?categorie=6">Flora en fauna</a></li>
					</ul></li>
				<s:if test="#session.gebruiker != null">
					<li><a
						href="<%=request.getContextPath()%>/<s:url action='BoekToevoegenForm' namespace="member"/>">Boek
							toevoegen</a></li>
					<li><a
						href="<%=request.getContextPath()%>/<s:url action='HuidigeVeilingen' namespace="visitor"/>">Huidige
							veilingen</a></li>
					<li><a
						href="<%=request.getContextPath()%>/jsp/member/veilingtoevoegen.jsp">Veiling toevoegen</a></li>
				</s:if>
				<s:if test="#session.gebruiker.rol == 1">
					<li><a href="<%=request.getContextPath()%>/<s:url action='UserList' namespace="admin"/>">Userlist</a></li>
				</s:if>
			</ul>
			<div class="clear"></div>
		</div>