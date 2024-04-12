package org.sir.erplain.ws.converter.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.ws.dto.inventaire.livraison.LivraisonTaxeExpeditionDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class LivraisonTaxeExpeditionConverter {
@Autowired private LivraisonConverter livraisonConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean livraison = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.livraisonConverter.setLivraisonTaxeExpedition(value);
this.taxeConverter.setLivraisonTaxeExpedition(value);
}
public final LivraisonTaxeExpeditionDto toDto(LivraisonTaxeExpedition item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final LivraisonTaxeExpedition toItem(LivraisonTaxeExpeditionDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<LivraisonTaxeExpedition> toItem(List<LivraisonTaxeExpeditionDto> dtos) {
if (dtos == null) return null;
List<LivraisonTaxeExpedition> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<LivraisonTaxeExpeditionDto> toDto(List<LivraisonTaxeExpedition> items) {
if (items == null) return null;
List<LivraisonTaxeExpeditionDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected LivraisonTaxeExpedition convertToItem(LivraisonTaxeExpeditionDto dto) {
var item = new LivraisonTaxeExpedition();
item.setId(dto.getId());
item.setLivraison(livraisonConverter.toItem(dto.getLivraison()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected LivraisonTaxeExpeditionDto convertToDto(LivraisonTaxeExpedition item) {
var dto = new LivraisonTaxeExpeditionDto();
dto.setId(item.getId());
dto.setLivraison(livraison? livraisonConverter.toDto(item.getLivraison()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setLivraison(boolean value) {
this.livraison = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setLivraisonConverter(LivraisonConverter value) {
this.livraisonConverter = value;
}
public LivraisonConverter getLivraisonConverter() {
return livraisonConverter;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
}