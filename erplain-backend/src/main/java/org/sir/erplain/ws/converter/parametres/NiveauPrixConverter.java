package org.sir.erplain.ws.converter.parametres;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.ws.dto.parametres.NiveauPrixDto;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.contacts.FournisseurConverter;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationConverter;
import org.sir.erplain.ws.converter.ventes.commande.CommandeConverter;
import org.sir.erplain.ws.converter.ventes.facture.FactureConverter;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditConverter;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementConverter;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class NiveauPrixConverter {
@Autowired private FournisseurConverter fournisseurConverter;
@Autowired private RemboursementConverter remboursementConverter;
@Autowired private EstimationConverter estimationConverter;
@Autowired private CommandeConverter commandeConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private BonCommandeConverter bonCommandeConverter;
@Autowired private FactureConverter factureConverter;
@Autowired private NoteCreditConverter noteCreditConverter;
private boolean clients = true;
private boolean fournisseurs = true;
private boolean estimations = true;
private boolean commandes = true;
private boolean factures = true;
private boolean notesCredit = true;
private boolean remboursements = true;
private boolean bonCommandes = true;
protected void configure(boolean value) {
this.fournisseurConverter.setNiveauPrix(value);
this.remboursementConverter.setNiveauPrix(value);
this.estimationConverter.setNiveauPrix(value);
this.commandeConverter.setNiveauPrix(value);
this.clientConverter.setNiveauPrix(value);
this.bonCommandeConverter.setNiveauPrix(value);
this.factureConverter.setNiveauPrix(value);
this.noteCreditConverter.setNiveauPrix(value);
}
public final NiveauPrixDto toDto(NiveauPrix item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final NiveauPrix toItem(NiveauPrixDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<NiveauPrix> toItem(List<NiveauPrixDto> dtos) {
if (dtos == null) return null;
List<NiveauPrix> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<NiveauPrixDto> toDto(List<NiveauPrix> items) {
if (items == null) return null;
List<NiveauPrixDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected NiveauPrix convertToItem(NiveauPrixDto dto) {
var item = new NiveauPrix();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setType(dto.getType());
item.setActif(dto.isActif());
item.setClients(clientConverter.toItem(dto.getClients()));
item.setFournisseurs(fournisseurConverter.toItem(dto.getFournisseurs()));
item.setEstimations(estimationConverter.toItem(dto.getEstimations()));
item.setCommandes(commandeConverter.toItem(dto.getCommandes()));
item.setFactures(factureConverter.toItem(dto.getFactures()));
item.setNotesCredit(noteCreditConverter.toItem(dto.getNotesCredit()));
item.setRemboursements(remboursementConverter.toItem(dto.getRemboursements()));
item.setBonCommandes(bonCommandeConverter.toItem(dto.getBonCommandes()));
return item;
}
protected NiveauPrixDto convertToDto(NiveauPrix item) {
var dto = new NiveauPrixDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setType(item.getType());
dto.setActif(item.isActif());
dto.setClients(clients? clientConverter.toDto(item.getClients()): null);
dto.setFournisseurs(fournisseurs? fournisseurConverter.toDto(item.getFournisseurs()): null);
dto.setEstimations(estimations? estimationConverter.toDto(item.getEstimations()): null);
dto.setCommandes(commandes? commandeConverter.toDto(item.getCommandes()): null);
dto.setFactures(factures? factureConverter.toDto(item.getFactures()): null);
dto.setNotesCredit(notesCredit? noteCreditConverter.toDto(item.getNotesCredit()): null);
dto.setRemboursements(remboursements? remboursementConverter.toDto(item.getRemboursements()): null);
dto.setBonCommandes(bonCommandes? bonCommandeConverter.toDto(item.getBonCommandes()): null);
return dto;
}
public void setClients(boolean value) {
this.clients = value;
}
public void setFournisseurs(boolean value) {
this.fournisseurs = value;
}
public void setEstimations(boolean value) {
this.estimations = value;
}
public void setCommandes(boolean value) {
this.commandes = value;
}
public void setFactures(boolean value) {
this.factures = value;
}
public void setNotesCredit(boolean value) {
this.notesCredit = value;
}
public void setRemboursements(boolean value) {
this.remboursements = value;
}
public void setBonCommandes(boolean value) {
this.bonCommandes = value;
}
public void setFournisseurConverter(FournisseurConverter value) {
this.fournisseurConverter = value;
}
public FournisseurConverter getFournisseurConverter() {
return fournisseurConverter;
}
public void setRemboursementConverter(RemboursementConverter value) {
this.remboursementConverter = value;
}
public RemboursementConverter getRemboursementConverter() {
return remboursementConverter;
}
public void setEstimationConverter(EstimationConverter value) {
this.estimationConverter = value;
}
public EstimationConverter getEstimationConverter() {
return estimationConverter;
}
public void setCommandeConverter(CommandeConverter value) {
this.commandeConverter = value;
}
public CommandeConverter getCommandeConverter() {
return commandeConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setBonCommandeConverter(BonCommandeConverter value) {
this.bonCommandeConverter = value;
}
public BonCommandeConverter getBonCommandeConverter() {
return bonCommandeConverter;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
public void setNoteCreditConverter(NoteCreditConverter value) {
this.noteCreditConverter = value;
}
public NoteCreditConverter getNoteCreditConverter() {
return noteCreditConverter;
}
}