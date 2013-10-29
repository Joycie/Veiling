<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Krediet opwaarderen</h2>
	
	<table>
		<s:iterator value="huidigSaldo">
			<tr class="tdcolor">
				<td><s:property value="gebruiker.krediet" /></td>

			</tr>
		</s:iterator>
	</table>
	
	<s:form action="KredietOpwaarderen" namespace="/member">
		<s:textfield name="saldo" label="Bedrag" />
		<s:submit value="Waardeer op" />
	</s:form>
	
	</div>
<%@ include file="../main/footer.jsp"%>
