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
</div>
</s:iterator>
<%@ include file="../main/footer.jsp"%>