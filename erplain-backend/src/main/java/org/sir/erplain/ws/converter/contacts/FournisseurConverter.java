package org.sir.erplain.ws.converter.contacts;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.ws.dto.contacts.FournisseurDto;
import org.sir.erplain.ws.converter.address.AddressConverter;
import org.sir.erplain.ws.converter.produit.ProduitConverter;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeConverter;
import org.sir.erplain.ws.converter.inventaire.livraison.LivraisonConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class FournisseurConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private AddressConverter addressConverter;
@Autowired private BonCommandeConverter bonCommandeConverter;
@Autowired private LivraisonConverter livraisonConverter;
@Autowired private ProduitConverter produitConverter;
private boolean address = true;
private boolean produits = true;
private boolean bonCommandes = true;
private boolean livraisons = true;
private boolean entreprise = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setFournisseurs(value);
this.niveauPrixConverter.setFournisseurs(value);
this.bonCommandeConverter.setFournisseur(value);
this.livraisonConverter.setFournisseur(value);
this.produitConverter.setFournisseur(value);
}
public final FournisseurDto toDto(Fournisseur item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Fournisseur toItem(FournisseurDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Fournisseur> toItem(List<FournisseurDto> dtos) {
if (dtos == null) return null;
List<Fournisseur> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<FournisseurDto> toDto(List<Fournisseur> items) {
if (items == null) return null;
List<FournisseurDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Fournisseur convertToItem(FournisseurDto dto) {
var item = new Fournisseur();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setCode(dto.getCode());
item.setEmail(dto.getEmail());
item.setSiteweb(dto.getSiteweb());
item.setTelephone(dto.getTelephone());
item.setAddress(addressConverter.toItem(dto.getAddress()));
item.setTaxeNumero(dto.getTaxeNumero());
item.setRabais(dto.getRabais());
item.setLanguePDF(dto.getLanguePDF());
item.setProduits(produitConverter.toItem(dto.getProduits()));
item.setBonCommandes(bonCommandeConverter.toItem(dto.getBonCommandes()));
item.setLivraisons(livraisonConverter.toItem(dto.getLivraisons()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected FournisseurDto convertToDto(Fournisseur item) {
var dto = new FournisseurDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setCode(item.getCode());
dto.setEmail(item.getEmail());
dto.setSiteweb(item.getSiteweb());
dto.setTelephone(item.getTelephone());
dto.setAddress(address? addressConverter.toDto(item.getAddress()): null);
dto.setTaxeNumero(item.getTaxeNumero());
dto.setRabais(item.getRabais());
dto.setLanguePDF(item.getLanguePDF());
dto.setProduits(produits? produitConverter.toDto(item.getProduits()): null);
dto.setBonCommandes(bonCommandes? bonCommandeConverter.toDto(item.getBonCommandes()): null);
dto.setLivraisons(livraisons? livraisonConverter.toDto(item.getLivraisons()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setAddress(boolean value) {
this.address = value;
}
public void setProduits(boolean value) {
this.produits = value;
}
public void setBonCommandes(boolean value) {
this.bonCommandes = value;
}
public void setLivraisons(boolean value) {
this.livraisons = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setNiveauPrix(boolean value) {
this.niveauPrix = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setNiveauPrixConverter(NiveauPrixConverter value) {
this.niveauPrixConverter = value;
}
public NiveauPrixConverter getNiveauPrixConverter() {
return niveauPrixConverter;
}
public void setAddressConverter(AddressConverter value) {
this.addressConverter = value;
}
public AddressConverter getAddressConverter() {
return addressConverter;
}
public void setBonCommandeConverter(BonCommandeConverter value) {
this.bonCommandeConverter = value;
}
public BonCommandeConverter getBonCommandeConverter() {
return bonCommandeConverter;
}
public void setLivraisonConverter(LivraisonConverter value) {
this.livraisonConverter = value;
}
public LivraisonConverter getLivraisonConverter() {
return livraisonConverter;
}
public void setProduitConverter(ProduitConverter value) {
this.produitConverter = value;
}
public ProduitConverter getProduitConverter() {
return produitConverter;
}
}