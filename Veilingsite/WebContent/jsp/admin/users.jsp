<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../main/header.jsp" %>
		<div class="content">
			<h2>Users</h2>
			<table>
		    <tr class="thcolor">
			    <th>Klant nummer </th>
			    <th>Voornaam</th>
			    <th>Tussenvoegsel</th>
			    <th>Achternaam</th>
		    </tr>
		    <s:iterator value="gebruikerslijst">
			    <tr class="tdcolor">
				    <td><s:property value="klantnummer" /></td>
					<td><s:property value="voornaam" /></td>
					<td><s:property value="tussenvoegsel" /></td>
		     		<td><s:property value="achternaam" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
		</div>
<%@ include file="../main/footer.jsp" %>
</body>
</html>