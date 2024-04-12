package org.sir.erplain.ws.dto.inventaire.boncommande;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BonCommandeTaxeDto {
private Long id;
private BonCommandeDto bonCommande;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public BonCommandeDto getBonCommande() {
return bonCommande;
}
public void setBonCommande(BonCommandeDto value) {
this.bonCommande = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}