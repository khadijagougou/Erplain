package org.sir.erplain.ws.converter.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.ws.dto.ventes.commande.CommandeDto;
import org.sir.erplain.ws.converter.ventes.facture.FactureConverter;
import org.sir.erplain.ws.converter.ventes.CommandeExpeditionConverter;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CommandeConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private CommandeExpeditionConverter commandeExpeditionConverter;
@Autowired private CommandeTaxeExpeditionConverter commandeTaxeExpeditionConverter;
@Autowired private CommandeProduitConverter commandeProduitConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private FactureConverter factureConverter;
@Autowired private CommandeTaxeConverter commandeTaxeConverter;
private boolean facture = true;
private boolean commandeExpedition = true;
private boolean commandeTaxe = true;
private boolean commandeTaxeExpedition = true;
private boolean commandeProduit = true;
private boolean client = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setCommande(value);
this.niveauPrixConverter.setCommandes(value);
this.devisConverter.setCommandes(value);
this.commandeExpeditionConverter.setCommande(value);
this.commandeTaxeExpeditionConverter.setCommande(value);
this.commandeProduitConverter.setCommande(value);
this.clientConverter.setCommandes(value);
this.commandeTaxeConverter.setCommande(value);
}
public final CommandeDto toDto(Commande item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Commande toItem(CommandeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Commande> toItem(List<CommandeDto> dtos) {
if (dtos == null) return null;
List<Commande> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<CommandeDto> toDto(List<Commande> items) {
if (items == null) return null;
List<CommandeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Commande convertToItem(CommandeDto dto) {
var item = new Commande();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateExperation(dto.getDateExperation());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setRabais(dto.getRabais());
item.setRemiseGlobal(dto.getRemiseGlobal());
item.setTypeRabais(dto.getTypeRabais());
item.setTotalUnites(dto.getTotalUnites());
item.setSousTotal(dto.getSousTotal());
item.setTotal(dto.getTotal());
item.setStatut(dto.getStatut());
item.setFacture(factureConverter.toItem(dto.getFacture()));
item.setCommandeExpedition(commandeExpeditionConverter.toItem(dto.getCommandeExpedition()));
item.setCommandeTaxe(commandeTaxeConverter.toItem(dto.getCommandeTaxe()));
item.setCommandeTaxeExpedition(commandeTaxeExpeditionConverter.toItem(dto.getCommandeTaxeExpedition()));
item.setCommandeProduit(commandeProduitConverter.toItem(dto.getCommandeProduit()));
item.setClient(clientConverter.toItem(dto.getClient()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected CommandeDto convertToDto(Commande item) {
var dto = new CommandeDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateExperation(item.getDateExperation());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setRabais(item.getRabais());
dto.setRemiseGlobal(item.getRemiseGlobal());
dto.setTypeRabais(item.getTypeRabais());
dto.setTotalUnites(item.getTotalUnites());
dto.setSousTotal(item.getSousTotal());
dto.setTotal(item.getTotal());
dto.setStatut(item.getStatut());
dto.setFacture(facture? factureConverter.toDto(item.getFacture()): null);
dto.setCommandeExpedition(commandeExpedition? commandeExpeditionConverter.toDto(item.getCommandeExpedition()): null);
dto.setCommandeTaxe(commandeTaxe? commandeTaxeConverter.toDto(item.getCommandeTaxe()): null);
dto.setCommandeTaxeExpedition(commandeTaxeExpedition? commandeTaxeExpeditionConverter.toDto(item.getCommandeTaxeExpedition()): null);
dto.setCommandeProduit(commandeProduit? commandeProduitConverter.toDto(item.getCommandeProduit()): null);
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setFacture(boolean value) {
this.facture = value;
}
public void setCommandeExpedition(boolean value) {
this.commandeExpedition = value;
}
public void setCommandeTaxe(boolean value) {
this.commandeTaxe = value;
}
public void setCommandeTaxeExpedition(boolean value) {
this.commandeTaxeExpedition = value;
}
public void setCommandeProduit(boolean value) {
this.commandeProduit = value;
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
public void setDevisConverter(DevisConverter value) {
this.devisConverter = value;
}
public DevisConverter getDevisConverter() {
return devisConverter;
}
public void setCommandeExpeditionConverter(CommandeExpeditionConverter value) {
this.commandeExpeditionConverter = value;
}
public CommandeExpeditionConverter getCommandeExpeditionConverter() {
return commandeExpeditionConverter;
}
public void setCommandeTaxeExpeditionConverter(CommandeTaxeExpeditionConverter value) {
this.commandeTaxeExpeditionConverter = value;
}
public CommandeTaxeExpeditionConverter getCommandeTaxeExpeditionConverter() {
return commandeTaxeExpeditionConverter;
}
public void setCommandeProduitConverter(CommandeProduitConverter value) {
this.commandeProduitConverter = value;
}
public CommandeProduitConverter getCommandeProduitConverter() {
return commandeProduitConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
public void setCommandeTaxeConverter(CommandeTaxeConverter value) {
this.commandeTaxeConverter = value;
}
public CommandeTaxeConverter getCommandeTaxeConverter() {
return commandeTaxeConverter;
}
}