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
			<s:textfield name="id" label="ID"/>
			<s:textfield name="startprijs" label="Startprijs" />
			Eindtijd:
			<select name="dagen" id="dagen">
				<option value=1>1 dag</option>
				<option value=2>2 dagen</option>
				<option value=4>4 dagen</option>
				<option value=6>6 dagen</option>
				<option value=7>1 week</option>
			</select>
			<s:file name="image" label="Selecteer foto" />
			
			<s:textfield name="<s:property value="eindtijd" />" label="Eindtijd"/>
			<s:submit value="Wijzig Veiling" />
		</s:form>
	</s:iterator>
</div>
<%@ include file="../main/footer.jsp"%>