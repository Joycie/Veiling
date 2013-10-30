<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="content">
	<META HTTP-EQUIV="Refresh" CONTENT="5;URL=Menu.action">
	U bent succesvol geregistreerd. U ontvangt nu een mail op
	<s:property value="Gebruiker.email"></s:property>
	<br> <i>U wordt nu doorgestuurd naar de homepage</i> <br><a
		href="<%=request.getContextPath()%>">Klik hier als u
		binnen 5 seconde niet wordt doorgestuurd.</a>
</div>
<%@ include file="../main/footer.jsp"%>