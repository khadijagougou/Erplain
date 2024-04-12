package org.sir.erplain.ws.converter.produit;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.ws.dto.produit.ProduitTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProduitTaxeConverter {
@Autowired private TaxeConverter taxeConverter;
@Autowired private ProduitConverter produitConverter;
private boolean produit = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.taxeConverter.setProduitTaxe(value);
this.produitConverter.setProduitTaxe(value);
}
public final ProduitTaxeDto toDto(ProduitTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final ProduitTaxe toItem(ProduitTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<ProduitTaxe> toItem(List<ProduitTaxeDto> dtos) {
if (dtos == null) return null;
List<ProduitTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<ProduitTaxeDto> toDto(List<ProduitTaxe> items) {
if (items == null) return null;
List<ProduitTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected ProduitTaxe convertToItem(ProduitTaxeDto dto) {
var item = new ProduitTaxe();
item.setId(dto.getId());
item.setProduit(produitConverter.toItem(dto.getProduit()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected ProduitTaxeDto convertToDto(ProduitTaxe item) {
var dto = new ProduitTaxeDto();
dto.setId(item.getId());
dto.setProduit(produit? produitConverter.toDto(item.getProduit()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setProduit(boolean value) {
this.produit = value;
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
public void setProduitConverter(ProduitConverter value) {
this.produitConverter = value;
}
public ProduitConverter getProduitConverter() {
return produitConverter;
}
}