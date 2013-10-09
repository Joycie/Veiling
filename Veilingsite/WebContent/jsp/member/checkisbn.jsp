<%@ include file="../main/header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<div class="content">
				<h2>Registreren</h2>
				<s:form action="CheckIsbn" namespace="/member">
		    	  <s:textfield name="isbn" label="ISBN"/>
		    	  <s:submit value="Controleer Isbn"/>
				</s:form>
				<table>
				<tr class="thcolor">
					<th>Titel</th>
					<th>Auteur</th>
					<th>uitgeverij</th>
					<th>druk</th>
					<th>isbn</th>
				</tr>
				<s:iterator value="books">
					<tr class="tdcolor">
						<td><s:textfield name="titel" value="%{#Boek.titel}"/></td>
						<td><s:textfield name="auteur" value="%{#Boek.getAuteur}"/></td>
						<td><s:textfield name="uitgeverij" value="%{#books.uitgeverij}"/></td>
						<td><s:textfield name="druk" value="%{#boek.titel}"/></td>
						<td><s:textfield name="isbn" value="%{#book.titel}"/></td>
					</tr>
				</s:iterator>
				</table>
			</div>
<%@ include file="../main/footer.jsp" %>