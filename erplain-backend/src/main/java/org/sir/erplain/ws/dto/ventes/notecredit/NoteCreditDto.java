package org.sir.erplain.ws.dto.ventes.notecredit;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.parametres.NiveauPrixDto;
import org.sir.erplain.ws.dto.parametres.DevisDto;
import org.sir.erplain.ws.dto.ventes.retourproduit.RetourProduitDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.bean.enums.StatutNoteCreditEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteCreditDto {
private Long id;
private String code;
private LocalDate dateExperation;
private LocalDate dateCreation;
private LocalDate dateExpedition;
private int totalUnites;
private double remiseGlobal;
private double sousTotal;
private double total;
private StatutNoteCreditEnum statut;
private List<NoteCreditTaxeDto> noteCreditTaxe;
private List<NoteCreditProduitDto> noteCreditProduit;
private ClientDto client;
private RetourProduitDto retourProduit;
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
public StatutNoteCreditEnum getStatut() {
return statut;
}
public void setStatut(StatutNoteCreditEnum value) {
this.statut = value;
}
public List<NoteCreditTaxeDto> getNoteCreditTaxe() {
return noteCreditTaxe;
}
public void setNoteCreditTaxe(List<NoteCreditTaxeDto> value) {
this.noteCreditTaxe = value;
}
public List<NoteCreditProduitDto> getNoteCreditProduit() {
return noteCreditProduit;
}
public void setNoteCreditProduit(List<NoteCreditProduitDto> value) {
this.noteCreditProduit = value;
}
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
public RetourProduitDto getRetourProduit() {
return retourProduit;
}
public void setRetourProduit(RetourProduitDto value) {
this.retourProduit = value;
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