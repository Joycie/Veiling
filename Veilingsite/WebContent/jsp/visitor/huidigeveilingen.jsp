<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Alle aanbiedingen</h2>
	<table>
		<tr class="thcolor">
			<th>Titel</th>
			<th>Auteur</th>
			<th>Druk</th>
			<th>Prijs</th>
			<th>Eindtijd</th>
			<th>Recent</th>
		</tr>
		<s:if test="%{veilingen.isEmpty()}">
			<tr class="tdcolor">
				<td>Er zijn geen aanbiedingen op dit moment.</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="veilingen">
				<tr class="tdcolor">
					<td><a href="<%=request.getContextPath()%>/visitor/GetAanbieding.action?id=<s:property value="id" />"><s:property value="boek.titel" /></a></td>
					<td><s:property value="boek.auteur" /></td>
					<td><s:property value="drukken_nummer" /></td>
					<td>
						<s:if test="bod.bedrag > startprijs">
							<b>ƒ <s:property value="bod.bedrag" />
							(Bod)</b>
						</s:if>
						<s:else>
							ƒ <s:property value="startprijs" />
							(Start)
						</s:else>
					</td>
					<td><s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm" /></td>
					<s:if test="insert_date > sysdate">
					<th><img src="<%=request.getContextPath()%>/css/images/is_recent.png" height="16px" width="16px"></th>
					</s:if>
					<s:else>
					<th><img src="<%=request.getContextPath()%>/css/images/is_nietrecent.png" height="16px" width="16px" ></th>
					</s:else>
				</tr>
			</s:iterator>
		</s:else>
	</table>
</div>
<%@ include file="../main/footer.jsp"%>