package org.sir.erplain.ws.dto.ventes;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.parametres.MethodePaiementDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementDto {
private Long id;
private LocalDate datePaiement;
private double montantPaye;
private MethodePaiementDto methodePaiement;
private EntrepriseDto entreprise;
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
public MethodePaiementDto getMethodePaiement() {
return methodePaiement;
}
public void setMethodePaiement(MethodePaiementDto value) {
this.methodePaiement = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
}