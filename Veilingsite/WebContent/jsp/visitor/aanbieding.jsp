<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:iterator value="aanbieding">
		<h2><s:property value="boek.titel" /></h2>
		<ul>
			<li>Boekgegevens
				<ul>
					<li><s:property value="boek.auteur" /></li>
					<li><s:property value="boek.isbn" /></li>
					<li><s:property value="boek.beschrijving" /></li>
				</ul>
			</li>
			<li>Aanbieding
				<ul>
					<li><s:property value="startprijs" /></li>
					<li><s:property value="eindtijd" /></li>
					<li><s:property value="eindtijd" /></li>
				</ul>
			</li>
			<li>Aanbieder
				<ul>
					<li><s:property value="gebruiker.naam" /></li>
				</ul>
			</li>
		</ul>
	</s:iterator>
</div>
<%@ include file="../main/footer.jsp"%>