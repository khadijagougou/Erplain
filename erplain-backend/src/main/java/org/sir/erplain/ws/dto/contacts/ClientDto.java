package org.sir.erplain.ws.dto.contacts;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.parametres.NiveauPrixDto;
import org.sir.erplain.ws.dto.parametres.DevisDto;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.sir.erplain.ws.dto.address.AddressDto;
import org.sir.erplain.ws.dto.ventes.retourproduit.RetourProduitDto;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationDto;
import org.sir.erplain.ws.dto.ventes.commande.CommandeDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import org.sir.erplain.bean.enums.LangueEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
private Long id;
private String nom;
private String code;
private String email;
private String siteweb;
private String telephone;
private int taxeNumero;
private float rabais;
private LangueEnum languePDF;
private int valeurCommandeMinimale;
private AddressDto address;
private List<EstimationDto> estimations;
private List<CommandeDto> commandes;
private List<FactureDto> factures;
private List<RetourProduitDto> retourProduits;
private List<NoteCreditDto> notesCredit;
private List<RemboursementDto> remboursements;
private List<ClientTaxeDto> clientTaxe;
private EntrepriseDto entreprise;
private DevisDto devis;
private NiveauPrixDto niveauPrix;
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
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public String getEmail() {
return email;
}
public void setEmail(String value) {
this.email = value;
}
public String getSiteweb() {
return siteweb;
}
public void setSiteweb(String value) {
this.siteweb = value;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String value) {
this.telephone = value;
}
public int getTaxeNumero() {
return taxeNumero;
}
public void setTaxeNumero(int value) {
this.taxeNumero = value;
}
public float getRabais() {
return rabais;
}
public void setRabais(float value) {
this.rabais = value;
}
public LangueEnum getLanguePDF() {
return languePDF;
}
public void setLanguePDF(LangueEnum value) {
this.languePDF = value;
}
public int getValeurCommandeMinimale() {
return valeurCommandeMinimale;
}
public void setValeurCommandeMinimale(int value) {
this.valeurCommandeMinimale = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
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
public List<RetourProduitDto> getRetourProduits() {
return retourProduits;
}
public void setRetourProduits(List<RetourProduitDto> value) {
this.retourProduits = value;
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
public List<ClientTaxeDto> getClientTaxe() {
return clientTaxe;
}
public void setClientTaxe(List<ClientTaxeDto> value) {
this.clientTaxe = value;
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