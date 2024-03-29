<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:if test="#session.gebruiker.rol == 1">

	<div class="block">
	<img src="<%=request.getContextPath()%>/css/images/statistics.png" height="200px" width="300px" >
		<div class="action-block">
		<h2>Algemene statistieken</h2>
		<p>Aantal gebruikers: <a href="<%=request.getContextPath()%>/admin/UserList.action"><s:property value="Statistiek.aantalgebruikers" /></a></p>
		<p>Totaal Aantal aanbiedingen: <s:property value="Statistiek.totaalaantalaanbiedingen" /></p>
		<p>Aantal lopende aanbiedingen: <a href="<%=request.getContextPath()%>/Menu.action"><s:property value="Statistiek.aantallopendeaanbiedingen" /></a></p>
		<p>Aantal boeken: <s:property value="Statistiek.aantalboeken" /></p>
		<br>
		<br>
		<br>
		<hr>
		
		<img src="<%=request.getContextPath()%>/css/images/pig.png" height="200px" width="300px" >
		<h2>Financiële statistieken</h2>
		Hoogste bod:
		<p>Vandaag: fl. <s:property value="Statistiek.hoogstebod_dag" />
		<p>Week: fl. <s:property value="Statistiek.hoogstebod_week" /></p>
		<p>Maand: fl. <s:property value="Statistiek.hoogstebod_maand" /></p>
		<p>Jaar: fl. <s:property value="Statistiek.hoogstebod_jaar" /></p>

		Hoogste krediet in het systeem: fl. <s:property value="Statistiek.hoogstekrediet" /><br>
		Totale omzet: fl. <s:property value="Statistiek.totaleomzet" /><br>
		<hr>
		</div>
		</div>
	<table>
		<tr class="thcolor">
			<th>ID</th>
			<th>Aanbieder</th>
			<th>Titel</th>
			<th>Biedingen</th>
		</tr>
		<h2>Aanbiedingen met de meeste biedingen</h2>
		<s:iterator value="biedingenStatistieken">
			<tr class="tdcolor">
				<td><a href="<%=request.getContextPath()%>/visitor/GetAanbieding.action?id=<s:property value="id" />"><s:property value="id" /></a></td>
				<td><s:property value="voornaam" /> <s:property value="tussenvoegsel" /> <s:property value="achternaam" /></td>
				<td><s:property value="titel" /></td>
				<td><s:property value="biedingen" /></td>
			</tr>
		</s:iterator>
	</table>
	<h2>Opbrengst in een bepaalde periode</h2>
	<s:form action="GetStatistieken">
			<s:textfield name="van" label="Van"/>
			<s:textfield name="tot" label="Tot"/>
			<s:submit value="Opvragen" />
			<s:textfield name="opbrengst" label="Opbrengst" disabled="true"/>
	</s:form>
	</s:if>
	<s:else>
	    	Geen toegang.
	    </s:else>
</div>
<%@ include file="../main/footer.jsp"%>
</body>
</html>