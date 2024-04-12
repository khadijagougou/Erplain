package org.sir.erplain.ws.dto.ventes.facture;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.parametres.NiveauPrixDto;
import org.sir.erplain.ws.dto.ventes.PaiementDto;
import org.sir.erplain.ws.dto.parametres.DevisDto;
import org.sir.erplain.ws.dto.ventes.retourproduit.RetourProduitDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.bean.enums.TypeRabaisEnum;
import org.sir.erplain.bean.enums.StatutFactureEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactureDto {
private Long id;
private String code;
private LocalDate dateExperation;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private float rabais;
private TypeRabaisEnum typeRabais;
private int totalUnites;
private double remiseGlobal;
private double sousTotal;
private double total;
private StatutFactureEnum statut;
private PaiementDto paiement;
private List<RetourProduitDto> retourProduit;
private List<FactureTaxeDto> factureTaxe;
private List<FactureTaxeExpeditionDto> factureTaxeExpedition;
private List<FactureProduitDto> factureProduit;
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
public int getTotalUnites() {
return totalUnites;
}
public void setTotalUnites(int value) {
this.totalUnites = value;
}
public double getRemiseGlobal() {
return remiseGlobal;
}
public void setRemiseGlobal(double value) {
this.remiseGlobal = value;
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
public StatutFactureEnum getStatut() {
return statut;
}
public void setStatut(StatutFactureEnum value) {
this.statut = value;
}
public PaiementDto getPaiement() {
return paiement;
}
public void setPaiement(PaiementDto value) {
this.paiement = value;
}
public List<RetourProduitDto> getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(List<RetourProduitDto> value) {
this.retourProduit = value;
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
public List<FactureProduitDto> getFactureProduit() {
return factureProduit;
}
public void setFactureProduit(List<FactureProduitDto> value) {
this.factureProduit = value;
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