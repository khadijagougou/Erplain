package org.sir.erplain.ws.converter.parametres;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import org.sir.erplain.ws.converter.contacts.ClientTaxeConverter;
import org.sir.erplain.ws.converter.produit.ProduitTaxeConverter;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationTaxeConverter;
import org.sir.erplain.ws.converter.ventes.estimation.EstimationTaxeExpeditionConverter;
import org.sir.erplain.ws.converter.ventes.commande.CommandeTaxeConverter;
import org.sir.erplain.ws.converter.ventes.commande.CommandeTaxeExpeditionConverter;
import org.sir.erplain.ws.converter.ventes.facture.FactureTaxeConverter;
import org.sir.erplain.ws.converter.ventes.facture.FactureTaxeExpeditionConverter;
import org.sir.erplain.ws.converter.ventes.notecredit.NoteCreditTaxeConverter;
import org.sir.erplain.ws.converter.ventes.remboursement.RemboursementTaxeConverter;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeTaxeConverter;
import org.sir.erplain.ws.converter.inventaire.boncommande.BonCommandeTaxeExpeditionConverter;
import org.sir.erplain.ws.converter.inventaire.livraison.LivraisonTaxeExpeditionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class TaxeConverter {
@Autowired private ClientTaxeConverter clientTaxeConverter;
@Autowired private FactureTaxeConverter factureTaxeConverter;
@Autowired private FactureTaxeExpeditionConverter factureTaxeExpeditionConverter;
@Autowired private BonCommandeTaxeConverter bonCommandeTaxeConverter;
@Autowired private CommandeTaxeExpeditionConverter commandeTaxeExpeditionConverter;
@Autowired private LivraisonTaxeExpeditionConverter livraisonTaxeExpeditionConverter;
@Autowired private NoteCreditTaxeConverter noteCreditTaxeConverter;
@Autowired private EstimationTaxeExpeditionConverter estimationTaxeExpeditionConverter;
@Autowired private BonCommandeTaxeExpeditionConverter bonCommandeTaxeExpeditionConverter;
@Autowired private EstimationTaxeConverter estimationTaxeConverter;
@Autowired private ProduitTaxeConverter produitTaxeConverter;
@Autowired private RemboursementTaxeConverter remboursementTaxeConverter;
@Autowired private CommandeTaxeConverter commandeTaxeConverter;
private boolean clientTaxe = true;
private boolean produitTaxe = true;
private boolean estimationTaxe = true;
private boolean estimationTaxeExpedition = true;
private boolean commandeTaxe = true;
private boolean commandeTaxeExpedition = true;
private boolean factureTaxe = true;
private boolean factureTaxeExpedition = true;
private boolean noteCreditTaxe = true;
private boolean remboursementTaxe = true;
private boolean bonCommandeTaxe = true;
private boolean bonCommandeTaxeExpedition = true;
private boolean livraisonTaxeExpedition = true;
protected void configure(boolean value) {
this.clientTaxeConverter.setTaxe(value);
this.factureTaxeConverter.setTaxe(value);
this.factureTaxeExpeditionConverter.setTaxe(value);
this.bonCommandeTaxeConverter.setTaxe(value);
this.commandeTaxeExpeditionConverter.setTaxe(value);
this.livraisonTaxeExpeditionConverter.setTaxe(value);
this.noteCreditTaxeConverter.setTaxe(value);
this.estimationTaxeExpeditionConverter.setTaxe(value);
this.bonCommandeTaxeExpeditionConverter.setTaxe(value);
this.estimationTaxeConverter.setTaxe(value);
this.produitTaxeConverter.setTaxe(value);
this.remboursementTaxeConverter.setTaxe(value);
this.commandeTaxeConverter.setTaxe(value);
}
public final TaxeDto toDto(Taxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Taxe toItem(TaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Taxe> toItem(List<TaxeDto> dtos) {
if (dtos == null) return null;
List<Taxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<TaxeDto> toDto(List<Taxe> items) {
if (items == null) return null;
List<TaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Taxe convertToItem(TaxeDto dto) {
var item = new Taxe();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setTauxImposition(dto.getTauxImposition());
item.setActif(dto.isActif());
item.setClientTaxe(clientTaxeConverter.toItem(dto.getClientTaxe()));
item.setProduitTaxe(produitTaxeConverter.toItem(dto.getProduitTaxe()));
item.setEstimationTaxe(estimationTaxeConverter.toItem(dto.getEstimationTaxe()));
item.setEstimationTaxeExpedition(estimationTaxeExpeditionConverter.toItem(dto.getEstimationTaxeExpedition()));
item.setCommandeTaxe(commandeTaxeConverter.toItem(dto.getCommandeTaxe()));
item.setCommandeTaxeExpedition(commandeTaxeExpeditionConverter.toItem(dto.getCommandeTaxeExpedition()));
item.setFactureTaxe(factureTaxeConverter.toItem(dto.getFactureTaxe()));
item.setFactureTaxeExpedition(factureTaxeExpeditionConverter.toItem(dto.getFactureTaxeExpedition()));
item.setNoteCreditTaxe(noteCreditTaxeConverter.toItem(dto.getNoteCreditTaxe()));
item.setRemboursementTaxe(remboursementTaxeConverter.toItem(dto.getRemboursementTaxe()));
item.setBonCommandeTaxe(bonCommandeTaxeConverter.toItem(dto.getBonCommandeTaxe()));
item.setBonCommandeTaxeExpedition(bonCommandeTaxeExpeditionConverter.toItem(dto.getBonCommandeTaxeExpedition()));
item.setLivraisonTaxeExpedition(livraisonTaxeExpeditionConverter.toItem(dto.getLivraisonTaxeExpedition()));
return item;
}
protected TaxeDto convertToDto(Taxe item) {
var dto = new TaxeDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setTauxImposition(item.getTauxImposition());
dto.setActif(item.isActif());
dto.setClientTaxe(clientTaxe? clientTaxeConverter.toDto(item.getClientTaxe()): null);
dto.setProduitTaxe(produitTaxe? produitTaxeConverter.toDto(item.getProduitTaxe()): null);
dto.setEstimationTaxe(estimationTaxe? estimationTaxeConverter.toDto(item.getEstimationTaxe()): null);
dto.setEstimationTaxeExpedition(estimationTaxeExpedition? estimationTaxeExpeditionConverter.toDto(item.getEstimationTaxeExpedition()): null);
dto.setCommandeTaxe(commandeTaxe? commandeTaxeConverter.toDto(item.getCommandeTaxe()): null);
dto.setCommandeTaxeExpedition(commandeTaxeExpedition? commandeTaxeExpeditionConverter.toDto(item.getCommandeTaxeExpedition()): null);
dto.setFactureTaxe(factureTaxe? factureTaxeConverter.toDto(item.getFactureTaxe()): null);
dto.setFactureTaxeExpedition(factureTaxeExpedition? factureTaxeExpeditionConverter.toDto(item.getFactureTaxeExpedition()): null);
dto.setNoteCreditTaxe(noteCreditTaxe? noteCreditTaxeConverter.toDto(item.getNoteCreditTaxe()): null);
dto.setRemboursementTaxe(remboursementTaxe? remboursementTaxeConverter.toDto(item.getRemboursementTaxe()): null);
dto.setBonCommandeTaxe(bonCommandeTaxe? bonCommandeTaxeConverter.toDto(item.getBonCommandeTaxe()): null);
dto.setBonCommandeTaxeExpedition(bonCommandeTaxeExpedition? bonCommandeTaxeExpeditionConverter.toDto(item.getBonCommandeTaxeExpedition()): null);
dto.setLivraisonTaxeExpedition(livraisonTaxeExpedition? livraisonTaxeExpeditionConverter.toDto(item.getLivraisonTaxeExpedition()): null);
return dto;
}
public void setClientTaxe(boolean value) {
this.clientTaxe = value;
}
public void setProduitTaxe(boolean value) {
this.produitTaxe = value;
}
public void setEstimationTaxe(boolean value) {
this.estimationTaxe = value;
}
public void setEstimationTaxeExpedition(boolean value) {
this.estimationTaxeExpedition = value;
}
public void setCommandeTaxe(boolean value) {
this.commandeTaxe = value;
}
public void setCommandeTaxeExpedition(boolean value) {
this.commandeTaxeExpedition = value;
}
public void setFactureTaxe(boolean value) {
this.factureTaxe = value;
}
public void setFactureTaxeExpedition(boolean value) {
this.factureTaxeExpedition = value;
}
public void setNoteCreditTaxe(boolean value) {
this.noteCreditTaxe = value;
}
public void setRemboursementTaxe(boolean value) {
this.remboursementTaxe = value;
}
public void setBonCommandeTaxe(boolean value) {
this.bonCommandeTaxe = value;
}
public void setBonCommandeTaxeExpedition(boolean value) {
this.bonCommandeTaxeExpedition = value;
}
public void setLivraisonTaxeExpedition(boolean value) {
this.livraisonTaxeExpedition = value;
}
public void setClientTaxeConverter(ClientTaxeConverter value) {
this.clientTaxeConverter = value;
}
public ClientTaxeConverter getClientTaxeConverter() {
return clientTaxeConverter;
}
public void setFactureTaxeConverter(FactureTaxeConverter value) {
this.factureTaxeConverter = value;
}
public FactureTaxeConverter getFactureTaxeConverter() {
return factureTaxeConverter;
}
public void setFactureTaxeExpeditionConverter(FactureTaxeExpeditionConverter value) {
this.factureTaxeExpeditionConverter = value;
}
public FactureTaxeExpeditionConverter getFactureTaxeExpeditionConverter() {
return factureTaxeExpeditionConverter;
}
public void setBonCommandeTaxeConverter(BonCommandeTaxeConverter value) {
this.bonCommandeTaxeConverter = value;
}
public BonCommandeTaxeConverter getBonCommandeTaxeConverter() {
return bonCommandeTaxeConverter;
}
public void setCommandeTaxeExpeditionConverter(CommandeTaxeExpeditionConverter value) {
this.commandeTaxeExpeditionConverter = value;
}
public CommandeTaxeExpeditionConverter getCommandeTaxeExpeditionConverter() {
return commandeTaxeExpeditionConverter;
}
public void setLivraisonTaxeExpeditionConverter(LivraisonTaxeExpeditionConverter value) {
this.livraisonTaxeExpeditionConverter = value;
}
public LivraisonTaxeExpeditionConverter getLivraisonTaxeExpeditionConverter() {
return livraisonTaxeExpeditionConverter;
}
public void setNoteCreditTaxeConverter(NoteCreditTaxeConverter value) {
this.noteCreditTaxeConverter = value;
}
public NoteCreditTaxeConverter getNoteCreditTaxeConverter() {
return noteCreditTaxeConverter;
}
public void setEstimationTaxeExpeditionConverter(EstimationTaxeExpeditionConverter value) {
this.estimationTaxeExpeditionConverter = value;
}
public EstimationTaxeExpeditionConverter getEstimationTaxeExpeditionConverter() {
return estimationTaxeExpeditionConverter;
}
public void setBonCommandeTaxeExpeditionConverter(BonCommandeTaxeExpeditionConverter value) {
this.bonCommandeTaxeExpeditionConverter = value;
}
public BonCommandeTaxeExpeditionConverter getBonCommandeTaxeExpeditionConverter() {
return bonCommandeTaxeExpeditionConverter;
}
public void setEstimationTaxeConverter(EstimationTaxeConverter value) {
this.estimationTaxeConverter = value;
}
public EstimationTaxeConverter getEstimationTaxeConverter() {
return estimationTaxeConverter;
}
public void setProduitTaxeConverter(ProduitTaxeConverter value) {
this.produitTaxeConverter = value;
}
public ProduitTaxeConverter getProduitTaxeConverter() {
return produitTaxeConverter;
}
public void setRemboursementTaxeConverter(RemboursementTaxeConverter value) {
this.remboursementTaxeConverter = value;
}
public RemboursementTaxeConverter getRemboursementTaxeConverter() {
return remboursementTaxeConverter;
}
public void setCommandeTaxeConverter(CommandeTaxeConverter value) {
this.commandeTaxeConverter = value;
}
public CommandeTaxeConverter getCommandeTaxeConverter() {
return commandeTaxeConverter;
}
}