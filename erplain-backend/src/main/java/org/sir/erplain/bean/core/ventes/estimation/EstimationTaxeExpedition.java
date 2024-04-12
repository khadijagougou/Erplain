package org.sir.erplain.bean.core.ventes.estimation;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Estimation' and 'Taxe'
*/
@Entity
@Table(name="estimationtaxeexpedition")
public class EstimationTaxeExpedition {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Estimation estimation;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public EstimationTaxeExpedition() {
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
if (object instanceof EstimationTaxeExpedition estimationTaxeExpedition) {
return estimationTaxeExpedition.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}