<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Recent aangemaakte veilingen</h2>
	<table>
		<tr class="thcolor">
			<th>Titel</th>
			<th>Auteur</th>
			<th>Druk</th>
			<th>Startprijs</th>
			<th>Eindtijd</th>
		</tr>
		<s:iterator value="recenteveilingen">
			<tr class="tdcolor">
				<td><s:property value="boek.titel" /></td>
				<td><s:property value="boek.auteur" /></td>
				<td><s:property value="drukken_nummer" /></td>
				<td><s:property value="startprijs" /></td>
				<td><s:property value="eindtijd" /></td>
			</tr>
		</s:iterator>
	</table>
	<h2>Alle aanbiedingen</h2>
	<table>
		<tr class="thcolor">
			<th>Titel</th>
			<th>Auteur</th>
			<th>Druk</th>
			<th>Startprijs</th>
			<th>Eindtijd</th>
		</tr>
		<s:iterator value="veilingen">
			<tr class="tdcolor">
				<td><s:property value="boek.titel" /></td>
				<td><s:property value="boek.auteur" /></td>
				<td><s:property value="drukken_nummer" /></td>
				<td><s:property value="startprijs" /></td>
				<td><s:property value="eindtijd" /></td>
			</tr>
		</s:iterator>
	</table>
</div>
<%@ include file="../main/footer.jsp"%>