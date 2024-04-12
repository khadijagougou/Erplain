package org.sir.erplain.bean.core.ventes.facture;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Taxe' and 'Facture'
*/
@Entity
@Table(name="facturetaxe")
public class FactureTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Facture facture;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public FactureTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Facture getFacture() {
return facture;
}
public void setFacture(Facture value) {
this.facture = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof FactureTaxe factureTaxe) {
return factureTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}