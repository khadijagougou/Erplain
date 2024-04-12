package org.sir.erplain.bean.core.ventes;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="paiement")
public class Paiement {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private LocalDate datePaiement;
private double montantPaye;
@ManyToOne(fetch = FetchType.LAZY)
private MethodePaiement methodePaiement;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
public Paiement() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public LocalDate getDatePaiement() {
return datePaiement;
}
public void setDatePaiement(LocalDate value) {
this.datePaiement = value;
}
public double getMontantPaye() {
return montantPaye;
}
public void setMontantPaye(double value) {
this.montantPaye = value;
}
public MethodePaiement getMethodePaiement() {
return methodePaiement;
}
public void setMethodePaiement(MethodePaiement value) {
this.methodePaiement = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Paiement paiement) {
return paiement.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}