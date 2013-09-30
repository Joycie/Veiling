<%@ include file="../main/header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<div class="content">
				<h2>Inloggen</h2>
				<s:form action="Login" namespace="/visitor">
		    	  <s:textfield name="email" label="Email"/>
		    	  <s:password name="pass" label="Wachtwoord"/>
		    	  <s:submit value="log in"/>
				</s:form>
			</div>
<%@ include file="../main/footer.jsp" %>