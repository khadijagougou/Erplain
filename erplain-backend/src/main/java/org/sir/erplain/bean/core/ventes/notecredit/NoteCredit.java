package org.sir.erplain.bean.core.ventes.notecredit;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.enums.StatutNoteCreditEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="notecredit")
public class NoteCredit {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
private LocalDate dateExperation;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private int totalUnites;
private double remiseGlobal;
private double sousTotal;
private double total;
@Enumerated(EnumType.STRING)
private StatutNoteCreditEnum statut;
@OneToMany(mappedBy = "noteCredit")
private List<NoteCreditTaxe> noteCreditTaxe;
@OneToMany(mappedBy = "noteCredit")
private List<NoteCreditProduit> noteCreditProduit;
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
public NoteCredit() {
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
public LocalDate getDateExperation() {
return dateExperation;
}
public void setDateExperation(LocalDate value) {
this.dateExperation = value;
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
public StatutNoteCreditEnum getStatut() {
return statut;
}
public void setStatut(StatutNoteCreditEnum value) {
this.statut = value;
}
public List<NoteCreditTaxe> getNoteCreditTaxe() {
return noteCreditTaxe;
}
public void setNoteCreditTaxe(List<NoteCreditTaxe> value) {
this.noteCreditTaxe = value;
}
public List<NoteCreditProduit> getNoteCreditProduit() {
return noteCreditProduit;
}
public void setNoteCreditProduit(List<NoteCreditProduit> value) {
this.noteCreditProduit = value;
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
if (object instanceof NoteCredit noteCredit) {
return noteCredit.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}