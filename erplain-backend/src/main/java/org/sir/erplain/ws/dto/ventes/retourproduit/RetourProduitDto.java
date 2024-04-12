package org.sir.erplain.ws.dto.ventes.retourproduit;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementDto;
import org.sir.erplain.ws.dto.contacts.ClientDto;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import org.sir.erplain.ws.dto.ventes.facture.FactureDto;
import org.sir.erplain.bean.enums.StatutRetourProduitEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetourProduitDto {
private Long id;
private String code;
private List<NoteCreditDto> noteCredit;
private List<RemboursementDto> remboursements;
private StatutRetourProduitEnum statut;
private List<RetourProduitProduitDto> retourProduitProduit;
private ClientDto client;
private FactureDto facture;
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
public List<NoteCreditDto> getNoteCredit() {
return noteCredit;
}
public void setNoteCredit(List<NoteCreditDto> value) {
this.noteCredit = value;
}
public List<RemboursementDto> getRemboursements() {
return remboursements;
}
public void setRemboursements(List<RemboursementDto> value) {
this.remboursements = value;
}
public StatutRetourProduitEnum getStatut() {
return statut;
}
public void setStatut(StatutRetourProduitEnum value) {
this.statut = value;
}
public List<RetourProduitProduitDto> getRetourProduitProduit() {
return retourProduitProduit;
}
public void setRetourProduitProduit(List<RetourProduitProduitDto> value) {
this.retourProduitProduit = value;
}
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
public FactureDto getFacture() {
return facture;
}
public void setFacture(FactureDto value) {
this.facture = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
}