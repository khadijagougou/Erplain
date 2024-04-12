package org.sir.erplain.bean.core.contacts;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.bean.enums.LangueEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="fournisseur")
public class Fournisseur {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String code;
private String email;
private String siteweb;
private String telephone;
@OneToOne()
private Address address;
private int taxeNumero;
private float rabais;
@Enumerated(EnumType.STRING)
private LangueEnum languePDF;
@OneToMany(mappedBy = "fournisseur")
private List<Produit> produits;
@OneToMany(mappedBy = "fournisseur")
private List<BonCommande> bonCommandes;
@OneToMany(mappedBy = "fournisseur")
private List<Livraison> livraisons;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
@ManyToOne(fetch = FetchType.LAZY)
private NiveauPrix niveauPrix;
public Fournisseur() {
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
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
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
public List<Produit> getProduits() {
return produits;
}
public void setProduits(List<Produit> value) {
this.produits = value;
}
public List<BonCommande> getBonCommandes() {
return bonCommandes;
}
public void setBonCommandes(List<BonCommande> value) {
this.bonCommandes = value;
}
public List<Livraison> getLivraisons() {
return livraisons;
}
public void setLivraisons(List<Livraison> value) {
this.livraisons = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
public NiveauPrix getNiveauPrix() {
return niveauPrix;
}
public void setNiveauPrix(NiveauPrix value) {
this.niveauPrix = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Fournisseur fournisseur) {
return fournisseur.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}