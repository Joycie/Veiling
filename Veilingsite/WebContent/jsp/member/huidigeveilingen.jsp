<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../main/header.jsp" %>
		<div class="content">
		Huidige aanbiedingen:
		<table>
		    <tr class="thcolor">
			    <th>ISBN</th>
			    <th>Titel</th>
			    <th>Auteur</th>
		    </tr>
		    <s:iterator value="veilingen">
			    <tr class="tdcolor">
				    <td><s:property value="isbn" /></td>
					<td><s:property value="titel" /></td>
					<td><s:property value="auteur" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
		
		</div>
<%@ include file="../main/footer.jsp" %>