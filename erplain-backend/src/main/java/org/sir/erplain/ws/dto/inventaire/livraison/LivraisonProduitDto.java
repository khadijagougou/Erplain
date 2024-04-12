package org.sir.erplain.ws.dto.inventaire.livraison;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LivraisonProduitDto {
private Long id;
private double total;
private int quantite;
private double disque;
private LivraisonDto livraison;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public double getTotal() {
return total;
}
public void setTotal(double value) {
this.total = value;
}
public int getQuantite() {
return quantite;
}
public void setQuantite(int value) {
this.quantite = value;
}
public double getDisque() {
return disque;
}
public void setDisque(double value) {
this.disque = value;
}
public LivraisonDto getLivraison() {
return livraison;
}
public void setLivraison(LivraisonDto value) {
this.livraison = value;
}
}