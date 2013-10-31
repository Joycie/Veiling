<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:if test="#session.gebruiker.rol == 1">
		Aantal gebruikers: <s:property value="Statistiek.aantalgebruikers" /><br>
		Totaal Aantal aanbiedingen: <s:property value="Statistiek.totaalaantalaanbiedingen" /><br>
		Aantal lopende aanbiedingen: <s:property value="Statistiek.aantallopendeaanbiedingen" /><br>
		Aantal boeken: <s:property value="Statistiek.aantalboeken" /><br>
		Hoogste bod:
		<ul>
		<li> Vandaag: <s:property value="Statistiek.hoogstebod_dag" /></li>
		<li> Week: <s:property value="Statistiek.hoogstebod_week" /></li>
		<li> Maand: <s:property value="Statistiek.hoogstebod_maand" /></li>
		<li> Jaar: <s:property value="Statistiek.hoogstebod_jaar" /></li>
		</ul> 
		Hoogste krediet in het systeem: <s:property value="Statistiek.hoogstekrediet" /><br>
		Totale omzet: <s:property value="Statistiek.totaleomzet" /><br>
	</s:if>
	<s:else>
	    	Geen toegang.
	    </s:else>
</div>
<%@ include file="../main/footer.jsp"%>
</body>
</html>