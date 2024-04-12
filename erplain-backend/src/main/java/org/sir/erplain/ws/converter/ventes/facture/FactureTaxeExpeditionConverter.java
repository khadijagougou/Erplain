package org.sir.erplain.ws.converter.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.ws.dto.ventes.facture.FactureTaxeExpeditionDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class FactureTaxeExpeditionConverter {
@Autowired private TaxeConverter taxeConverter;
@Autowired private FactureConverter factureConverter;
private boolean facture = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.taxeConverter.setFactureTaxeExpedition(value);
this.factureConverter.setFactureTaxeExpedition(value);
}
public final FactureTaxeExpeditionDto toDto(FactureTaxeExpedition item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final FactureTaxeExpedition toItem(FactureTaxeExpeditionDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<FactureTaxeExpedition> toItem(List<FactureTaxeExpeditionDto> dtos) {
if (dtos == null) return null;
List<FactureTaxeExpedition> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<FactureTaxeExpeditionDto> toDto(List<FactureTaxeExpedition> items) {
if (items == null) return null;
List<FactureTaxeExpeditionDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected FactureTaxeExpedition convertToItem(FactureTaxeExpeditionDto dto) {
var item = new FactureTaxeExpedition();
item.setId(dto.getId());
item.setFacture(factureConverter.toItem(dto.getFacture()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected FactureTaxeExpeditionDto convertToDto(FactureTaxeExpedition item) {
var dto = new FactureTaxeExpeditionDto();
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