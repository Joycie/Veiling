<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:iterator value="aanbieding">
		<h2>
			<s:property value="boek.titel" />
		</h2>
		<ul>
			<li>Boekgegevens
				<ul>
					<li><s:property value="boek.auteur" /></li>
					<li><s:property value="boek.isbn" /></li>
					<li><s:property value="boek.beschrijving" /></li>
				</ul>
			</li>
			<li>Aanbieding
				<ul>
					<li><s:property value="startprijs" /></li>
					<li><s:property value="eindtijd" /></li>
					<li><s:property value="eindtijd" /></li>
				</ul>
			</li>
			<li>Aanbieder
				<ul>
					<li><s:property value="gebruiker.naam" /></li>
				</ul>
			</li>
		</ul>

	</s:iterator>

	<table>

		<tr class="thcolor">
			<th>Bieder naam</th>
			<th>Bod</th>
		</tr>
		<s:iterator value="veiling.biedingen">
			<tr class="tdcolor">
				<td><s:property value="gebruiker.naam" />
				<td><s:property value="gulden" />
			</tr>
		</s:iterator>
	</table>

	<s:form action="biedAction">
		<hr />
		<s:textfield name="guldens" label="Je bod:" />
		<s:hidden name="veilingId" value="%{veiling.id}" />
		<s:hidden name="id" value="%{account.id}" />
		<s:submit />
	</s:form>

</div>
<%@ include file="../main/footer.jsp"%>