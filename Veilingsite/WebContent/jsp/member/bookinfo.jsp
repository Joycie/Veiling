<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>
		Boek
		</h2>
			<table>
				<tr class="thcolor">
					<th>Titel</th>
					<th>Auteur</th>
					<th>uitgeverij</th>
					<th>druk</th>
					<th>isbn</th>
				</tr>
				<s:iterator value="books">
					<tr class="tdcolor">
						<td><s:property value="titel" /></td>
						<td><s:property value="auteur" /></td>
						<td><s:property value="uitgeverij" /></td>
						<td><s:property value="druk" /></td>
						<td><s:property value="isbn" /></td>
					</tr>
				</s:iterator>
			</table>
</div>
<%@ include file="../main/footer.jsp"%>