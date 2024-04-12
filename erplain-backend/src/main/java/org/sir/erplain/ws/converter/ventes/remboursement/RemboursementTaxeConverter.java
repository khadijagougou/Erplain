package org.sir.erplain.ws.converter.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class RemboursementTaxeConverter {
@Autowired private RemboursementConverter remboursementConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean remboursement = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.remboursementConverter.setRemboursementTaxe(value);
this.taxeConverter.setRemboursementTaxe(value);
}
public final RemboursementTaxeDto toDto(RemboursementTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final RemboursementTaxe toItem(RemboursementTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<RemboursementTaxe> toItem(List<RemboursementTaxeDto> dtos) {
if (dtos == null) return null;
List<RemboursementTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<RemboursementTaxeDto> toDto(List<RemboursementTaxe> items) {
if (items == null) return null;
List<RemboursementTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected RemboursementTaxe convertToItem(RemboursementTaxeDto dto) {
var item = new RemboursementTaxe();
item.setId(dto.getId());
item.setRemboursement(remboursementConverter.toItem(dto.getRemboursement()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected RemboursementTaxeDto convertToDto(RemboursementTaxe item) {
var dto = new RemboursementTaxeDto();
dto.setId(item.getId());
dto.setRemboursement(remboursement? remboursementConverter.toDto(item.getRemboursement()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setRemboursement(boolean value) {
this.remboursement = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setRemboursementConverter(RemboursementConverter value) {
this.remboursementConverter = value;
}
public RemboursementConverter getRemboursementConverter() {
return remboursementConverter;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
}