package org.sir.erplain.ws.dto.produit;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.inventaire.NiveauStockDto;
import org.sir.erplain.ws.dto.contacts.FournisseurDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitDto {
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
private NiveauStockDto niveauStock;
private List<ProduitTaxeDto> produitTaxe;
private FournisseurDto fournisseur;
private EntrepriseDto entreprise;
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
public NiveauStockDto getNiveauStock() {
return niveauStock;
}
public void setNiveauStock(NiveauStockDto value) {
this.niveauStock = value;
}
public List<ProduitTaxeDto> getProduitTaxe() {
return produitTaxe;
}
public void setProduitTaxe(List<ProduitTaxeDto> value) {
this.produitTaxe = value;
}
public FournisseurDto getFournisseur() {
return fournisseur;
}
public void setFournisseur(FournisseurDto value) {
this.fournisseur = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
}