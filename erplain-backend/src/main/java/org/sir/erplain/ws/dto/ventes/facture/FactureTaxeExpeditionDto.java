package org.sir.erplain.ws.dto.ventes.facture;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactureTaxeExpeditionDto {
private Long id;
private FactureDto facture;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public FactureDto getFacture() {
return facture;
}
public void setFacture(FactureDto value) {
this.facture = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}