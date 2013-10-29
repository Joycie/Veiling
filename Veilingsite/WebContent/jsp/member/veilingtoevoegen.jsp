<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="hasActionErrors()">
	<s:actionerror />
</s:if>
<s:if test="hasActionMessages()">
	<s:actionmessage />
</s:if>
<div class="content">
	<h2>Veiling Toevoegen</h2>
	<s:form action="VeilingToevoegen" namespace="/member">
		<s:textfield name="startprijs" label="Startprijs" />
			Eindtijd:
			<select name="dagen" id="dagen">
				<option value= 1 >1 dag</option>
  				<option value= 2 >2 dagen</option>
  				<option value= 4 >4 dagen</option>
  				<option value= 6 >6 dagen</option>
  				<option value= 7 >1 week</option>
			</select>
		<s:textfield name="isbn" label="Isbn" />
		<s:textfield name="druk" label="Druk" />
		<s:submit value="Voeg Toe" />
	</s:form>
</div>
<%@ include file="../main/footer.jsp"%>