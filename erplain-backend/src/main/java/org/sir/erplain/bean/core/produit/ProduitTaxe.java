package org.sir.erplain.bean.core.produit;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Taxe' and 'Produit'
*/
@Entity
@Table(name="produittaxe")
public class ProduitTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Produit produit;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public ProduitTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Produit getProduit() {
return produit;
}
public void setProduit(Produit value) {
this.produit = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof ProduitTaxe produitTaxe) {
return produitTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}