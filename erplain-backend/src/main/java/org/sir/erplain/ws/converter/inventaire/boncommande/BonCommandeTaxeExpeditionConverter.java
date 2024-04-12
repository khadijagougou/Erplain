package org.sir.erplain.ws.converter.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeTaxeExpeditionDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BonCommandeTaxeExpeditionConverter {
@Autowired private BonCommandeConverter bonCommandeConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean bonCommande = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.bonCommandeConverter.setBonCommandeTaxeExpedition(value);
this.taxeConverter.setBonCommandeTaxeExpedition(value);
}
public final BonCommandeTaxeExpeditionDto toDto(BonCommandeTaxeExpedition item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final BonCommandeTaxeExpedition toItem(BonCommandeTaxeExpeditionDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<BonCommandeTaxeExpedition> toItem(List<BonCommandeTaxeExpeditionDto> dtos) {
if (dtos == null) return null;
List<BonCommandeTaxeExpedition> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<BonCommandeTaxeExpeditionDto> toDto(List<BonCommandeTaxeExpedition> items) {
if (items == null) return null;
List<BonCommandeTaxeExpeditionDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected BonCommandeTaxeExpedition convertToItem(BonCommandeTaxeExpeditionDto dto) {
var item = new BonCommandeTaxeExpedition();
item.setId(dto.getId());
item.setBonCommande(bonCommandeConverter.toItem(dto.getBonCommande()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected BonCommandeTaxeExpeditionDto convertToDto(BonCommandeTaxeExpedition item) {
var dto = new BonCommandeTaxeExpeditionDto();
dto.setId(item.getId());
dto.setBonCommande(bonCommande? bonCommandeConverter.toDto(item.getBonCommande()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setBonCommande(boolean value) {
this.bonCommande = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setBonCommandeConverter(BonCommandeConverter value) {
this.bonCommandeConverter = value;
}
public BonCommandeConverter getBonCommandeConverter() {
return bonCommandeConverter;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
}