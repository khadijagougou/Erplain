package org.sir.erplain.ws.dto.ventes.retourproduit;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetourProduitProduitDto {
private Long id;
private int quantite;
private float cout;
private RetourProduitDto retourProduit;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public int getQuantite() {
return quantite;
}
public void setQuantite(int value) {
this.quantite = value;
}
public float getCout() {
return cout;
}
public void setCout(float value) {
this.cout = value;
}
public RetourProduitDto getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(RetourProduitDto value) {
this.retourProduit = value;
}
}