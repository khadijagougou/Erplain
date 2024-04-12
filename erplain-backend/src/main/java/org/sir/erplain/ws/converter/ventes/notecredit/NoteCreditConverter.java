package org.sir.erplain.ws.converter.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditDto;
import org.sir.erplain.ws.converter.contacts.ClientConverter;
import org.sir.erplain.ws.converter.ventes.retourproduit.RetourProduitConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class NoteCreditConverter {
@Autowired private NoteCreditProduitConverter noteCreditProduitConverter;
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private RetourProduitConverter retourProduitConverter;
@Autowired private ClientConverter clientConverter;
@Autowired private NoteCreditTaxeConverter noteCreditTaxeConverter;
private boolean noteCreditTaxe = true;
private boolean noteCreditProduit = true;
private boolean client = true;
private boolean retourProduit = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.noteCreditProduitConverter.setNoteCredit(value);
this.entrepriseConverter.setNoteCredit(value);
this.niveauPrixConverter.setNotesCredit(value);
this.devisConverter.setNotesCredit(value);
this.retourProduitConverter.setNoteCredit(value);
this.clientConverter.setNotesCredit(value);
this.noteCreditTaxeConverter.setNoteCredit(value);
}
public final NoteCreditDto toDto(NoteCredit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final NoteCredit toItem(NoteCreditDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<NoteCredit> toItem(List<NoteCreditDto> dtos) {
if (dtos == null) return null;
List<NoteCredit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<NoteCreditDto> toDto(List<NoteCredit> items) {
if (items == null) return null;
List<NoteCreditDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected NoteCredit convertToItem(NoteCreditDto dto) {
var item = new NoteCredit();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateExperation(dto.getDateExperation());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setTotalUnites(dto.getTotalUnites());
item.setRemiseGlobal(dto.getRemiseGlobal());
item.setSousTotal(dto.getSousTotal());
item.setTotal(dto.getTotal());
item.setStatut(dto.getStatut());
item.setNoteCreditTaxe(noteCreditTaxeConverter.toItem(dto.getNoteCreditTaxe()));
item.setNoteCreditProduit(noteCreditProduitConverter.toItem(dto.getNoteCreditProduit()));
item.setClient(clientConverter.toItem(dto.getClient()));
item.setRetourProduit(retourProduitConverter.toItem(dto.getRetourProduit()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected NoteCreditDto convertToDto(NoteCredit item) {
var dto = new NoteCreditDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateExperation(item.getDateExperation());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setTotalUnites(item.getTotalUnites());
dto.setRemiseGlobal(item.getRemiseGlobal());
dto.setSousTotal(item.getSousTotal());
dto.setTotal(item.getTotal());
dto.setStatut(item.getStatut());
dto.setNoteCreditTaxe(noteCreditTaxe? noteCreditTaxeConverter.toDto(item.getNoteCreditTaxe()): null);
dto.setNoteCreditProduit(noteCreditProduit? noteCreditProduitConverter.toDto(item.getNoteCreditProduit()): null);
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setRetourProduit(retourProduit? retourProduitConverter.toDto(item.getRetourProduit()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setNoteCreditTaxe(boolean value) {
this.noteCreditTaxe = value;
}
public void setNoteCreditProduit(boolean value) {
this.noteCreditProduit = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setRetourProduit(boolean value) {
this.retourProduit = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setDevis(boolean value) {
this.devis = value;
}
public void setNiveauPrix(boolean value) {
this.niveauPrix = value;
}
public void setNoteCreditProduitConverter(NoteCreditProduitConverter value) {
this.noteCreditProduitConverter = value;
}
public NoteCreditProduitConverter getNoteCreditProduitConverter() {
return noteCreditProduitConverter;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setNiveauPrixConverter(NiveauPrixConverter value) {
this.niveauPrixConverter = value;
}
public NiveauPrixConverter getNiveauPrixConverter() {
return niveauPrixConverter;
}
public void setDevisConverter(DevisConverter value) {
this.devisConverter = value;
}
public DevisConverter getDevisConverter() {
return devisConverter;
}
public void setRetourProduitConverter(RetourProduitConverter value) {
this.retourProduitConverter = value;
}
public RetourProduitConverter getRetourProduitConverter() {
return retourProduitConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setNoteCreditTaxeConverter(NoteCreditTaxeConverter value) {
this.noteCreditTaxeConverter = value;
}
public NoteCreditTaxeConverter getNoteCreditTaxeConverter() {
return noteCreditTaxeConverter;
}
}