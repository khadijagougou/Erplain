package org.sir.erplain.ws.dto.contacts;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.parametres.NiveauPrixDto;
import org.sir.erplain.ws.dto.address.AddressDto;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeDto;
import org.sir.erplain.ws.dto.inventaire.livraison.LivraisonDto;
import org.sir.erplain.ws.dto.produit.ProduitDto;
import org.sir.erplain.bean.enums.LangueEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FournisseurDto {
private Long id;
private String nom;
private String code;
private String email;
private String siteweb;
private String telephone;
private AddressDto address;
private int taxeNumero;
private float rabais;
private LangueEnum languePDF;
private List<ProduitDto> produits;
private List<BonCommandeDto> bonCommandes;
private List<LivraisonDto> livraisons;
private EntrepriseDto entreprise;
private NiveauPrixDto niveauPrix;
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
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public String getEmail() {
return email;
}
public void setEmail(String value) {
this.email = value;
}
public String getSiteweb() {
return siteweb;
}
public void setSiteweb(String value) {
this.siteweb = value;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String value) {
this.telephone = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
}
public int getTaxeNumero() {
return taxeNumero;
}
public void setTaxeNumero(int value) {
this.taxeNumero = value;
}
public float getRabais() {
return rabais;
}
public void setRabais(float value) {
this.rabais = value;
}
public LangueEnum getLanguePDF() {
return languePDF;
}
public void setLanguePDF(LangueEnum value) {
this.languePDF = value;
}
public List<ProduitDto> getProduits() {
return produits;
}
public void setProduits(List<ProduitDto> value) {
this.produits = value;
}
public List<BonCommandeDto> getBonCommandes() {
return bonCommandes;
}
public void setBonCommandes(List<BonCommandeDto> value) {
this.bonCommandes = value;
}
public List<LivraisonDto> getLivraisons() {
return livraisons;
}
public void setLivraisons(List<LivraisonDto> value) {
this.livraisons = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
public NiveauPrixDto getNiveauPrix() {
return niveauPrix;
}
public void setNiveauPrix(NiveauPrixDto value) {
this.niveauPrix = value;
}
}