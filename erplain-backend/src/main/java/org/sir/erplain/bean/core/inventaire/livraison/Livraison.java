package org.sir.erplain.bean.core.inventaire.livraison;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.enums.StatutLivraisonEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="livraison")
public class Livraison {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private double remiseGlobal;
private int totalUnites;
private double sousTotal;
private double total;
@Enumerated(EnumType.STRING)
private StatutLivraisonEnum statut;
@OneToMany(mappedBy = "livraison")
private List<LivraisonTaxeExpedition> livraisonTaxeExpedition;
@OneToMany(mappedBy = "livraison")
private List<LivraisonProduit> livraisonProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Fournisseur fournisseur;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
public Livraison() {
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
public double getRemiseGlobal() {
return remiseGlobal;
}
public void setRemiseGlobal(double value) {
this.remiseGlobal = value;
}
public int getTotalUnites() {
return totalUnites;
}
public void setTotalUnites(int value) {
this.totalUnites = value;
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
public StatutLivraisonEnum getStatut() {
return statut;
}
public void setStatut(StatutLivraisonEnum value) {
this.statut = value;
}
public List<LivraisonTaxeExpedition> getLivraisonTaxeExpedition() {
return livraisonTaxeExpedition;
}
public void setLivraisonTaxeExpedition(List<LivraisonTaxeExpedition> value) {
this.livraisonTaxeExpedition = value;
}
public List<LivraisonProduit> getLivraisonProduit() {
return livraisonProduit;
}
public void setLivraisonProduit(List<LivraisonProduit> value) {
this.livraisonProduit = value;
}
public Fournisseur getFournisseur() {
return fournisseur;
}
public void setFournisseur(Fournisseur value) {
this.fournisseur = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Livraison livraison) {
return livraison.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}