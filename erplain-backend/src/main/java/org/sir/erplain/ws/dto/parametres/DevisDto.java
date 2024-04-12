package org.sir.erplain.ws.dto.parametres;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevisDto {
private Long id;
private List<ClientDto> clients;
private List<EstimationDto> estimations;
private List<CommandeDto> commandes;
private List<FactureDto> factures;
private List<NoteCreditDto> notesCredit;
private List<RemboursementDto> remboursements;
private List<BonCommandeDto> bonCommandes;
private NouvelleDeviseDto nouvelleDevise;
private double tauxDeChange;
private boolean defaut;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public List<ClientDto> getClients() {
return clients;
}
public void setClients(List<ClientDto> value) {
this.clients = value;
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
public NouvelleDeviseDto getNouvelleDevise() {
return nouvelleDevise;
}
public void setNouvelleDevise(NouvelleDeviseDto value) {
this.nouvelleDevise = value;
}
public double getTauxDeChange() {
return tauxDeChange;
}
public void setTauxDeChange(double value) {
this.tauxDeChange = value;
}
public boolean isDefaut() {
return defaut;
}
public void setDefaut(boolean value) {
this.defaut = value;
}
}