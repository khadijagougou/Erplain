package org.sir.erplain.bean.core.ventes.estimation;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.enums.TypeRabaisEnum;
import org.sir.erplain.bean.enums.StatutEstimationEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="estimation")
public class Estimation {
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
private double remiseGlobal;
private int totalUnites;
private double sousTotal;
private double total;
@Enumerated(EnumType.STRING)
private StatutEstimationEnum statut;
@OneToOne()
private Facture facture;
@OneToMany(mappedBy = "estimation")
private List<EstimationTaxe> estimationTaxe;
@OneToMany(mappedBy = "estimation")
private List<EstimationTaxeExpedition> estimationTaxeExpedition;
@OneToMany(mappedBy = "estimation")
private List<EstimationProduit> estimationProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Client client;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
@ManyToOne(fetch = FetchType.LAZY)
private Devis devis;
@ManyToOne(fetch = FetchType.LAZY)
private NiveauPrix niveauPrix;
public Estimation() {
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
public StatutEstimationEnum getStatut() {
return statut;
}
public void setStatut(StatutEstimationEnum value) {
this.statut = value;
}
public Facture getFacture() {
return facture;
}
public void setFacture(Facture value) {
this.facture = value;
}
public List<EstimationTaxe> getEstimationTaxe() {
return estimationTaxe;
}
public void setEstimationTaxe(List<EstimationTaxe> value) {
this.estimationTaxe = value;
}
public List<EstimationTaxeExpedition> getEstimationTaxeExpedition() {
return estimationTaxeExpedition;
}
public void setEstimationTaxeExpedition(List<EstimationTaxeExpedition> value) {
this.estimationTaxeExpedition = value;
}
public List<EstimationProduit> getEstimationProduit() {
return estimationProduit;
}
public void setEstimationProduit(List<EstimationProduit> value) {
this.estimationProduit = value;
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
if (object instanceof Estimation estimation) {
return estimation.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}