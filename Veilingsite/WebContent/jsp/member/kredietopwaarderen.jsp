<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Krediet opwaarderen</h2>

	Huiding saldo: fl. 
	<s:iterator value="#session.gebruiker">
		<s:property value="krediet" />
	</s:iterator>
	
	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>
	<s:form action="KredietOpwaarderen" namespace="/member">
		<s:textfield name="saldo" label="Bedrag" />
		<s:submit value="Waardeer op" />
	</s:form>

</div>
<%@ include file="../main/footer.jsp"%>
