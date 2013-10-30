<%@ include file="../main/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="content">
	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage />
	</s:if>
	<s:iterator value="aanbieding">
	<h2><s:property name="boek.titel"/></h2>
	<ul>
		<li>Auteur: <s:property name="boek.auteur"/></li>
		<li>Startprijs: <s:property name="startprijs"/></li>
	</ul>
	</s:iterator>
</div>
<%@ include file="../main/footer.jsp"%>