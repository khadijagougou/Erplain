package org.sir.erplain.bean.core.ventes.facture;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.enums.TypeRabaisEnum;
import org.sir.erplain.bean.enums.StatutFactureEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="facture")
public class Facture {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
private LocalDate dateExperation;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private float rabais;
@Enumerated(EnumType.STRING)
private TypeRabaisEnum typeRabais;
private int totalUnites;
private double remiseGlobal;
private double sousTotal;
private double total;
@Enumerated(EnumType.STRING)
private StatutFactureEnum statut;
@OneToOne()
private Paiement paiement;
@OneToMany(mappedBy = "facture")
private List<RetourProduit> retourProduit;
@OneToMany(mappedBy = "facture")
private List<FactureTaxe> factureTaxe;
@OneToMany(mappedBy = "facture")
private List<FactureTaxeExpedition> factureTaxeExpedition;
@OneToMany(mappedBy = "facture")
private List<FactureProduit> factureProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Client client;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
@ManyToOne(fetch = FetchType.LAZY)
private Devis devis;
@ManyToOne(fetch = FetchType.LAZY)
private NiveauPrix niveauPrix;
public Facture() {
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
public StatutFactureEnum getStatut() {
return statut;
}
public void setStatut(StatutFactureEnum value) {
this.statut = value;
}
public Paiement getPaiement() {
return paiement;
}
public void setPaiement(Paiement value) {
this.paiement = value;
}
public List<RetourProduit> getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(List<RetourProduit> value) {
this.retourProduit = value;
}
public List<FactureTaxe> getFactureTaxe() {
return factureTaxe;
}
public void setFactureTaxe(List<FactureTaxe> value) {
this.factureTaxe = value;
}
public List<FactureTaxeExpedition> getFactureTaxeExpedition() {
return factureTaxeExpedition;
}
public void setFactureTaxeExpedition(List<FactureTaxeExpedition> value) {
this.factureTaxeExpedition = value;
}
public List<FactureProduit> getFactureProduit() {
return factureProduit;
}
public void setFactureProduit(List<FactureProduit> value) {
this.factureProduit = value;
}
public Client getClient() {
return client;
}
public void setClient(Client value) {
this.client = value;
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
if (object instanceof Facture facture) {
return facture.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}