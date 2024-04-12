package org.sir.erplain.bean.core.ventes.remboursement;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.enums.StatutRemboursementEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="remboursement")
public class Remboursement {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private int totalUnites;
private double remiseGlobal;
private double sousTotal;
private double total;
@Enumerated(EnumType.STRING)
private StatutRemboursementEnum statut;
@OneToMany(mappedBy = "remboursement")
private List<RemboursementTaxe> remboursementTaxe;
@OneToMany(mappedBy = "remboursement")
private List<RemboursementProduit> remboursementProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Client client;
@ManyToOne(fetch = FetchType.LAZY)
private RetourProduit retourProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
@ManyToOne(fetch = FetchType.LAZY)
private Devis devis;
@ManyToOne(fetch = FetchType.LAZY)
private NiveauPrix niveauPrix;
public Remboursement() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public LocalDate getDateCreation() {
return dateCreation;
}
public void setDateCreation(LocalDate value) {
this.dateCreation = value;
}
public LocalDate getDateExpedition() {
return dateExpedition;
}
public void setDateExpedition(LocalDate value) {
this.dateExpedition = value;
}
public int getTotalUnites() {
return totalUnites;
}
public void setTotalUnites(int value) {
this.totalUnites = value;
}
public double getRemiseGlobal() {
return remiseGlobal;
}
public void setRemiseGlobal(double value) {
this.remiseGlobal = value;
}
public double getSousTotal() {
return sousTotal;
}
public void setSousTotal(double value) {
this.sousTotal = value;
}
public double getTotal() {
return total;
}
public void setTotal(double value) {
this.total = value;
}
public StatutRemboursementEnum getStatut() {
return statut;
}
public void setStatut(StatutRemboursementEnum value) {
this.statut = value;
}
public List<RemboursementTaxe> getRemboursementTaxe() {
return remboursementTaxe;
}
public void setRemboursementTaxe(List<RemboursementTaxe> value) {
this.remboursementTaxe = value;
}
public List<RemboursementProduit> getRemboursementProduit() {
return remboursementProduit;
}
public void setRemboursementProduit(List<RemboursementProduit> value) {
this.remboursementProduit = value;
}
public Client getClient() {
return client;
}
public void setClient(Client value) {
this.client = value;
}
public RetourProduit getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(RetourProduit value) {
this.retourProduit = value;
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
if (object instanceof Remboursement remboursement) {
return remboursement.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}