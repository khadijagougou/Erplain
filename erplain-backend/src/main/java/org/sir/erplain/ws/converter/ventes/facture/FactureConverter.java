package org.sir.erplain.ws.converter.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import org.sir.erplain.ws.converter.ventes.PaiementConverter;
import org.sir.erplain.ws.converter.ventes.retourproduit.RetourProduitConverter;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class FactureConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private PaiementConverter paiementConverter;
@Autowired private FactureTaxeConverter factureTaxeConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private RetourProduitConverter retourProduitConverter;
@Autowired private FactureTaxeExpeditionConverter factureTaxeExpeditionConverter;
@Autowired private FactureProduitConverter factureProduitConverter;
@Autowired private ClientConverter clientConverter;
private boolean paiement = true;
private boolean retourProduit = true;
private boolean factureTaxe = true;
private boolean factureTaxeExpedition = true;
private boolean factureProduit = true;
private boolean client = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setFacture(value);
this.niveauPrixConverter.setFactures(value);
this.factureTaxeConverter.setFacture(value);
this.devisConverter.setFactures(value);
this.retourProduitConverter.setFacture(value);
this.factureTaxeExpeditionConverter.setFacture(value);
this.factureProduitConverter.setFacture(value);
this.clientConverter.setFactures(value);
}
public final FactureDto toDto(Facture item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Facture toItem(FactureDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Facture> toItem(List<FactureDto> dtos) {
if (dtos == null) return null;
List<Facture> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<FactureDto> toDto(List<Facture> items) {
if (items == null) return null;
List<FactureDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Facture convertToItem(FactureDto dto) {
var item = new Facture();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateExperation(dto.getDateExperation());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setRabais(dto.getRabais());
item.setTypeRabais(dto.getTypeRabais());
item.setTotalUnites(dto.getTotalUnites());
item.setRemiseGlobal(dto.getRemiseGlobal());
item.setSousTotal(dto.getSousTotal());
item.setTotal(dto.getTotal());
item.setStatut(dto.getStatut());
item.setPaiement(paiementConverter.toItem(dto.getPaiement()));
item.setRetourProduit(retourProduitConverter.toItem(dto.getRetourProduit()));
item.setFactureTaxe(factureTaxeConverter.toItem(dto.getFactureTaxe()));
item.setFactureTaxeExpedition(factureTaxeExpeditionConverter.toItem(dto.getFactureTaxeExpedition()));
item.setFactureProduit(factureProduitConverter.toItem(dto.getFactureProduit()));
item.setClient(clientConverter.toItem(dto.getClient()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected FactureDto convertToDto(Facture item) {
var dto = new FactureDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateExperation(item.getDateExperation());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setRabais(item.getRabais());
dto.setTypeRabais(item.getTypeRabais());
dto.setTotalUnites(item.getTotalUnites());
dto.setRemiseGlobal(item.getRemiseGlobal());
dto.setSousTotal(item.getSousTotal());
dto.setTotal(item.getTotal());
dto.setStatut(item.getStatut());
dto.setPaiement(paiement? paiementConverter.toDto(item.getPaiement()): null);
dto.setRetourProduit(retourProduit? retourProduitConverter.toDto(item.getRetourProduit()): null);
dto.setFactureTaxe(factureTaxe? factureTaxeConverter.toDto(item.getFactureTaxe()): null);
dto.setFactureTaxeExpedition(factureTaxeExpedition? factureTaxeExpeditionConverter.toDto(item.getFactureTaxeExpedition()): null);
dto.setFactureProduit(factureProduit? factureProduitConverter.toDto(item.getFactureProduit()): null);
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setPaiement(boolean value) {
this.paiement = value;
}
public void setRetourProduit(boolean value) {
this.retourProduit = value;
}
public void setFactureTaxe(boolean value) {
this.factureTaxe = value;
}
public void setFactureTaxeExpedition(boolean value) {
this.factureTaxeExpedition = value;
}
public void setFactureProduit(boolean value) {
this.factureProduit = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setDevis(boolean value) {
this.devis = value;
}
public void setNiveauPrix(boolean value) {
this.niveauPrix = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setNiveauPrixConverter(NiveauPrixConverter value) {
this.niveauPrixConverter = value;
}
public NiveauPrixConverter getNiveauPrixConverter() {
return niveauPrixConverter;
}
public void setPaiementConverter(PaiementConverter value) {
this.paiementConverter = value;
}
public PaiementConverter getPaiementConverter() {
return paiementConverter;
}
public void setFactureTaxeConverter(FactureTaxeConverter value) {
this.factureTaxeConverter = value;
}
public FactureTaxeConverter getFactureTaxeConverter() {
return factureTaxeConverter;
}
public void setDevisConverter(DevisConverter value) {
this.devisConverter = value;
}
public DevisConverter getDevisConverter() {
return devisConverter;
}
public void setRetourProduitConverter(RetourProduitConverter value) {
this.retourProduitConverter = value;
}
public RetourProduitConverter getRetourProduitConverter() {
return retourProduitConverter;
}
public void setFactureTaxeExpeditionConverter(FactureTaxeExpeditionConverter value) {
this.factureTaxeExpeditionConverter = value;
}
public FactureTaxeExpeditionConverter getFactureTaxeExpeditionConverter() {
return factureTaxeExpeditionConverter;
}
public void setFactureProduitConverter(FactureProduitConverter value) {
this.factureProduitConverter = value;
}
public FactureProduitConverter getFactureProduitConverter() {
return factureProduitConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
}