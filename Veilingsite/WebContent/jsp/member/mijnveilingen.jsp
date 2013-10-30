<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Mijn aanbiedingen</h2>
	<table>
		<tr class="thcolor">
			<th>Titel</th>
			<th>Auteur</th>
			<th>Druk</th>
			<th>Startprijs</th>
			<th>Eindtijd</th>
		</tr>
		<s:if test="%{veilingen.isEmpty()}">
			<tr class="tdcolor">
				<td>U heeft geen aanbiedingen op dit moment.</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="mijnveilingen">
				<tr class="tdcolor">
					<td><s:property value="boek.titel" /></td>
					<td><s:property value="boek.auteur" /></td>
					<td><s:property value="drukken_nummer" /></td>
					<td><s:property value="startprijs" /></td>
					<td><s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm" /></td>
				</tr>
			</s:iterator>
		</s:else>
	</table>
</div>
<%@ include file="../main/footer.jsp"%>