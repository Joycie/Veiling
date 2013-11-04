<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../main/header.jsp"%>
<div class="content">
	<s:if test="#session.gebruiker.rol == 1">
		Voornaam: <s:property value="Gebruiker.voornaam" />
		<br>
		<s:if test="Gebruiker.tussenvoegsel != null">
		Tussenvoegsel: <s:property value="Gebruiker.tussenvoegsel" />
			<br>
		</s:if>
		Achternaam: <s:property value="Gebruiker.achternaam" />
		<br>
		Adres: <s:property value="Gebruiker.adres" />
		<br>
		Postcode: <s:property value="Gebruiker.postcode" />
		<br>
		Plaats: <s:property value="Gebruiker.plaats" />
		<br>
		Email: <s:property value="Gebruiker.email" />
		<br>
		Telefoonnummer: <s:property value="Gebruiker.telefoonnummer" />
		<br>
		Rekeningnummer: <s:property value="Gebruiker.rekeningnummer" />
		<br>
		Krediet <s:property value="Gebruiker.krediet" />
		<br>
		Rol: <s:property value="Gebruiker.rol" />
		<br>
		<s:if test="hasActionErrors()">
			<s:actionerror />
		</s:if>
		<s:if test="hasActionMessages()">
			<s:actionmessage />
		</s:if>
		<br>
		<s:if
			test="Gebruiker.rol == 0 && Gebruiker.klantnummer != 11 && #session.gebruiker.klantnummer != Gebruiker.klantnummer">
			<a class="button"
				href="../admin/UserBlokkeren.action?klantnummer=<s:property value="klantnummer"/>">User
				blokkeren</a>
		</s:if>
		<s:if
			test="Gebruiker.rol == 2 && #session.gebruiker.klantnummer != Gebruiker.klantnummer">
			<a class="button"
				href="../admin/UserDeblokkeren.action?klantnummer=<s:property value="klantnummer"/>">User
				Blokkering opheffen</a>
		</s:if>
		<s:if
			test="Gebruiker.rol == 0 && #session.gebruiker.klantnummer != Gebruiker.klantnummer">
			<a class="button"
				href="../admin/MaakAdmin.action?klantnummer=<s:property value="klantnummer"/>">Geef
				administrator rechten</a>
		</s:if>
		<s:if
			test="Gebruiker.rol == 1 && Gebruiker.klantnummer != 11 && #session.gebruiker.klantnummer != Gebruiker.klantnummer">
			<a class="button"
				href="../admin/OntneemAdmin.action?klantnummer=<s:property value="klantnummer"/>">Neem
				administrator rechten in</a>
		</s:if>
		<hr>
		<s:if test="%{aanbiedingen.isEmpty()}">
		Deze gebruiker heeft geen aanbiedingen
		</s:if>
		<s:else>
		Aanbiedingen van deze gebruiker:
		<table>
				<tr class="thcolor">
					<th>Titel</th>
					<th>Auteur</th>
					<th>Druk</th>
					<th>Prijs</th>
					<th>Eindtijd</th>
					<th>Recent</th>
				</tr>
				<s:iterator value="aanbiedingen">
					<tr class="tdcolor">
						<td><a
							href="<%=request.getContextPath()%>/visitor/GetAanbieding.action?id=<s:property value="id" />"><s:property
									value="boek.titel" /></a></td>
						<td><s:property value="boek.auteur" /></td>
						<td><s:property value="drukken_nummer" /></td>
						<td><s:if test="bod.bedrag > startprijs">
								<b>ƒ <s:property value="bod.bedrag" /> (Bod)
								</b>
							</s:if> <s:else>
							ƒ <s:property value="startprijs" />
							(Start)
						</s:else></td>
						<td><s:date name="eindtijd" format="dd-MMM-yyyy 'om' HH:mm" /></td>
						<s:if test="insert_date > sysdate">
							<th><img
								src="<%=request.getContextPath()%>/css/images/is_recent.png"
								height="16px" width="16px"></th>
						</s:if>
						<s:else>
							<th><img
								src="<%=request.getContextPath()%>/css/images/is_nietrecent.png"
								height="16px" width="16px"></th>
						</s:else>
					</tr>
				</s:iterator>
			</table>
		</s:else>
	</s:if>
	<s:else>
	    	Geen toegang.
	    </s:else>
</div>
<%@ include file="../main/footer.jsp"%>
</body>
</html>