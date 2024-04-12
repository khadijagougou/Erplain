package org.sir.erplain.bean.core.contacts;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.bean.enums.LangueEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="client")
public class Client {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String code;
private String email;
private String siteweb;
private String telephone;
private int taxeNumero;
private float rabais;
@Enumerated(EnumType.STRING)
private LangueEnum languePDF;
private int valeurCommandeMinimale;
@OneToOne()
private Address address;
@OneToMany(mappedBy = "client")
private List<Estimation> estimations;
@OneToMany(mappedBy = "client")
private List<Commande> commandes;
@OneToMany(mappedBy = "client")
private List<Facture> factures;
@OneToMany(mappedBy = "client")
private List<RetourProduit> retourProduits;
@OneToMany(mappedBy = "client")
private List<NoteCredit> notesCredit;
@OneToMany(mappedBy = "client")
private List<Remboursement> remboursements;
@OneToMany(mappedBy = "client")
private List<ClientTaxe> clientTaxe;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
@ManyToOne(fetch = FetchType.LAZY)
private Devis devis;
@ManyToOne(fetch = FetchType.LAZY)
private NiveauPrix niveauPrix;
public Client() {
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
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public String getEmail() {
return email;
}
public void setEmail(String value) {
this.email = value;
}
public String getSiteweb() {
return siteweb;
}
public void setSiteweb(String value) {
this.siteweb = value;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String value) {
this.telephone = value;
}
public int getTaxeNumero() {
return taxeNumero;
}
public void setTaxeNumero(int value) {
this.taxeNumero = value;
}
public float getRabais() {
return rabais;
}
public void setRabais(float value) {
this.rabais = value;
}
public LangueEnum getLanguePDF() {
return languePDF;
}
public void setLanguePDF(LangueEnum value) {
this.languePDF = value;
}
public int getValeurCommandeMinimale() {
return valeurCommandeMinimale;
}
public void setValeurCommandeMinimale(int value) {
this.valeurCommandeMinimale = value;
}
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
this.address = value;
}
public List<Estimation> getEstimations() {
return estimations;
}
public void setEstimations(List<Estimation> value) {
this.estimations = value;
}
public List<Commande> getCommandes() {
return commandes;
}
public void setCommandes(List<Commande> value) {
this.commandes = value;
}
public List<Facture> getFactures() {
return factures;
}
public void setFactures(List<Facture> value) {
this.factures = value;
}
public List<RetourProduit> getRetourProduits() {
return retourProduits;
}
public void setRetourProduits(List<RetourProduit> value) {
this.retourProduits = value;
}
public List<NoteCredit> getNotesCredit() {
return notesCredit;
}
public void setNotesCredit(List<NoteCredit> value) {
this.notesCredit = value;
}
public List<Remboursement> getRemboursements() {
return remboursements;
}
public void setRemboursements(List<Remboursement> value) {
this.remboursements = value;
}
public List<ClientTaxe> getClientTaxe() {
return clientTaxe;
}
public void setClientTaxe(List<ClientTaxe> value) {
this.clientTaxe = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
public Devis getDevis() {
return devis;
}
public void setDevis(Devis value) {
this.devis = value;
}
public NiveauPrix getNiveauPrix() {
return niveauPrix;
}
public void setNiveauPrix(NiveauPrix value) {
this.niveauPrix = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Client client) {
return client.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}