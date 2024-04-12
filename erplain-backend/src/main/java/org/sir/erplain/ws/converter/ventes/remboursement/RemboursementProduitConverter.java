package org.sir.erplain.ws.converter.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.ws.dto.ventes.remboursement.RemboursementProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class RemboursementProduitConverter {
@Autowired private RemboursementConverter remboursementConverter;
private boolean remboursement = true;
protected void configure(boolean value) {
this.remboursementConverter.setRemboursementProduit(value);
}
public final RemboursementProduitDto toDto(RemboursementProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final RemboursementProduit toItem(RemboursementProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<RemboursementProduit> toItem(List<RemboursementProduitDto> dtos) {
if (dtos == null) return null;
List<RemboursementProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<RemboursementProduitDto> toDto(List<RemboursementProduit> items) {
if (items == null) return null;
List<RemboursementProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected RemboursementProduit convertToItem(RemboursementProduitDto dto) {
var item = new RemboursementProduit();
item.setId(dto.getId());
item.setTotal(dto.getTotal());
item.setQuantite(dto.getQuantite());
item.setDisque(dto.getDisque());
item.setRemboursement(remboursementConverter.toItem(dto.getRemboursement()));
return item;
}
protected RemboursementProduitDto convertToDto(RemboursementProduit item) {
var dto = new RemboursementProduitDto();
dto.setId(item.getId());
dto.setTotal(item.getTotal());
dto.setQuantite(item.getQuantite());
dto.setDisque(item.getDisque());
dto.setRemboursement(remboursement? remboursementConverter.toDto(item.getRemboursement()): null);
return dto;
}
public void setRemboursement(boolean value) {
this.remboursement = value;
}
public void setRemboursementConverter(RemboursementConverter value) {
this.remboursementConverter = value;
}
public RemboursementConverter getRemboursementConverter() {
return remboursementConverter;
}
}