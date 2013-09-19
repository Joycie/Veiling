<%@ include file="main/header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<div class="content">
				<h3>Registreren</h3>
				<s:form action="Register">
		    	  <s:textfield name="voornaam" label="Naam"/>
		    	  <s:textfield name="tussenvoegsel" label="Tussenvoegsel"/>
		    	  <s:textfield name="achternaam" label="Achternaam"/>
		    	  <s:password name="password" label="Wachtwoord"/>
		    	  <s:password name="passwordCheck" label="Wachtwoord check"/>
		    	  <s:password name="email" label="E-mail"/>
		    	  <s:password name="adress" label="Adress"/>
		    	  <s:password name="postcode" label="Postcode"/>
		    	  <s:password name="plaats" label="Plaats"/>
		    	  <s:password name="rekeningnummer" label="rekeningnummer"/>
		    	  <s:password name="telefoonnummer" label="Telefoonnummer"/>
		    	  <s:submit value="Register"/>
				</s:form>
			</div>
<%@ include file="main/footer.jsp" %>