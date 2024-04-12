package org.sir.erplain.bean.core.inventaire.livraison;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Livraison' and 'Produit'
*/
@Entity
@Table(name="livraisonproduit")
public class LivraisonProduit {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private double total;
private int quantite;
private double disque;
@ManyToOne(fetch = FetchType.LAZY)
private Livraison livraison;
public LivraisonProduit() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public double getTotal() {
return total;
}
public void setTotal(double value) {
this.total = value;
}
public int getQuantite() {
return quantite;
}
public void setQuantite(int value) {
this.quantite = value;
}
public double getDisque() {
return disque;
}
public void setDisque(double value) {
this.disque = value;
}
public Livraison getLivraison() {
return livraison;
}
public void setLivraison(Livraison value) {
this.livraison = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof LivraisonProduit livraisonProduit) {
return livraisonProduit.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}