package org.sir.erplain.ws.converter.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BonCommandeProduitConverter {
@Autowired private BonCommandeConverter bonCommandeConverter;
private boolean bonCommande = true;
protected void configure(boolean value) {
this.bonCommandeConverter.setBonCommandeProduit(value);
}
public final BonCommandeProduitDto toDto(BonCommandeProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final BonCommandeProduit toItem(BonCommandeProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<BonCommandeProduit> toItem(List<BonCommandeProduitDto> dtos) {
if (dtos == null) return null;
List<BonCommandeProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<BonCommandeProduitDto> toDto(List<BonCommandeProduit> items) {
if (items == null) return null;
List<BonCommandeProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected BonCommandeProduit convertToItem(BonCommandeProduitDto dto) {
var item = new BonCommandeProduit();
item.setId(dto.getId());
item.setTotal(dto.getTotal());
item.setQuantite(dto.getQuantite());
item.setDisque(dto.getDisque());
item.setBonCommande(bonCommandeConverter.toItem(dto.getBonCommande()));
return item;
}
protected BonCommandeProduitDto convertToDto(BonCommandeProduit item) {
var dto = new BonCommandeProduitDto();
dto.setId(item.getId());
dto.setTotal(item.getTotal());
dto.setQuantite(item.getQuantite());
dto.setDisque(item.getDisque());
dto.setBonCommande(bonCommande? bonCommandeConverter.toDto(item.getBonCommande()): null);
return dto;
}
public void setBonCommande(boolean value) {
this.bonCommande = value;
}
public void setBonCommandeConverter(BonCommandeConverter value) {
this.bonCommandeConverter = value;
}
public BonCommandeConverter getBonCommandeConverter() {
return bonCommandeConverter;
}
}