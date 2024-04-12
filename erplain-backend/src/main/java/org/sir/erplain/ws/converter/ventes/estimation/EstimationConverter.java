package org.sir.erplain.ws.converter.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationDto;
import org.sir.erplain.ws.converter.ventes.facture.FactureConverter;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EstimationConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private EstimationTaxeExpeditionConverter estimationTaxeExpeditionConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private EstimationTaxeConverter estimationTaxeConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private EstimationProduitConverter estimationProduitConverter;
@Autowired private FactureConverter factureConverter;
private boolean facture = true;
private boolean estimationTaxe = true;
private boolean estimationTaxeExpedition = true;
private boolean estimationProduit = true;
private boolean client = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setEstimation(value);
this.niveauPrixConverter.setEstimations(value);
this.estimationTaxeExpeditionConverter.setEstimation(value);
this.devisConverter.setEstimations(value);
this.estimationTaxeConverter.setEstimation(value);
this.clientConverter.setEstimations(value);
this.estimationProduitConverter.setEstimation(value);
}
public final EstimationDto toDto(Estimation item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Estimation toItem(EstimationDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Estimation> toItem(List<EstimationDto> dtos) {
if (dtos == null) return null;
List<Estimation> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EstimationDto> toDto(List<Estimation> items) {
if (items == null) return null;
List<EstimationDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Estimation convertToItem(EstimationDto dto) {
var item = new Estimation();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateExperation(dto.getDateExperation());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setRabais(dto.getRabais());
item.setTypeRabais(dto.getTypeRabais());
item.setRemiseGlobal(dto.getRemiseGlobal());
item.setTotalUnites(dto.getTotalUnites());
item.setSousTotal(dto.getSousTotal());
item.setTotal(dto.getTotal());
item.setStatut(dto.getStatut());
item.setFacture(factureConverter.toItem(dto.getFacture()));
item.setEstimationTaxe(estimationTaxeConverter.toItem(dto.getEstimationTaxe()));
item.setEstimationTaxeExpedition(estimationTaxeExpeditionConverter.toItem(dto.getEstimationTaxeExpedition()));
item.setEstimationProduit(estimationProduitConverter.toItem(dto.getEstimationProduit()));
item.setClient(clientConverter.toItem(dto.getClient()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected EstimationDto convertToDto(Estimation item) {
var dto = new EstimationDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateExperation(item.getDateExperation());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setRabais(item.getRabais());
dto.setTypeRabais(item.getTypeRabais());
dto.setRemiseGlobal(item.getRemiseGlobal());
dto.setTotalUnites(item.getTotalUnites());
dto.setSousTotal(item.getSousTotal());
dto.setTotal(item.getTotal());
dto.setStatut(item.getStatut());
dto.setFacture(facture? factureConverter.toDto(item.getFacture()): null);
dto.setEstimationTaxe(estimationTaxe? estimationTaxeConverter.toDto(item.getEstimationTaxe()): null);
dto.setEstimationTaxeExpedition(estimationTaxeExpedition? estimationTaxeExpeditionConverter.toDto(item.getEstimationTaxeExpedition()): null);
dto.setEstimationProduit(estimationProduit? estimationProduitConverter.toDto(item.getEstimationProduit()): null);
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setFacture(boolean value) {
this.facture = value;
}
public void setEstimationTaxe(boolean value) {
this.estimationTaxe = value;
}
public void setEstimationTaxeExpedition(boolean value) {
this.estimationTaxeExpedition = value;
}
public void setEstimationProduit(boolean value) {
this.estimationProduit = value;
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
public void setEstimationTaxeExpeditionConverter(EstimationTaxeExpeditionConverter value) {
this.estimationTaxeExpeditionConverter = value;
}
public EstimationTaxeExpeditionConverter getEstimationTaxeExpeditionConverter() {
return estimationTaxeExpeditionConverter;
}
public void setDevisConverter(DevisConverter value) {
this.devisConverter = value;
}
public DevisConverter getDevisConverter() {
return devisConverter;
}
public void setEstimationTaxeConverter(EstimationTaxeConverter value) {
this.estimationTaxeConverter = value;
}
public EstimationTaxeConverter getEstimationTaxeConverter() {
return estimationTaxeConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setEstimationProduitConverter(EstimationProduitConverter value) {
this.estimationProduitConverter = value;
}
public EstimationProduitConverter getEstimationProduitConverter() {
return estimationProduitConverter;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
}