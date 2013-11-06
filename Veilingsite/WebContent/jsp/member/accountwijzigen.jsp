<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="content">
	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage />
	</s:if>
	<h2>Account wijzigen</h2>
	<a href="<%=request.getContextPath()%>/jsp/member/wachtwoordwijzigen.jsp">Wachtwoord wijzigen</a>
	<s:form action="AccountWijzigen" namespace="/member">
		<s:iterator value="#session.gebruiker">
			<s:textfield name="voornaam" label="Voornaam" />
			<s:textfield name="tussenvoegsel" label="Tussenvoegsel" />
			<s:textfield name="achternaam" label="Achternaam" />
			<s:textfield name="adres" label="Adres" />
			<s:textfield name="postcode" label="Postcode" />
			<s:textfield name="plaats" label="Plaats" />
			<s:textfield name="email" label="E-mailadres" />
			<s:textfield name="telefoonnummerForm" label="Telefoonnummer" />
			<s:textfield name="rekeningnummer" label="Rekeningnummer" />
		</s:iterator>
		<s:submit value="Opslaan" />
	</s:form>
</div>
<%@ include file="../main/footer.jsp"%>