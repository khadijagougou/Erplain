package org.sir.erplain.ws.dto.parametres;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.contacts.FournisseurDto;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import org.sir.erplain.bean.enums.StatutNiveauPrixEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NiveauPrixDto {
private Long id;
private String nom;
private StatutNiveauPrixEnum type;
private boolean actif;
private List<ClientDto> clients;
private List<FournisseurDto> fournisseurs;
private List<EstimationDto> estimations;
private List<CommandeDto> commandes;
private List<FactureDto> factures;
private List<NoteCreditDto> notesCredit;
private List<RemboursementDto> remboursements;
private List<BonCommandeDto> bonCommandes;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getNom() {
return nom;
}
public void setNom(String value) {
this.nom = value;
}
public StatutNiveauPrixEnum getType() {
return type;
}
public void setType(StatutNiveauPrixEnum value) {
this.type = value;
}
public boolean isActif() {
return actif;
}
public void setActif(boolean value) {
this.actif = value;
}
public List<ClientDto> getClients() {
return clients;
}
public void setClients(List<ClientDto> value) {
this.clients = value;
}
public List<FournisseurDto> getFournisseurs() {
return fournisseurs;
}
public void setFournisseurs(List<FournisseurDto> value) {
this.fournisseurs = value;
}
public List<EstimationDto> getEstimations() {
return estimations;
}
public void setEstimations(List<EstimationDto> value) {
this.estimations = value;
}
public List<CommandeDto> getCommandes() {
return commandes;
}
public void setCommandes(List<CommandeDto> value) {
this.commandes = value;
}
public List<FactureDto> getFactures() {
return factures;
}
public void setFactures(List<FactureDto> value) {
this.factures = value;
}
public List<NoteCreditDto> getNotesCredit() {
return notesCredit;
}
public void setNotesCredit(List<NoteCreditDto> value) {
this.notesCredit = value;
}
public List<RemboursementDto> getRemboursements() {
return remboursements;
}
public void setRemboursements(List<RemboursementDto> value) {
this.remboursements = value;
}
public List<BonCommandeDto> getBonCommandes() {
return bonCommandes;
}
public void setBonCommandes(List<BonCommandeDto> value) {
this.bonCommandes = value;
}
}