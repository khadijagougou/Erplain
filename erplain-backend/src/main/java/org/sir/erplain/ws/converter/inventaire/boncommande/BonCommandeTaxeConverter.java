package org.sir.erplain.ws.converter.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BonCommandeTaxeConverter {
@Autowired private BonCommandeConverter bonCommandeConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean bonCommande = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.bonCommandeConverter.setBonCommandeTaxe(value);
this.taxeConverter.setBonCommandeTaxe(value);
}
public final BonCommandeTaxeDto toDto(BonCommandeTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final BonCommandeTaxe toItem(BonCommandeTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<BonCommandeTaxe> toItem(List<BonCommandeTaxeDto> dtos) {
if (dtos == null) return null;
List<BonCommandeTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<BonCommandeTaxeDto> toDto(List<BonCommandeTaxe> items) {
if (items == null) return null;
List<BonCommandeTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected BonCommandeTaxe convertToItem(BonCommandeTaxeDto dto) {
var item = new BonCommandeTaxe();
item.setId(dto.getId());
item.setBonCommande(bonCommandeConverter.toItem(dto.getBonCommande()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected BonCommandeTaxeDto convertToDto(BonCommandeTaxe item) {
var dto = new BonCommandeTaxeDto();
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