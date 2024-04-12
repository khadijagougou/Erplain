package org.sir.erplain.bean.core.ventes.estimation;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Estimation' and 'Taxe'
*/
@Entity
@Table(name="estimationtaxe")
public class EstimationTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Estimation estimation;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public EstimationTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Estimation getEstimation() {
return estimation;
}
public void setEstimation(Estimation value) {
this.estimation = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof EstimationTaxe estimationTaxe) {
return estimationTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}