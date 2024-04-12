package org.sir.erplain.ws.dto.ventes.remboursement;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemboursementTaxeDto {
private Long id;
private RemboursementDto remboursement;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public RemboursementDto getRemboursement() {
return remboursement;
}
public void setRemboursement(RemboursementDto value) {
this.remboursement = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}