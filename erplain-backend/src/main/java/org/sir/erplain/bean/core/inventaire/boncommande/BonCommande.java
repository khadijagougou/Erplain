package org.sir.erplain.bean.core.inventaire.boncommande;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.bean.enums.TypeRabaisEnum;
import org.sir.erplain.bean.enums.StatutBonCommandeEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="boncommande")
public class BonCommande {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private float rabais;
@Enumerated(EnumType.STRING)
private TypeRabaisEnum typeRabais;
private double remiseGlobal;
private int totalUnites;
private double sousTotal;
private double total;
@Enumerated(EnumType.STRING)
private StatutBonCommandeEnum statut;
@OneToOne()
private Livraison livraison;
@OneToMany(mappedBy = "bonCommande")
private List<BonCommandeTaxe> bonCommandeTaxe;
@OneToMany(mappedBy = "bonCommande")
private List<BonCommandeTaxeExpedition> bonCommandeTaxeExpedition;
@OneToMany(mappedBy = "bonCommande")
private List<BonCommandeProduit> bonCommandeProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Fournisseur fournisseur;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
@ManyToOne(fetch = FetchType.LAZY)
private Devis devis;
@ManyToOne(fetch = FetchType.LAZY)
private NiveauPrix niveauPrix;
public BonCommande() {
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
public float getRabais() {
return rabais;
}
public void setRabais(float value) {
this.rabais = value;
}
public TypeRabaisEnum getTypeRabais() {
return typeRabais;
}
public void setTypeRabais(TypeRabaisEnum value) {
this.typeRabais = value;
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
public StatutBonCommandeEnum getStatut() {
return statut;
}
public void setStatut(StatutBonCommandeEnum value) {
this.statut = value;
}
public Livraison getLivraison() {
return livraison;
}
public void setLivraison(Livraison value) {
this.livraison = value;
}
public List<BonCommandeTaxe> getBonCommandeTaxe() {
return bonCommandeTaxe;
}
public void setBonCommandeTaxe(List<BonCommandeTaxe> value) {
this.bonCommandeTaxe = value;
}
public List<BonCommandeTaxeExpedition> getBonCommandeTaxeExpedition() {
return bonCommandeTaxeExpedition;
}
public void setBonCommandeTaxeExpedition(List<BonCommandeTaxeExpedition> value) {
this.bonCommandeTaxeExpedition = value;
}
public List<BonCommandeProduit> getBonCommandeProduit() {
return bonCommandeProduit;
}
public void setBonCommandeProduit(List<BonCommandeProduit> value) {
this.bonCommandeProduit = value;
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
if (object instanceof BonCommande bonCommande) {
return bonCommande.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}