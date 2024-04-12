package org.sir.erplain.ws.converter.parametres;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.converter.address.AddressConverter;
import org.sir.erplain.ws.converter.contacts.user.EmployeConverter;
import org.sir.erplain.ws.converter.produit.ProduitConverter;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.contacts.FournisseurConverter;
import org.sir.erplain.ws.converter.ventes.PaiementConverter;
import org.sir.erplain.ws.converter.ventes.CommandeExpeditionConverter;
import org.sir.erplain.ws.converter.inventaire.livraison.LivraisonConverter;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeConverter;
import org.sir.erplain.ws.converter.inventaire.NiveauStockConverter;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementConverter;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditConverter;
import org.sir.erplain.ws.converter.ventes.retourproduit.RetourProduitConverter;
import org.sir.erplain.ws.converter.ventes.facture.FactureConverter;
import org.sir.erplain.ws.converter.ventes.commande.CommandeConverter;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EntrepriseConverter {
@Autowired private PaiementConverter paiementConverter;
@Autowired private NiveauStockConverter niveauStockConverter;
@Autowired private AddressConverter addressConverter;
@Autowired private RetourProduitConverter retourProduitConverter;
@Autowired private EstimationConverter estimationConverter;
@Autowired private CommandeConverter commandeConverter;
@Autowired private LivraisonConverter livraisonConverter;
@Autowired private ProduitConverter produitConverter;
@Autowired private FournisseurConverter fournisseurConverter;
@Autowired private RemboursementConverter remboursementConverter;
@Autowired private CommandeExpeditionConverter commandeExpeditionConverter;
@Autowired private EmployeConverter employeConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private BonCommandeConverter bonCommandeConverter;
@Autowired private NoteCreditConverter noteCreditConverter;
@Autowired private FactureConverter factureConverter;
private boolean address = true;
private boolean employes = true;
private boolean produits = true;
private boolean clients = true;
private boolean fournisseurs = true;
private boolean paiement = true;
private boolean commandeExpedition = true;
private boolean livraison = true;
private boolean bonCommande = true;
private boolean niveauStock = true;
private boolean remboursement = true;
private boolean noteCredit = true;
private boolean retourProduit = true;
private boolean facture = true;
private boolean commande = true;
private boolean estimation = true;
protected void configure(boolean value) {
this.paiementConverter.setEntreprise(value);
this.niveauStockConverter.setEntreprise(value);
this.retourProduitConverter.setEntreprise(value);
this.estimationConverter.setEntreprise(value);
this.commandeConverter.setEntreprise(value);
this.livraisonConverter.setEntreprise(value);
this.produitConverter.setEntreprise(value);
this.fournisseurConverter.setEntreprise(value);
this.remboursementConverter.setEntreprise(value);
this.commandeExpeditionConverter.setEntreprise(value);
this.employeConverter.setEntreprise(value);
this.clientConverter.setEntreprise(value);
this.bonCommandeConverter.setEntreprise(value);
this.noteCreditConverter.setEntreprise(value);
this.factureConverter.setEntreprise(value);
}
public final EntrepriseDto toDto(Entreprise item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Entreprise toItem(EntrepriseDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Entreprise> toItem(List<EntrepriseDto> dtos) {
if (dtos == null) return null;
List<Entreprise> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EntrepriseDto> toDto(List<Entreprise> items) {
if (items == null) return null;
List<EntrepriseDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Entreprise convertToItem(EntrepriseDto dto) {
var item = new Entreprise();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setEmail(dto.getEmail());
item.setTelephone(dto.getTelephone());
item.setSiteweb(dto.getSiteweb());
item.setLogo(dto.getLogo());
item.setAddress(addressConverter.toItem(dto.getAddress()));
item.setEmployes(employeConverter.toItem(dto.getEmployes()));
item.setProduits(produitConverter.toItem(dto.getProduits()));
item.setClients(clientConverter.toItem(dto.getClients()));
item.setFournisseurs(fournisseurConverter.toItem(dto.getFournisseurs()));
item.setPaiement(paiementConverter.toItem(dto.getPaiement()));
item.setCommandeExpedition(commandeExpeditionConverter.toItem(dto.getCommandeExpedition()));
item.setLivraison(livraisonConverter.toItem(dto.getLivraison()));
item.setBonCommande(bonCommandeConverter.toItem(dto.getBonCommande()));
item.setNiveauStock(niveauStockConverter.toItem(dto.getNiveauStock()));
item.setRemboursement(remboursementConverter.toItem(dto.getRemboursement()));
item.setNoteCredit(noteCreditConverter.toItem(dto.getNoteCredit()));
item.setRetourProduit(retourProduitConverter.toItem(dto.getRetourProduit()));
item.setFacture(factureConverter.toItem(dto.getFacture()));
item.setCommande(commandeConverter.toItem(dto.getCommande()));
item.setEstimation(estimationConverter.toItem(dto.getEstimation()));
return item;
}
protected EntrepriseDto convertToDto(Entreprise item) {
var dto = new EntrepriseDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setEmail(item.getEmail());
dto.setTelephone(item.getTelephone());
dto.setSiteweb(item.getSiteweb());
dto.setLogo(item.getLogo());
dto.setAddress(address? addressConverter.toDto(item.getAddress()): null);
dto.setEmployes(employes? employeConverter.toDto(item.getEmployes()): null);
dto.setProduits(produits? produitConverter.toDto(item.getProduits()): null);
dto.setClients(clients? clientConverter.toDto(item.getClients()): null);
dto.setFournisseurs(fournisseurs? fournisseurConverter.toDto(item.getFournisseurs()): null);
dto.setPaiement(paiement? paiementConverter.toDto(item.getPaiement()): null);
dto.setCommandeExpedition(commandeExpedition? commandeExpeditionConverter.toDto(item.getCommandeExpedition()): null);
dto.setLivraison(livraison? livraisonConverter.toDto(item.getLivraison()): null);
dto.setBonCommande(bonCommande? bonCommandeConverter.toDto(item.getBonCommande()): null);
dto.setNiveauStock(niveauStock? niveauStockConverter.toDto(item.getNiveauStock()): null);
dto.setRemboursement(remboursement? remboursementConverter.toDto(item.getRemboursement()): null);
dto.setNoteCredit(noteCredit? noteCreditConverter.toDto(item.getNoteCredit()): null);
dto.setRetourProduit(retourProduit? retourProduitConverter.toDto(item.getRetourProduit()): null);
dto.setFacture(facture? factureConverter.toDto(item.getFacture()): null);
dto.setCommande(commande? commandeConverter.toDto(item.getCommande()): null);
dto.setEstimation(estimation? estimationConverter.toDto(item.getEstimation()): null);
return dto;
}
public void setAddress(boolean value) {
this.address = value;
}
public void setEmployes(boolean value) {
this.employes = value;
}
public void setProduits(boolean value) {
this.produits = value;
}
public void setClients(boolean value) {
this.clients = value;
}
public void setFournisseurs(boolean value) {
this.fournisseurs = value;
}
public void setPaiement(boolean value) {
this.paiement = value;
}
public void setCommandeExpedition(boolean value) {
this.commandeExpedition = value;
}
public void setLivraison(boolean value) {
this.livraison = value;
}
public void setBonCommande(boolean value) {
this.bonCommande = value;
}
public void setNiveauStock(boolean value) {
this.niveauStock = value;
}
public void setRemboursement(boolean value) {
this.remboursement = value;
}
public void setNoteCredit(boolean value) {
this.noteCredit = value;
}
public void setRetourProduit(boolean value) {
this.retourProduit = value;
}
public void setFacture(boolean value) {
this.facture = value;
}
public void setCommande(boolean value) {
this.commande = value;
}
public void setEstimation(boolean value) {
this.estimation = value;
}
public void setPaiementConverter(PaiementConverter value) {
this.paiementConverter = value;
}
public PaiementConverter getPaiementConverter() {
return paiementConverter;
}
public void setNiveauStockConverter(NiveauStockConverter value) {
this.niveauStockConverter = value;
}
public NiveauStockConverter getNiveauStockConverter() {
return niveauStockConverter;
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
public void setLivraisonConverter(LivraisonConverter value) {
this.livraisonConverter = value;
}
public LivraisonConverter getLivraisonConverter() {
return livraisonConverter;
}
public void setProduitConverter(ProduitConverter value) {
this.produitConverter = value;
}
public ProduitConverter getProduitConverter() {
return produitConverter;
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
public void setCommandeExpeditionConverter(CommandeExpeditionConverter value) {
this.commandeExpeditionConverter = value;
}
public CommandeExpeditionConverter getCommandeExpeditionConverter() {
return commandeExpeditionConverter;
}
public void setEmployeConverter(EmployeConverter value) {
this.employeConverter = value;
}
public EmployeConverter getEmployeConverter() {
return employeConverter;
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
public void setNoteCreditConverter(NoteCreditConverter value) {
this.noteCreditConverter = value;
}
public NoteCreditConverter getNoteCreditConverter() {
return noteCreditConverter;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
}