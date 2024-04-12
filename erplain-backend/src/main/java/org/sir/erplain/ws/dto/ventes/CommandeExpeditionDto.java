package org.sir.erplain.ws.dto.ventes;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeDto;
import org.sir.erplain.bean.enums.StatutCommandeExpeditionEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandeExpeditionDto {
private Long id;
private String code;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private StatutCommandeExpeditionEnum statut;
private CommandeDto commande;
private EntrepriseDto entreprise;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public LocalDate getDateCreation() {
return dateCreation;
}
public void setDateCreation(LocalDate value) {
this.dateCreation = value;
}
public LocalDate getDateExpedition() {
return dateExpedition;
}
public void setDateExpedition(LocalDate value) {
this.dateExpedition = value;
}
public StatutCommandeExpeditionEnum getStatut() {
return statut;
}
public void setStatut(StatutCommandeExpeditionEnum value) {
this.statut = value;
}
public CommandeDto getCommande() {
return commande;
}
public void setCommande(CommandeDto value) {
this.commande = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
}