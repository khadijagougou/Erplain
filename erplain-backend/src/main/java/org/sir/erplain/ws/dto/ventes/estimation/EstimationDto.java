package org.sir.erplain.ws.dto.ventes.estimation;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.parametres.NiveauPrixDto;
import org.sir.erplain.ws.dto.parametres.DevisDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import org.sir.erplain.bean.enums.TypeRabaisEnum;
import org.sir.erplain.bean.enums.StatutEstimationEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstimationDto {
private Long id;
private String code;
private LocalDate dateExperation;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private float rabais;
private TypeRabaisEnum typeRabais;
private double remiseGlobal;
private int totalUnites;
private double sousTotal;
private double total;
private StatutEstimationEnum statut;
private FactureDto facture;
private List<EstimationTaxeDto> estimationTaxe;
private List<EstimationTaxeExpeditionDto> estimationTaxeExpedition;
private List<EstimationProduitDto> estimationProduit;
private ClientDto client;
private EntrepriseDto entreprise;
private DevisDto devis;
private NiveauPrixDto niveauPrix;
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
public LocalDate getDateExperation() {
return dateExperation;
}
public void setDateExperation(LocalDate value) {
this.dateExperation = value;
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
public float getRabais() {
return rabais;
}
public void setRabais(float value) {
this.rabais = value;
}
public TypeRabaisEnum getTypeRabais() {
return typeRabais;
}
public void setTypeRabais(TypeRabaisEnum value) {
this.typeRabais = value;
}
public double getRemiseGlobal() {
return remiseGlobal;
}
public void setRemiseGlobal(double value) {
this.remiseGlobal = value;
}
public int getTotalUnites() {
return totalUnites;
}
public void setTotalUnites(int value) {
this.totalUnites = value;
}
public double getSousTotal() {
return sousTotal;
}
public void setSousTotal(double value) {
this.sousTotal = value;
}
public double getTotal() {
return total;
}
public void setTotal(double value) {
this.total = value;
}
public StatutEstimationEnum getStatut() {
return statut;
}
public void setStatut(StatutEstimationEnum value) {
this.statut = value;
}
public FactureDto getFacture() {
return facture;
}
public void setFacture(FactureDto value) {
this.facture = value;
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
public List<EstimationProduitDto> getEstimationProduit() {
return estimationProduit;
}
public void setEstimationProduit(List<EstimationProduitDto> value) {
this.estimationProduit = value;
}
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
public DevisDto getDevis() {
return devis;
}
public void setDevis(DevisDto value) {
this.devis = value;
}
public NiveauPrixDto getNiveauPrix() {
return niveauPrix;
}
public void setNiveauPrix(NiveauPrixDto value) {
this.niveauPrix = value;
}
}