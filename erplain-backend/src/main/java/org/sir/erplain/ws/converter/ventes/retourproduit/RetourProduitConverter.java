package org.sir.erplain.ws.converter.ventes.retourproduit;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.ws.dto.ventes.retourproduit.RetourProduitDto;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditConverter;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementConverter;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.ventes.facture.FactureConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class RetourProduitConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private RemboursementConverter remboursementConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private RetourProduitProduitConverter retourProduitProduitConverter;
@Autowired private NoteCreditConverter noteCreditConverter;
@Autowired private FactureConverter factureConverter;
private boolean noteCredit = true;
private boolean remboursements = true;
private boolean retourProduitProduit = true;
private boolean client = true;
private boolean facture = true;
private boolean entreprise = true;
protected void configure(boolean value) {
this.entrepriseConverter.setRetourProduit(value);
this.remboursementConverter.setRetourProduit(value);
this.clientConverter.setRetourProduits(value);
this.retourProduitProduitConverter.setRetourProduit(value);
this.noteCreditConverter.setRetourProduit(value);
this.factureConverter.setRetourProduit(value);
}
public final RetourProduitDto toDto(RetourProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final RetourProduit toItem(RetourProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<RetourProduit> toItem(List<RetourProduitDto> dtos) {
if (dtos == null) return null;
List<RetourProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<RetourProduitDto> toDto(List<RetourProduit> items) {
if (items == null) return null;
List<RetourProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected RetourProduit convertToItem(RetourProduitDto dto) {
var item = new RetourProduit();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setNoteCredit(noteCreditConverter.toItem(dto.getNoteCredit()));
item.setRemboursements(remboursementConverter.toItem(dto.getRemboursements()));
item.setStatut(dto.getStatut());
item.setRetourProduitProduit(retourProduitProduitConverter.toItem(dto.getRetourProduitProduit()));
item.setClient(clientConverter.toItem(dto.getClient()));
item.setFacture(factureConverter.toItem(dto.getFacture()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
return item;
}
protected RetourProduitDto convertToDto(RetourProduit item) {
var dto = new RetourProduitDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setNoteCredit(noteCredit? noteCreditConverter.toDto(item.getNoteCredit()): null);
dto.setRemboursements(remboursements? remboursementConverter.toDto(item.getRemboursements()): null);
dto.setStatut(item.getStatut());
dto.setRetourProduitProduit(retourProduitProduit? retourProduitProduitConverter.toDto(item.getRetourProduitProduit()): null);
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setFacture(facture? factureConverter.toDto(item.getFacture()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
return dto;
}
public void setNoteCredit(boolean value) {
this.noteCredit = value;
}
public void setRemboursements(boolean value) {
this.remboursements = value;
}
public void setRetourProduitProduit(boolean value) {
this.retourProduitProduit = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setFacture(boolean value) {
this.facture = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setRemboursementConverter(RemboursementConverter value) {
this.remboursementConverter = value;
}
public RemboursementConverter getRemboursementConverter() {
return remboursementConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setRetourProduitProduitConverter(RetourProduitProduitConverter value) {
this.retourProduitProduitConverter = value;
}
public RetourProduitProduitConverter getRetourProduitProduitConverter() {
return retourProduitProduitConverter;
}
public void setNoteCreditConverter(NoteCreditConverter value) {
this.noteCreditConverter = value;
}
public NoteCreditConverter getNoteCreditConverter() {
return noteCreditConverter;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
}