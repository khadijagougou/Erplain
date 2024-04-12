package org.sir.erplain.ws.converter.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.ws.dto.ventes.facture.FactureTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class FactureTaxeConverter {
@Autowired private TaxeConverter taxeConverter;
@Autowired private FactureConverter factureConverter;
private boolean facture = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.taxeConverter.setFactureTaxe(value);
this.factureConverter.setFactureTaxe(value);
}
public final FactureTaxeDto toDto(FactureTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final FactureTaxe toItem(FactureTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<FactureTaxe> toItem(List<FactureTaxeDto> dtos) {
if (dtos == null) return null;
List<FactureTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<FactureTaxeDto> toDto(List<FactureTaxe> items) {
if (items == null) return null;
List<FactureTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected FactureTaxe convertToItem(FactureTaxeDto dto) {
var item = new FactureTaxe();
item.setId(dto.getId());
item.setFacture(factureConverter.toItem(dto.getFacture()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected FactureTaxeDto convertToDto(FactureTaxe item) {
var dto = new FactureTaxeDto();
dto.setId(item.getId());
dto.setFacture(facture? factureConverter.toDto(item.getFacture()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setFacture(boolean value) {
this.facture = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
}