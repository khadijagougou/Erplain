package org.sir.erplain.ws.converter.parametres;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.ws.dto.parametres.DevisDto;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
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
public class DevisConverter {
@Autowired private RemboursementConverter remboursementConverter;
@Autowired private NouvelleDeviseConverter nouvelleDeviseConverter;
@Autowired private EstimationConverter estimationConverter;
@Autowired private CommandeConverter commandeConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private BonCommandeConverter bonCommandeConverter;
@Autowired private FactureConverter factureConverter;
@Autowired private NoteCreditConverter noteCreditConverter;
private boolean clients = true;
private boolean estimations = true;
private boolean commandes = true;
private boolean factures = true;
private boolean notesCredit = true;
private boolean remboursements = true;
private boolean bonCommandes = true;
private boolean nouvelleDevise = true;
protected void configure(boolean value) {
this.remboursementConverter.setDevis(value);
this.estimationConverter.setDevis(value);
this.commandeConverter.setDevis(value);
this.clientConverter.setDevis(value);
this.bonCommandeConverter.setDevis(value);
this.factureConverter.setDevis(value);
this.noteCreditConverter.setDevis(value);
}
public final DevisDto toDto(Devis item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Devis toItem(DevisDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Devis> toItem(List<DevisDto> dtos) {
if (dtos == null) return null;
List<Devis> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<DevisDto> toDto(List<Devis> items) {
if (items == null) return null;
List<DevisDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Devis convertToItem(DevisDto dto) {
var item = new Devis();
item.setId(dto.getId());
item.setClients(clientConverter.toItem(dto.getClients()));
item.setEstimations(estimationConverter.toItem(dto.getEstimations()));
item.setCommandes(commandeConverter.toItem(dto.getCommandes()));
item.setFactures(factureConverter.toItem(dto.getFactures()));
item.setNotesCredit(noteCreditConverter.toItem(dto.getNotesCredit()));
item.setRemboursements(remboursementConverter.toItem(dto.getRemboursements()));
item.setBonCommandes(bonCommandeConverter.toItem(dto.getBonCommandes()));
item.setNouvelleDevise(nouvelleDeviseConverter.toItem(dto.getNouvelleDevise()));
item.setTauxDeChange(dto.getTauxDeChange());
item.setDefaut(dto.isDefaut());
return item;
}
protected DevisDto convertToDto(Devis item) {
var dto = new DevisDto();
dto.setId(item.getId());
dto.setClients(clients? clientConverter.toDto(item.getClients()): null);
dto.setEstimations(estimations? estimationConverter.toDto(item.getEstimations()): null);
dto.setCommandes(commandes? commandeConverter.toDto(item.getCommandes()): null);
dto.setFactures(factures? factureConverter.toDto(item.getFactures()): null);
dto.setNotesCredit(notesCredit? noteCreditConverter.toDto(item.getNotesCredit()): null);
dto.setRemboursements(remboursements? remboursementConverter.toDto(item.getRemboursements()): null);
dto.setBonCommandes(bonCommandes? bonCommandeConverter.toDto(item.getBonCommandes()): null);
dto.setNouvelleDevise(nouvelleDevise? nouvelleDeviseConverter.toDto(item.getNouvelleDevise()): null);
dto.setTauxDeChange(item.getTauxDeChange());
dto.setDefaut(item.isDefaut());
return dto;
}
public void setClients(boolean value) {
this.clients = value;
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
public void setNouvelleDevise(boolean value) {
this.nouvelleDevise = value;
}
public void setRemboursementConverter(RemboursementConverter value) {
this.remboursementConverter = value;
}
public RemboursementConverter getRemboursementConverter() {
return remboursementConverter;
}
public void setNouvelleDeviseConverter(NouvelleDeviseConverter value) {
this.nouvelleDeviseConverter = value;
}
public NouvelleDeviseConverter getNouvelleDeviseConverter() {
return nouvelleDeviseConverter;
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