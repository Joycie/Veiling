<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="content">
	<h2>Registreren</h2>
	<s:form action="CheckIsbn" namespace="/member">
		<s:textfield name="isbn" label="ISBN" />
		<s:submit value="Controleer Isbn" />
	</s:form>
	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage />
	</s:if>

	<s:form action="BoekToevoegen" namespace="/member">
		<s:iterator value="books">
			<tr class="tdcolor">
				<s:textfield name="isbn" label="Isbn" />
				<s:textfield name="titel" label="Titel" />
				<s:textfield name="beschrijving" label="Beschrijving" />
				<s:textfield name="druk" label="Druk" />
				<s:textfield name="uitgeverij" label="Uitgeverij" />
				<s:textfield name="auteur" label="Auteur" />
				<s:textfield name="taal" label="Taal" />
				<s:textfield name="aantalpagina" label="Aantal Pagina's" />
				<s:textfield name="datum" label="Datum" />
			</tr>
		</s:iterator>
		<s:submit value="Voeg Toe" />
	</s:form>
</div>
<%@ include file="../main/footer.jsp"%>