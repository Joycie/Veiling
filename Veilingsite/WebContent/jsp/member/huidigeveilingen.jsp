<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Huidige aanbiedingen<h2>
	<table class="veilingtable">
		<tr class="thcolor">
			<th>Titel</th>
			<th>Auteur</th>
			<th>Startprijs</th>
			<th>Eindtijd</th>
		</tr>
		<s:iterator value="boeken">
			<tr class="tdcolor">
				<td><s:property value="titel" /></td>
				<td><s:property value="auteur" /></td>
		</s:iterator>
		<s:iterator value="veilingen">
				<td><s:property value="startprijs" /></td>
				<td><s:property value="eindtijd" /></td>
			</tr>
		</s:iterator>
	</table>
</div>
<%@ include file="../main/footer.jsp"%>