<%@ include file="../main/header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<div class="content">
				<h2>Registreren</h2>
				<s:form action="CheckIsbn" namespace="/member">
		    	  <s:textfield name="isbn" label="ISBN"/>
		    	  <s:submit value="Controleer Isbn"/>
				</s:form>
			</div>
<%@ include file="../main/footer.jsp" %>