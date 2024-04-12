package org.sir.erplain.bean.core.parametres;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.bean.enums.StatutNiveauPrixEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="niveauprix")
public class NiveauPrix {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
@Enumerated(EnumType.STRING)
private StatutNiveauPrixEnum type;
private boolean actif;
@OneToMany(mappedBy = "niveauPrix")
private List<Client> clients;
@OneToMany(mappedBy = "niveauPrix")
private List<Fournisseur> fournisseurs;
@OneToMany(mappedBy = "niveauPrix")
private List<Estimation> estimations;
@OneToMany(mappedBy = "niveauPrix")
private List<Commande> commandes;
@OneToMany(mappedBy = "niveauPrix")
private List<Facture> factures;
@OneToMany(mappedBy = "niveauPrix")
private List<NoteCredit> notesCredit;
@OneToMany(mappedBy = "niveauPrix")
private List<Remboursement> remboursements;
@OneToMany(mappedBy = "niveauPrix")
private List<BonCommande> bonCommandes;
public NiveauPrix() {
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
public StatutNiveauPrixEnum getType() {
return type;
}
public void setType(StatutNiveauPrixEnum value) {
this.type = value;
}
public boolean isActif() {
return actif;
}
public void setActif(boolean value) {
this.actif = value;
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
public List<BonCommande> getBonCommandes() {
return bonCommandes;
}
public void setBonCommandes(List<BonCommande> value) {
this.bonCommandes = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof NiveauPrix niveauPrix) {
return niveauPrix.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}