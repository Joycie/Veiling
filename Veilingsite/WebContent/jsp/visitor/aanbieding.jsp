<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<s:iterator value="aanbieding">
	<div class="block">
		<s:if test="hasActionErrors()">
			<s:actionerror/>
		</s:if>
		<s:if test="hasActionMessages()">
			<s:actionmessage />
		</s:if>
		<img
			src="http://www.buynothingnew.nl/wp-content/uploads/vintage-boeken.jpeg" />
		<div class="info">
			<p>
				<s:property value="boek.auteur" />
			</p>
			<h3>
				<s:property value="boek.titel" />
			</h3>
			<div class="action-block">
				<s:if test="#session.gebruiker.klantnummer == gebruiker.klantnummer">
					<form>Je kunt niet op je eigen aanbieding bieden.</form>
				</s:if>
				<s:elseif test="#session.gebruiker==null">
					<form>
						Je moet <a
							href="<%=request.getContextPath()%>/jsp/visitor/login.jsp">inloggen</a>
						om te bieden.
					</form>
				</s:elseif>
				<s:else>
					<s:form action="biedAction" namespace="/member" theme="simple">
						<s:textfield name="guldens" label="" placeholder="bedrag" />
						<s:hidden name="id" />
						<s:submit value="Bieden" />
					</s:form>
				</s:else>

				<s:if test="bod.bedrag > startprijs">
					<h4>Huidig bod</h4>
					<p>
						fl.
						<s:property value="bod.bedrag" />
					</p>
				</s:if>
				<s:else>
					<h4>Startprijs</h4>
					<p>
						fl.
						<s:property value="startprijs" />
					</p>
				</s:else>

			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="sidebar">
		<s:if test="#session.gebruiker.rol == 1">
			<p>
				<a class="button"
					href="<%=request.getContextPath()%>/admin/AanbiedingWijzigenForm.action?id=<s:property value="id" />">Wijzigen</a>
				<a class="button"
					href="<%=request.getContextPath()%>/member/VeilingVerwijderen.action?id=<s:property value="id" />">Verwijderen</a>
			</p>
		</s:if>
		<h4>Uitgeverij</h4>
		<p>
			<s:property value="boek.uitgeverij" />
		</p>
		<h4>ISBN</h4>
		<p>
			<s:property value="boek.isbn" />
		</p>
		<h4>Druk</h4>
		<p>
			<s:property value="boek.druk" />
		</p>
		<h4>Taal</h4>
		<p>
			<s:property value="boek.taal" />
		</p>
		<h4>Aantal pagina's</h4>
		<p>
			<s:property value="boek.aantalpagina" />
		</p>
		<h4>Datum eerste uitgave</h4>
		<p>
			<s:date name="boek.datum" format="dd-MMM-yyyy" />
		</p>
		<h4>Startprijs</h4>
		<p>
			<s:property value="startprijs" />
		</p>
		<h4>Aanbieder</h4>
		<s:iterator value="gebruiker">
			<p>
				<s:property value="voornaam" />
				<s:property value="tussenvoegsel" />
				<s:property value="achternaam" />
				uit
				<s:property value="plaats" />
		</s:iterator>
		</p>
		<h4>Geplaatst op</h4>
		<p>
			<s:date name="insert_date" format="dd-MMM-yyyy 'om' HH:mm" />
		</p>
		<h4>Sluitingsdatum</h4>
		<p>
			<s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm" />
		</p>
	</div>
	<div class="content">
		<h2>Beschrijving</h2>
		<p>
			<s:property value="boek.beschrijving" />
		</p>
		<h2>Biedingen</h2>
		<s:if test="%{biedingen.isEmpty()}">
			Er zijn nog geen biedingen.
		</s:if>
		<s:else>
			<div class="content-object">
				<table>
					<tr class="thcolor">
						<th>Bieder</th>
						<th>Bod</th>
						<th>Datum</th>
					</tr>
					<s:iterator value="biedingen">
						<tr class="tdcolor">
							<td><s:property value="bieder.voornaam" /></td>
							<td><s:property value="bedrag" /></td>
							<td><s:date name="datumTijd" format="dd-MMM-yyyy 'om' HH:mm" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</s:else>
		<div class="clear"></div>
	</div>
</s:iterator>
<%@ include file="../main/footer.jsp"%>