package org.sir.erplain.bean.core.produit;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="produit")
public class Produit {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String sku;
private String barcode;
private double coutInitial;
private int quantiteMinimumCommandeClient;
private int niveauStockInitial;
private String emplacementDeBac;
private int pointCommande;
private double prixGros;
private double prixDetailRecommande;
private double prixAchat;
@OneToOne()
private NiveauStock niveauStock;
@OneToMany(mappedBy = "produit")
private List<ProduitTaxe> produitTaxe;
@ManyToOne(fetch = FetchType.LAZY)
private Fournisseur fournisseur;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
public Produit() {
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
public String getSku() {
return sku;
}
public void setSku(String value) {
this.sku = value;
}
public String getBarcode() {
return barcode;
}
public void setBarcode(String value) {
this.barcode = value;
}
public double getCoutInitial() {
return coutInitial;
}
public void setCoutInitial(double value) {
this.coutInitial = value;
}
public int getQuantiteMinimumCommandeClient() {
return quantiteMinimumCommandeClient;
}
public void setQuantiteMinimumCommandeClient(int value) {
this.quantiteMinimumCommandeClient = value;
}
public int getNiveauStockInitial() {
return niveauStockInitial;
}
public void setNiveauStockInitial(int value) {
this.niveauStockInitial = value;
}
public String getEmplacementDeBac() {
return emplacementDeBac;
}
public void setEmplacementDeBac(String value) {
this.emplacementDeBac = value;
}
public int getPointCommande() {
return pointCommande;
}
public void setPointCommande(int value) {
this.pointCommande = value;
}
public double getPrixGros() {
return prixGros;
}
public void setPrixGros(double value) {
this.prixGros = value;
}
public double getPrixDetailRecommande() {
return prixDetailRecommande;
}
public void setPrixDetailRecommande(double value) {
this.prixDetailRecommande = value;
}
public double getPrixAchat() {
return prixAchat;
}
public void setPrixAchat(double value) {
this.prixAchat = value;
}
public NiveauStock getNiveauStock() {
return niveauStock;
}
public void setNiveauStock(NiveauStock value) {
this.niveauStock = value;
}
public List<ProduitTaxe> getProduitTaxe() {
return produitTaxe;
}
public void setProduitTaxe(List<ProduitTaxe> value) {
this.produitTaxe = value;
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
if (object instanceof Produit produit) {
return produit.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}