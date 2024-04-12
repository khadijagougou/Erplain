package org.sir.erplain.ws.dto.ventes.estimation;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstimationTaxeExpeditionDto {
private Long id;
private EstimationDto estimation;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public EstimationDto getEstimation() {
return estimation;
}
public void setEstimation(EstimationDto value) {
this.estimation = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}