<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="hasActionErrors()">
	<s:actionerror />
</s:if>
<s:if test="hasActionMessages()">
	<s:actionmessage />
</s:if>
<div class="content">
	<h2>Veiling Wijzigen</h2>
	<s:iterator value="aanbieding">
		<s:form action="VeilingWijzigen" namespace="/member"
			enctype="multipart/form-data">
			<s:hidden name="id" label="ID"/>
			<s:textfield name="startprijs" label="Startprijs" />
			<s:file name="img" label="Selecteer foto" />
			<s:textfield name="eindtijd" label="Eindtijd"/>
			<s:submit value="Wijzig Veiling" />
		</s:form>
	</s:iterator>
</div>
<%@ include file="../main/footer.jsp"%>