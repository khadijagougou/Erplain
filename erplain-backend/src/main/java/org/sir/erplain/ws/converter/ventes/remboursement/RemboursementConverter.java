package org.sir.erplain.ws.converter.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.ventes.retourproduit.RetourProduitConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class RemboursementConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private RetourProduitConverter retourProduitConverter;
@Autowired private RemboursementProduitConverter remboursementProduitConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private RemboursementTaxeConverter remboursementTaxeConverter;
private boolean remboursementTaxe = true;
private boolean remboursementProduit = true;
private boolean client = true;
private boolean retourProduit = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setRemboursement(value);
this.niveauPrixConverter.setRemboursements(value);
this.devisConverter.setRemboursements(value);
this.retourProduitConverter.setRemboursements(value);
this.remboursementProduitConverter.setRemboursement(value);
this.clientConverter.setRemboursements(value);
this.remboursementTaxeConverter.setRemboursement(value);
}
public final RemboursementDto toDto(Remboursement item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Remboursement toItem(RemboursementDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Remboursement> toItem(List<RemboursementDto> dtos) {
if (dtos == null) return null;
List<Remboursement> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<RemboursementDto> toDto(List<Remboursement> items) {
if (items == null) return null;
List<RemboursementDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Remboursement convertToItem(RemboursementDto dto) {
var item = new Remboursement();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setTotalUnites(dto.getTotalUnites());
item.setRemiseGlobal(dto.getRemiseGlobal());
item.setSousTotal(dto.getSousTotal());
item.setTotal(dto.getTotal());
item.setStatut(dto.getStatut());
item.setRemboursementTaxe(remboursementTaxeConverter.toItem(dto.getRemboursementTaxe()));
item.setRemboursementProduit(remboursementProduitConverter.toItem(dto.getRemboursementProduit()));
item.setClient(clientConverter.toItem(dto.getClient()));
item.setRetourProduit(retourProduitConverter.toItem(dto.getRetourProduit()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected RemboursementDto convertToDto(Remboursement item) {
var dto = new RemboursementDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setTotalUnites(item.getTotalUnites());
dto.setRemiseGlobal(item.getRemiseGlobal());
dto.setSousTotal(item.getSousTotal());
dto.setTotal(item.getTotal());
dto.setStatut(item.getStatut());
dto.setRemboursementTaxe(remboursementTaxe? remboursementTaxeConverter.toDto(item.getRemboursementTaxe()): null);
dto.setRemboursementProduit(remboursementProduit? remboursementProduitConverter.toDto(item.getRemboursementProduit()): null);
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setRetourProduit(retourProduit? retourProduitConverter.toDto(item.getRetourProduit()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setRemboursementTaxe(boolean value) {
this.remboursementTaxe = value;
}
public void setRemboursementProduit(boolean value) {
this.remboursementProduit = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setRetourProduit(boolean value) {
this.retourProduit = value;
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
public void setRemboursementProduitConverter(RemboursementProduitConverter value) {
this.remboursementProduitConverter = value;
}
public RemboursementProduitConverter getRemboursementProduitConverter() {
return remboursementProduitConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setRemboursementTaxeConverter(RemboursementTaxeConverter value) {
this.remboursementTaxeConverter = value;
}
public RemboursementTaxeConverter getRemboursementTaxeConverter() {
return remboursementTaxeConverter;
}
}