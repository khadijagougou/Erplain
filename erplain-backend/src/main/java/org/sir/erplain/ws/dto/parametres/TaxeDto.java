package org.sir.erplain.ws.dto.parametres;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.contacts.ClientTaxeDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureTaxeDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureTaxeExpeditionDto;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeTaxeDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeTaxeExpeditionDto;
import org.sir.erplain.ws.dto.inventaire.livraison.LivraisonTaxeExpeditionDto;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditTaxeDto;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationTaxeExpeditionDto;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeTaxeExpeditionDto;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationTaxeDto;
import org.sir.erplain.ws.dto.produit.ProduitTaxeDto;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementTaxeDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeTaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxeDto {
private Long id;
private String nom;
private double tauxImposition;
private boolean actif;
private List<ClientTaxeDto> clientTaxe;
private List<ProduitTaxeDto> produitTaxe;
private List<EstimationTaxeDto> estimationTaxe;
private List<EstimationTaxeExpeditionDto> estimationTaxeExpedition;
private List<CommandeTaxeDto> commandeTaxe;
private List<CommandeTaxeExpeditionDto> commandeTaxeExpedition;
private List<FactureTaxeDto> factureTaxe;
private List<FactureTaxeExpeditionDto> factureTaxeExpedition;
private List<NoteCreditTaxeDto> noteCreditTaxe;
private List<RemboursementTaxeDto> remboursementTaxe;
private List<BonCommandeTaxeDto> bonCommandeTaxe;
private List<BonCommandeTaxeExpeditionDto> bonCommandeTaxeExpedition;
private List<LivraisonTaxeExpeditionDto> livraisonTaxeExpedition;
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
public double getTauxImposition() {
return tauxImposition;
}
public void setTauxImposition(double value) {
this.tauxImposition = value;
}
public boolean isActif() {
return actif;
}
public void setActif(boolean value) {
this.actif = value;
}
public List<ClientTaxeDto> getClientTaxe() {
return clientTaxe;
}
public void setClientTaxe(List<ClientTaxeDto> value) {
this.clientTaxe = value;
}
public List<ProduitTaxeDto> getProduitTaxe() {
return produitTaxe;
}
public void setProduitTaxe(List<ProduitTaxeDto> value) {
this.produitTaxe = value;
}
public List<EstimationTaxeDto> getEstimationTaxe() {
return estimationTaxe;
}
public void setEstimationTaxe(List<EstimationTaxeDto> value) {
this.estimationTaxe = value;
}
public List<EstimationTaxeExpeditionDto> getEstimationTaxeExpedition() {
return estimationTaxeExpedition;
}
public void setEstimationTaxeExpedition(List<EstimationTaxeExpeditionDto> value) {
this.estimationTaxeExpedition = value;
}
public List<CommandeTaxeDto> getCommandeTaxe() {
return commandeTaxe;
}
public void setCommandeTaxe(List<CommandeTaxeDto> value) {
this.commandeTaxe = value;
}
public List<CommandeTaxeExpeditionDto> getCommandeTaxeExpedition() {
return commandeTaxeExpedition;
}
public void setCommandeTaxeExpedition(List<CommandeTaxeExpeditionDto> value) {
this.commandeTaxeExpedition = value;
}
public List<FactureTaxeDto> getFactureTaxe() {
return factureTaxe;
}
public void setFactureTaxe(List<FactureTaxeDto> value) {
this.factureTaxe = value;
}
public List<FactureTaxeExpeditionDto> getFactureTaxeExpedition() {
return factureTaxeExpedition;
}
public void setFactureTaxeExpedition(List<FactureTaxeExpeditionDto> value) {
this.factureTaxeExpedition = value;
}
public List<NoteCreditTaxeDto> getNoteCreditTaxe() {
return noteCreditTaxe;
}
public void setNoteCreditTaxe(List<NoteCreditTaxeDto> value) {
this.noteCreditTaxe = value;
}
public List<RemboursementTaxeDto> getRemboursementTaxe() {
return remboursementTaxe;
}
public void setRemboursementTaxe(List<RemboursementTaxeDto> value) {
this.remboursementTaxe = value;
}
public List<BonCommandeTaxeDto> getBonCommandeTaxe() {
return bonCommandeTaxe;
}
public void setBonCommandeTaxe(List<BonCommandeTaxeDto> value) {
this.bonCommandeTaxe = value;
}
public List<BonCommandeTaxeExpeditionDto> getBonCommandeTaxeExpedition() {
return bonCommandeTaxeExpedition;
}
public void setBonCommandeTaxeExpedition(List<BonCommandeTaxeExpeditionDto> value) {
this.bonCommandeTaxeExpedition = value;
}
public List<LivraisonTaxeExpeditionDto> getLivraisonTaxeExpedition() {
return livraisonTaxeExpedition;
}
public void setLivraisonTaxeExpedition(List<LivraisonTaxeExpeditionDto> value) {
this.livraisonTaxeExpedition = value;
}
}