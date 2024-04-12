package org.sir.erplain.bean.core.inventaire.livraison;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Taxe' and 'Livraison'
*/
@Entity
@Table(name="livraisontaxeexpedition")
public class LivraisonTaxeExpedition {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Livraison livraison;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public LivraisonTaxeExpedition() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Livraison getLivraison() {
return livraison;
}
public void setLivraison(Livraison value) {
this.livraison = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof LivraisonTaxeExpedition livraisonTaxeExpedition) {
return livraisonTaxeExpedition.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}