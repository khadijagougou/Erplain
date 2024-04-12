package org.sir.erplain.ws.converter.contacts;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.ws.converter.address.AddressConverter;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationConverter;
import org.sir.erplain.ws.converter.ventes.commande.CommandeConverter;
import org.sir.erplain.ws.converter.ventes.facture.FactureConverter;
import org.sir.erplain.ws.converter.ventes.retourproduit.RetourProduitConverter;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditConverter;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ClientConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private ClientTaxeConverter clientTaxeConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private RemboursementConverter remboursementConverter;
@Autowired private AddressConverter addressConverter;
@Autowired private RetourProduitConverter retourProduitConverter;
@Autowired private EstimationConverter estimationConverter;
@Autowired private CommandeConverter commandeConverter;
@Autowired private FactureConverter factureConverter;
@Autowired private NoteCreditConverter noteCreditConverter;
private boolean address = true;
private boolean estimations = true;
private boolean commandes = true;
private boolean factures = true;
private boolean retourProduits = true;
private boolean notesCredit = true;
private boolean remboursements = true;
private boolean clientTaxe = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setClients(value);
this.niveauPrixConverter.setClients(value);
this.clientTaxeConverter.setClient(value);
this.devisConverter.setClients(value);
this.remboursementConverter.setClient(value);
this.retourProduitConverter.setClient(value);
this.estimationConverter.setClient(value);
this.commandeConverter.setClient(value);
this.factureConverter.setClient(value);
this.noteCreditConverter.setClient(value);
}
public final ClientDto toDto(Client item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Client toItem(ClientDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Client> toItem(List<ClientDto> dtos) {
if (dtos == null) return null;
List<Client> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<ClientDto> toDto(List<Client> items) {
if (items == null) return null;
List<ClientDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Client convertToItem(ClientDto dto) {
var item = new Client();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setCode(dto.getCode());
item.setEmail(dto.getEmail());
item.setSiteweb(dto.getSiteweb());
item.setTelephone(dto.getTelephone());
item.setTaxeNumero(dto.getTaxeNumero());
item.setRabais(dto.getRabais());
item.setLanguePDF(dto.getLanguePDF());
item.setValeurCommandeMinimale(dto.getValeurCommandeMinimale());
item.setAddress(addressConverter.toItem(dto.getAddress()));
item.setEstimations(estimationConverter.toItem(dto.getEstimations()));
item.setCommandes(commandeConverter.toItem(dto.getCommandes()));
item.setFactures(factureConverter.toItem(dto.getFactures()));
item.setRetourProduits(retourProduitConverter.toItem(dto.getRetourProduits()));
item.setNotesCredit(noteCreditConverter.toItem(dto.getNotesCredit()));
item.setRemboursements(remboursementConverter.toItem(dto.getRemboursements()));
item.setClientTaxe(clientTaxeConverter.toItem(dto.getClientTaxe()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected ClientDto convertToDto(Client item) {
var dto = new ClientDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setCode(item.getCode());
dto.setEmail(item.getEmail());
dto.setSiteweb(item.getSiteweb());
dto.setTelephone(item.getTelephone());
dto.setTaxeNumero(item.getTaxeNumero());
dto.setRabais(item.getRabais());
dto.setLanguePDF(item.getLanguePDF());
dto.setValeurCommandeMinimale(item.getValeurCommandeMinimale());
dto.setAddress(address? addressConverter.toDto(item.getAddress()): null);
dto.setEstimations(estimations? estimationConverter.toDto(item.getEstimations()): null);
dto.setCommandes(commandes? commandeConverter.toDto(item.getCommandes()): null);
dto.setFactures(factures? factureConverter.toDto(item.getFactures()): null);
dto.setRetourProduits(retourProduits? retourProduitConverter.toDto(item.getRetourProduits()): null);
dto.setNotesCredit(notesCredit? noteCreditConverter.toDto(item.getNotesCredit()): null);
dto.setRemboursements(remboursements? remboursementConverter.toDto(item.getRemboursements()): null);
dto.setClientTaxe(clientTaxe? clientTaxeConverter.toDto(item.getClientTaxe()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setAddress(boolean value) {
this.address = value;
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
public void setRetourProduits(boolean value) {
this.retourProduits = value;
}
public void setNotesCredit(boolean value) {
this.notesCredit = value;
}
public void setRemboursements(boolean value) {
this.remboursements = value;
}
public void setClientTaxe(boolean value) {
this.clientTaxe = value;
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
public void setClientTaxeConverter(ClientTaxeConverter value) {
this.clientTaxeConverter = value;
}
public ClientTaxeConverter getClientTaxeConverter() {
return clientTaxeConverter;
}
public void setDevisConverter(DevisConverter value) {
this.devisConverter = value;
}
public DevisConverter getDevisConverter() {
return devisConverter;
}
public void setRemboursementConverter(RemboursementConverter value) {
this.remboursementConverter = value;
}
public RemboursementConverter getRemboursementConverter() {
return remboursementConverter;
}
public void setAddressConverter(AddressConverter value) {
this.addressConverter = value;
}
public AddressConverter getAddressConverter() {
return addressConverter;
}
public void setRetourProduitConverter(RetourProduitConverter value) {
this.retourProduitConverter = value;
}
public RetourProduitConverter getRetourProduitConverter() {
return retourProduitConverter;
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