<%@ include file="../main/header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<div class="content">
				<h2>Registreren</h2>
				<s:form action="Register" namespace="/visitor">
		    	  <s:textfield name="voornaam" label="Naam"/>
		    	  <s:textfield name="tussenvoegsel" label="Tussenvoegsel"/>
		    	  <s:textfield name="achternaam" label="Achternaam"/>
		    	  <s:password name="password" label="Wachtwoord"/>
		    	  <s:password name="passwordCheck" label="Wachtwoord check"/>
		    	  <s:textfield name="email" label="E-mail"/>
		    	  <s:textfield name="adres" label="Adres"/>
		    	  <s:textfield name="postcode" label="Postcode"/>
		    	  <s:textfield name="plaats" label="Plaats"/>
		    	  <s:textfield name="telefoonnummer" label="Telefoonnummer"/>
		    	  <s:textfield name="rekeningnummer" label="Rekeningnummer"/>
		    	  <s:submit value="Register"/>
				</s:form>
			</div>
<%@ include file="../main/footer.jsp" %>