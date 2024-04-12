package org.sir.erplain.bean.core.parametres;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="devis")
public class Devis {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@OneToMany(mappedBy = "devis")
private List<Client> clients;
@OneToMany(mappedBy = "devis")
private List<Estimation> estimations;
@OneToMany(mappedBy = "devis")
private List<Commande> commandes;
@OneToMany(mappedBy = "devis")
private List<Facture> factures;
@OneToMany(mappedBy = "devis")
private List<NoteCredit> notesCredit;
@OneToMany(mappedBy = "devis")
private List<Remboursement> remboursements;
@OneToMany(mappedBy = "devis")
private List<BonCommande> bonCommandes;
@ManyToOne(fetch = FetchType.LAZY)
private NouvelleDevise nouvelleDevise;
private double tauxDeChange;
private boolean defaut;
public Devis() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public List<Client> getClients() {
return clients;
}
public void setClients(List<Client> value) {
this.clients = value;
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
public NouvelleDevise getNouvelleDevise() {
return nouvelleDevise;
}
public void setNouvelleDevise(NouvelleDevise value) {
this.nouvelleDevise = value;
}
public double getTauxDeChange() {
return tauxDeChange;
}
public void setTauxDeChange(double value) {
this.tauxDeChange = value;
}
public boolean isDefaut() {
return defaut;
}
public void setDefaut(boolean value) {
this.defaut = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Devis devis) {
return devis.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}