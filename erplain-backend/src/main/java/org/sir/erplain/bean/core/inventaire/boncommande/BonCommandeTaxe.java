package org.sir.erplain.bean.core.inventaire.boncommande;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Taxe' and 'BonCommande'
*/
@Entity
@Table(name="boncommandetaxe")
public class BonCommandeTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private BonCommande bonCommande;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public BonCommandeTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public BonCommande getBonCommande() {
return bonCommande;
}
public void setBonCommande(BonCommande value) {
this.bonCommande = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof BonCommandeTaxe bonCommandeTaxe) {
return bonCommandeTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}