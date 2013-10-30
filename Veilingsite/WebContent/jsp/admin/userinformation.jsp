<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:if test="#session.gebruiker.rol == 1">
		Voornaam: <s:property value="Gebruiker.voornaam" />
		<br>
		<s:if test="Gebruiker.tussenvoegsel != null">
		Tussenvoegsel: <s:property value="Gebruiker.tussenvoegsel" />
			<br>
		</s:if>
		Achternaam: <s:property value="Gebruiker.achternaam" />
		<br>
		Adres: <s:property value="Gebruiker.adres" />
		<br>
		Postcode: <s:property value="Gebruiker.postcode" />
		<br>
		Plaats: <s:property value="Gebruiker.plaats" />
		<br>
		Email: <s:property value="Gebruiker.email" />
		<br>
		Telefoonnummer: <s:property value="Gebruiker.telefoonnummer" />
		<br>
		Rekeningnummer: <s:property value="Gebruiker.rekeningnummer" />
		<br>
		Krediet <s:property value="Gebruiker.krediet" />
		<br>
		Rol: <s:property value="Gebruiker.rol" />
		<br>
		<s:if test="Gebruiker.rol == 0 || Gebruiker.rol == 1">
			<a href="../admin/UserBlokkeren.action?klantnummer=<s:property value="klantnummer"/>">User
				blokkeren</a>
		</s:if>
		<s:if test="Gebruiker.rol == 2">
			<a href="../admin/UserDeblokkeren.action?klantnummer=<s:property value="klantnummer"/>">User
				Blokkering opheffen</a>
		</s:if>
	</s:if>
	<s:else>
	    	Geen toegang.
	    </s:else>
</div>
<%@ include file="../main/footer.jsp"%>
</body>
</html>