package org.sir.erplain.bean.core.ventes.remboursement;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Remboursement' and 'Taxe'
*/
@Entity
@Table(name="remboursementtaxe")
public class RemboursementTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Remboursement remboursement;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public RemboursementTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Remboursement getRemboursement() {
return remboursement;
}
public void setRemboursement(Remboursement value) {
this.remboursement = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof RemboursementTaxe remboursementTaxe) {
return remboursementTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}