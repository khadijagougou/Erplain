package org.sir.erplain.ws.dto.inventaire.livraison;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LivraisonTaxeExpeditionDto {
private Long id;
private LivraisonDto livraison;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public LivraisonDto getLivraison() {
return livraison;
}
public void setLivraison(LivraisonDto value) {
this.livraison = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}