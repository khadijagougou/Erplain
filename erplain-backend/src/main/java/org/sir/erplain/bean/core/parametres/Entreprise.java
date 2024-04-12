package org.sir.erplain.bean.core.parametres;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="entreprise")
public class Entreprise {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String email;
private String telephone;
private String siteweb;
private String logo;
@OneToOne()
private Address address;
@OneToMany(mappedBy = "entreprise")
private List<Employe> employes;
@OneToMany(mappedBy = "entreprise")
private List<Produit> produits;
@OneToMany(mappedBy = "entreprise")
private List<Client> clients;
@OneToMany(mappedBy = "entreprise")
private List<Fournisseur> fournisseurs;
@OneToMany(mappedBy = "entreprise")
private List<Paiement> paiement;
@OneToMany(mappedBy = "entreprise")
private List<CommandeExpedition> commandeExpedition;
@OneToMany(mappedBy = "entreprise")
private List<Livraison> livraison;
@OneToMany(mappedBy = "entreprise")
private List<BonCommande> bonCommande;
@OneToMany(mappedBy = "entreprise")
private List<NiveauStock> niveauStock;
@OneToMany(mappedBy = "entreprise")
private List<Remboursement> remboursement;
@OneToMany(mappedBy = "entreprise")
private List<NoteCredit> noteCredit;
@OneToMany(mappedBy = "entreprise")
private List<RetourProduit> retourProduit;
@OneToMany(mappedBy = "entreprise")
private List<Facture> facture;
@OneToMany(mappedBy = "entreprise")
private List<Commande> commande;
@OneToMany(mappedBy = "entreprise")
private List<Estimation> estimation;
public Entreprise() {
}
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
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
this.address = value;
}
public List<Employe> getEmployes() {
return employes;
}
public void setEmployes(List<Employe> value) {
this.employes = value;
}
public List<Produit> getProduits() {
return produits;
}
public void setProduits(List<Produit> value) {
this.produits = value;
}
public List<Client> getClients() {
return clients;
}
public void setClients(List<Client> value) {
this.clients = value;
}
public List<Fournisseur> getFournisseurs() {
return fournisseurs;
}
public void setFournisseurs(List<Fournisseur> value) {
this.fournisseurs = value;
}
public List<Paiement> getPaiement() {
return paiement;
}
public void setPaiement(List<Paiement> value) {
this.paiement = value;
}
public List<CommandeExpedition> getCommandeExpedition() {
return commandeExpedition;
}
public void setCommandeExpedition(List<CommandeExpedition> value) {
this.commandeExpedition = value;
}
public List<Livraison> getLivraison() {
return livraison;
}
public void setLivraison(List<Livraison> value) {
this.livraison = value;
}
public List<BonCommande> getBonCommande() {
return bonCommande;
}
public void setBonCommande(List<BonCommande> value) {
this.bonCommande = value;
}
public List<NiveauStock> getNiveauStock() {
return niveauStock;
}
public void setNiveauStock(List<NiveauStock> value) {
this.niveauStock = value;
}
public List<Remboursement> getRemboursement() {
return remboursement;
}
public void setRemboursement(List<Remboursement> value) {
this.remboursement = value;
}
public List<NoteCredit> getNoteCredit() {
return noteCredit;
}
public void setNoteCredit(List<NoteCredit> value) {
this.noteCredit = value;
}
public List<RetourProduit> getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(List<RetourProduit> value) {
this.retourProduit = value;
}
public List<Facture> getFacture() {
return facture;
}
public void setFacture(List<Facture> value) {
this.facture = value;
}
public List<Commande> getCommande() {
return commande;
}
public void setCommande(List<Commande> value) {
this.commande = value;
}
public List<Estimation> getEstimation() {
return estimation;
}
public void setEstimation(List<Estimation> value) {
this.estimation = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Entreprise entreprise) {
return entreprise.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}