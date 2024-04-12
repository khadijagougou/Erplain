package org.sir.erplain.ws.converter.produit;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.ws.dto.produit.ProduitDto;
import org.sir.erplain.ws.converter.inventaire.NiveauStockConverter;
import org.sir.erplain.ws.converter.contacts.FournisseurConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProduitConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauStockConverter niveauStockConverter;
@Autowired private FournisseurConverter fournisseurConverter;
@Autowired private ProduitTaxeConverter produitTaxeConverter;
private boolean niveauStock = true;
private boolean produitTaxe = true;
private boolean fournisseur = true;
private boolean entreprise = true;
protected void configure(boolean value) {
this.entrepriseConverter.setProduits(value);
this.fournisseurConverter.setProduits(value);
this.produitTaxeConverter.setProduit(value);
}
public final ProduitDto toDto(Produit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Produit toItem(ProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Produit> toItem(List<ProduitDto> dtos) {
if (dtos == null) return null;
List<Produit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<ProduitDto> toDto(List<Produit> items) {
if (items == null) return null;
List<ProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Produit convertToItem(ProduitDto dto) {
var item = new Produit();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setSku(dto.getSku());
item.setBarcode(dto.getBarcode());
item.setCoutInitial(dto.getCoutInitial());
item.setQuantiteMinimumCommandeClient(dto.getQuantiteMinimumCommandeClient());
item.setNiveauStockInitial(dto.getNiveauStockInitial());
item.setEmplacementDeBac(dto.getEmplacementDeBac());
item.setPointCommande(dto.getPointCommande());
item.setPrixGros(dto.getPrixGros());
item.setPrixDetailRecommande(dto.getPrixDetailRecommande());
item.setPrixAchat(dto.getPrixAchat());
item.setNiveauStock(niveauStockConverter.toItem(dto.getNiveauStock()));
item.setProduitTaxe(produitTaxeConverter.toItem(dto.getProduitTaxe()));
item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
return item;
}
protected ProduitDto convertToDto(Produit item) {
var dto = new ProduitDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setSku(item.getSku());
dto.setBarcode(item.getBarcode());
dto.setCoutInitial(item.getCoutInitial());
dto.setQuantiteMinimumCommandeClient(item.getQuantiteMinimumCommandeClient());
dto.setNiveauStockInitial(item.getNiveauStockInitial());
dto.setEmplacementDeBac(item.getEmplacementDeBac());
dto.setPointCommande(item.getPointCommande());
dto.setPrixGros(item.getPrixGros());
dto.setPrixDetailRecommande(item.getPrixDetailRecommande());
dto.setPrixAchat(item.getPrixAchat());
dto.setNiveauStock(niveauStock? niveauStockConverter.toDto(item.getNiveauStock()): null);
dto.setProduitTaxe(produitTaxe? produitTaxeConverter.toDto(item.getProduitTaxe()): null);
dto.setFournisseur(fournisseur? fournisseurConverter.toDto(item.getFournisseur()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
return dto;
}
public void setNiveauStock(boolean value) {
this.niveauStock = value;
}
public void setProduitTaxe(boolean value) {
this.produitTaxe = value;
}
public void setFournisseur(boolean value) {
this.fournisseur = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setNiveauStockConverter(NiveauStockConverter value) {
this.niveauStockConverter = value;
}
public NiveauStockConverter getNiveauStockConverter() {
return niveauStockConverter;
}
public void setFournisseurConverter(FournisseurConverter value) {
this.fournisseurConverter = value;
}
public FournisseurConverter getFournisseurConverter() {
return fournisseurConverter;
}
public void setProduitTaxeConverter(ProduitTaxeConverter value) {
this.produitTaxeConverter = value;
}
public ProduitTaxeConverter getProduitTaxeConverter() {
return produitTaxeConverter;
}
}