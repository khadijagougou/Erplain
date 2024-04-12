package org.sir.erplain.bean.core.ventes.commande;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Commande' and 'Taxe'
*/
@Entity
@Table(name="commandetaxe")
public class CommandeTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Commande commande;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public CommandeTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Commande getCommande() {
return commande;
}
public void setCommande(Commande value) {
this.commande = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof CommandeTaxe commandeTaxe) {
return commandeTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}