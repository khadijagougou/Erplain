package org.sir.erplain.ws.dto.produit;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitTaxeDto {
private Long id;
private ProduitDto produit;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public ProduitDto getProduit() {
return produit;
}
public void setProduit(ProduitDto value) {
this.produit = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}