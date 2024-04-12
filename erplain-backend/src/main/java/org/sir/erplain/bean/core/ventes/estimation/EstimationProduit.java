package org.sir.erplain.bean.core.ventes.estimation;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Estimation' and 'Produit'
*/
@Entity
@Table(name="estimationproduit")
public class EstimationProduit {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private double total;
private int quantite;
private double disque;
@ManyToOne(fetch = FetchType.LAZY)
private Estimation estimation;
public EstimationProduit() {
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
public Estimation getEstimation() {
return estimation;
}
public void setEstimation(Estimation value) {
this.estimation = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof EstimationProduit estimationProduit) {
return estimationProduit.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}