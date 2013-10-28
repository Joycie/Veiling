<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="hasActionErrors()">
	<s:actionerror />
</s:if>
<s:if test="hasActionMessages()">
	<s:actionmessage />
</s:if>
<div class="content">
	<h2>Account wijzigen</h2>
	<s:form action="Account" namespace="/member">
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