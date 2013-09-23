<%@ include file="../main/header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<div class="content">
				<h3>Inloggen</h3>
				<s:form action="Login">
		    	  <s:textfield name="username" label="Naam"/>
		    	  <s:password name="password" label="Wachtwoord"/>
		    	  <s:submit value="log in"/>
				</s:form>
			</div>
<%@ include file="../main/footer.jsp" %>