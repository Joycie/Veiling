<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="content">
	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage />
	</s:if>
	<h2>Wachtwoord wijzigen</h2>
	<s:form action="WachtwoordWijzigen" namespace="/member">
		<s:iterator value="#session.gebruiker">
			<s:password name="oudwachtwoord" label="Oud wachtwoord" />
			<s:password name="nieuwwachtwoord" label="Nieuw wachtwoord" />
			<s:password name="checknieuwwachtwoord" label="Check Nieuw wachtwoord" />
		</s:iterator>
		<s:submit value="Opslaan" />
	</s:form>
</div>
<%@ include file="../main/footer.jsp"%>