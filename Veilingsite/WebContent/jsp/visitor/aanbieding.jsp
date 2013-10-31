<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<s:iterator value="aanbieding">
<div class="block">
	<img src="http://www.buynothingnew.nl/wp-content/uploads/vintage-boeken.jpeg" />
	<div class="info">
		<p><s:property value="boek.auteur" /></p>
		<h3><s:property value="boek.titel" /></h3>
		<div class="action-block">
		<form>
			<input type="text" name="bid" placeholder="Bedrag"/><input type="submit" value="Bod plaatsen" />
		</form>
			<h4>Huidig bod</h4>
			<p>20,00</p>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div class="sidebar">
	<h4>Uitgeverij</h4>
	<p><s:property value="boek.uitgeverij" /></p>
	<h4>ISBN</h4>
	<p><s:property value="boek.isbn" /></p>
	<h4>Druk</h4>
	<p><s:property value="boek.druk" /></p>
	<h4>Taal</h4>
	<p><s:property value="boek.taal" /></p>
	<h4>Aantal pagina's</h4>
	<p><s:property value="boek.aantalpagina" /></p>
	<h4>Datum eerste uitgave</h4>
	<p><s:date name="boek.datum" format="dd-MMM-yyyy"/></p>
	<h4>Startprijs</h4>
	<p><s:property value="startprijs" /></p>
	<h4>Aanbieder</h4>
	<s:iterator value="gebruiker"><p><s:property value="voornaam" /> <s:property value="tussenvoegsel" /> <s:property value="achternaam" /> uit <s:property value="plaats" /></s:iterator></p>
	<h4>Geplaatst op</h4>
	<p><s:date name="datum" format="dd-MMM-yyyy 'om' HH:mm"/></p>
	<h4>Sluitingsdatum</h4>
	<p><s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm"/></p>
</div>
<div class="content">
	<h2>Beschrijving</h2>
	<p><s:property value="boek.beschrijving" /></p>
<div class="clear"></div>
	<s:iterator value="aanbieding">
		<h2>
			<s:property value="boek.titel" />
		</h2>
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

	<table>

		<tr class="thcolor">
			<th>Bieder naam</th>
			<th>Bod</th>
		</tr>
		<s:iterator value="veiling.biedingen">
			<tr class="tdcolor">
				<td><s:property value="gebruiker.naam" />
				<td><s:property value="gulden" />
			</tr>
		</s:iterator>
	</table>

	<s:form action="biedAction">
		<hr />
		<s:textfield name="guldens" label="Je bod:" />
		<s:hidden name="veilingId" value="%{veiling.id}" />
		<s:hidden name="id" value="%{account.id}" />
		<s:submit />
	</s:form>

>>>>>>> 271712486242e9085e5c24f115cf0a7b51ec302f
</div>
</s:iterator>
<%@ include file="../main/footer.jsp"%>