package org.sir.erplain.ws.dto.parametres;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.ventes.PaiementDto;
import org.sir.erplain.ws.dto.inventaire.NiveauStockDto;
import org.sir.erplain.ws.dto.address.AddressDto;
import org.sir.erplain.ws.dto.ventes.retourproduit.RetourProduitDto;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeDto;
import org.sir.erplain.ws.dto.inventaire.livraison.LivraisonDto;
import org.sir.erplain.ws.dto.produit.ProduitDto;
import org.sir.erplain.ws.dto.contacts.FournisseurDto;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.sir.erplain.ws.dto.ventes.CommandeExpeditionDto;
import org.sir.erplain.ws.dto.contacts.user.EmployeDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeDto;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntrepriseDto {
private Long id;
private String nom;
private String email;
private String telephone;
private String siteweb;
private String logo;
private AddressDto address;
private List<EmployeDto> employes;
private List<ProduitDto> produits;
private List<ClientDto> clients;
private List<FournisseurDto> fournisseurs;
private List<PaiementDto> paiement;
private List<CommandeExpeditionDto> commandeExpedition;
private List<LivraisonDto> livraison;
private List<BonCommandeDto> bonCommande;
private List<NiveauStockDto> niveauStock;
private List<RemboursementDto> remboursement;
private List<NoteCreditDto> noteCredit;
private List<RetourProduitDto> retourProduit;
private List<FactureDto> facture;
private List<CommandeDto> commande;
private List<EstimationDto> estimation;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getNom() {
return nom;
}
public void setNom(String value) {
this.nom = value;
}
public String getEmail() {
return email;
}
public void setEmail(String value) {
this.email = value;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String value) {
this.telephone = value;
}
public String getSiteweb() {
return siteweb;
}
public void setSiteweb(String value) {
this.siteweb = value;
}
public String getLogo() {
return logo;
}
public void setLogo(String value) {
this.logo = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
}
public List<EmployeDto> getEmployes() {
return employes;
}
public void setEmployes(List<EmployeDto> value) {
this.employes = value;
}
public List<ProduitDto> getProduits() {
return produits;
}
public void setProduits(List<ProduitDto> value) {
this.produits = value;
}
public List<ClientDto> getClients() {
return clients;
}
public void setClients(List<ClientDto> value) {
this.clients = value;
}
public List<FournisseurDto> getFournisseurs() {
return fournisseurs;
}
public void setFournisseurs(List<FournisseurDto> value) {
this.fournisseurs = value;
}
public List<PaiementDto> getPaiement() {
return paiement;
}
public void setPaiement(List<PaiementDto> value) {
this.paiement = value;
}
public List<CommandeExpeditionDto> getCommandeExpedition() {
return commandeExpedition;
}
public void setCommandeExpedition(List<CommandeExpeditionDto> value) {
this.commandeExpedition = value;
}
public List<LivraisonDto> getLivraison() {
return livraison;
}
public void setLivraison(List<LivraisonDto> value) {
this.livraison = value;
}
public List<BonCommandeDto> getBonCommande() {
return bonCommande;
}
public void setBonCommande(List<BonCommandeDto> value) {
this.bonCommande = value;
}
public List<NiveauStockDto> getNiveauStock() {
return niveauStock;
}
public void setNiveauStock(List<NiveauStockDto> value) {
this.niveauStock = value;
}
public List<RemboursementDto> getRemboursement() {
return remboursement;
}
public void setRemboursement(List<RemboursementDto> value) {
this.remboursement = value;
}
public List<NoteCreditDto> getNoteCredit() {
return noteCredit;
}
public void setNoteCredit(List<NoteCreditDto> value) {
this.noteCredit = value;
}
public List<RetourProduitDto> getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(List<RetourProduitDto> value) {
this.retourProduit = value;
}
public List<FactureDto> getFacture() {
return facture;
}
public void setFacture(List<FactureDto> value) {
this.facture = value;
}
public List<CommandeDto> getCommande() {
return commande;
}
public void setCommande(List<CommandeDto> value) {
this.commande = value;
}
public List<EstimationDto> getEstimation() {
return estimation;
}
public void setEstimation(List<EstimationDto> value) {
this.estimation = value;
}
}