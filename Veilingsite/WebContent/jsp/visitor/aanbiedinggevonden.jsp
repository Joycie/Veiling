<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:if test="%{gezochteveilingen.isEmpty()}">
Er zijn geen aanbiedingen gevonden op de volgende zoekterm: "<s:property
			value="invoer" />"
		<br>
Probeer een andere zoekterm:
		<s:form action="AanbiedingZoeken" namespace="/visitor">
			<s:textfield type="search" name="invoer" />
			<input type="submit" style="position: absolute; right: -9999px" />
		</s:form>
	</s:if>
	<s:else>
		<h2>Gevonden aanbiedingen</h2>
		<table>
			<tr class="thcolor">
				<th>Titel</th>
				<th>Auteur</th>
				<th>Druk</th>
				<th>Startprijs</th>
				<th>Eindtijd</th>
				<th>Recent</th>
			</tr>
			<s:iterator value="gezochteveilingen">
				<tr class="tdcolor">
					<td><a
						href="<%=request.getContextPath()%>/visitor/GetAanbieding.action?id=<s:property value="id" />"><s:property
								value="boek.titel" /></a></td>
					<td><s:property value="boek.auteur" /></td>
					<td><s:property value="drukken_nummer" /></td>
					<td><s:property value="startprijs" /></td>
					<td><s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm" /></td>
					<s:if test="insert_date > sysdate">
						<th><img
							src="<%=request.getContextPath()%>/css/images/is_recent.png"
							height="16px" width="16px"></th>
					</s:if>
					<s:else>
						<th><img
							src="<%=request.getContextPath()%>/css/images/is_nietrecent.png"
							height="16px" width="16px"></th>
					</s:else>
				</tr>
			</s:iterator>
		</table>
	</s:else>
</div>
<%@ include file="../main/footer.jsp"%>