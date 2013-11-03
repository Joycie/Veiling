<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<h2>Mijn aanbiedingen</h2>
	<table>
		<s:if test="%{mijnveilingen.isEmpty()}">
			<tr class="thcolor">
			</tr>
			<tr class="tdcolor">
				<td>U heeft geen aanbiedingen op dit moment.</td>
				<td><a
					href="<%=request.getContextPath()%>/jsp/member/veilingtoevoegen.jsp">Nieuwe
						veiling toevoegen</a></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</s:if>
		<s:else>
			<tr class="thcolor">
				<th>Titel</th>
				<th>Auteur</th>
				<th>Druk</th>
				<th>Prijs</th>
				<th>Eindtijd</th>
				<th>Recent</th>
				<th></th>
			</tr>
			<s:iterator value="mijnveilingen">
				<tr class="tdcolor">
					<td><a
						href="<%=request.getContextPath()%>/visitor/GetAanbieding.action?id=<s:property value="id" />"><s:property
								value="boek.titel" /></a></td>
					<td><s:property value="boek.auteur" /></td>
					<td><s:property value="drukken_nummer" /></td>
					<td><s:if test="bod.bedrag > startprijs">
							<b><s:property value="bod.bedrag" /> (Bod)</b>
						</s:if> <s:else>
							<s:property value="startprijs" />
							(Start)
						</s:else></td>
					<td><s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm" /></td>
					<s:if test="insert_date > sysdate">
					<th><img src="<%=request.getContextPath()%>/css/images/is_recent.png" height="16px" width="16px"></th>
					</s:if>
					<s:else>
					<th><img src="<%=request.getContextPath()%>/css/images/is_nietrecent.png" height="16px" width="16px" ></th>
					</s:else>
					<td><a
						href="../member/VeilingVerwijderen.action?id=<s:property value="id"/>">verwijderen</a></td>
				</tr>
			</s:iterator>
		</s:else>
	</table>
</div>
<%@ include file="../main/footer.jsp"%>