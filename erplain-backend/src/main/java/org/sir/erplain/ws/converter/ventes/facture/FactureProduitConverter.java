package org.sir.erplain.ws.converter.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.sir.erplain.ws.dto.ventes.facture.FactureProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class FactureProduitConverter {
@Autowired private FactureConverter factureConverter;
private boolean facture = true;
protected void configure(boolean value) {
this.factureConverter.setFactureProduit(value);
}
public final FactureProduitDto toDto(FactureProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final FactureProduit toItem(FactureProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<FactureProduit> toItem(List<FactureProduitDto> dtos) {
if (dtos == null) return null;
List<FactureProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<FactureProduitDto> toDto(List<FactureProduit> items) {
if (items == null) return null;
List<FactureProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected FactureProduit convertToItem(FactureProduitDto dto) {
var item = new FactureProduit();
item.setId(dto.getId());
item.setTotal(dto.getTotal());
item.setQuantite(dto.getQuantite());
item.setDisque(dto.getDisque());
item.setFacture(factureConverter.toItem(dto.getFacture()));
return item;
}
protected FactureProduitDto convertToDto(FactureProduit item) {
var dto = new FactureProduitDto();
dto.setId(item.getId());
dto.setTotal(item.getTotal());
dto.setQuantite(item.getQuantite());
dto.setDisque(item.getDisque());
dto.setFacture(facture? factureConverter.toDto(item.getFacture()): null);
return dto;
}
public void setFacture(boolean value) {
this.facture = value;
}
public void setFactureConverter(FactureConverter value) {
this.factureConverter = value;
}
public FactureConverter getFactureConverter() {
return factureConverter;
}
}