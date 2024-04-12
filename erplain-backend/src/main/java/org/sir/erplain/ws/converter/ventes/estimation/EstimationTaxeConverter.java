package org.sir.erplain.ws.converter.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EstimationTaxeConverter {
@Autowired private EstimationConverter estimationConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean estimation = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.estimationConverter.setEstimationTaxe(value);
this.taxeConverter.setEstimationTaxe(value);
}
public final EstimationTaxeDto toDto(EstimationTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final EstimationTaxe toItem(EstimationTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<EstimationTaxe> toItem(List<EstimationTaxeDto> dtos) {
if (dtos == null) return null;
List<EstimationTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EstimationTaxeDto> toDto(List<EstimationTaxe> items) {
if (items == null) return null;
List<EstimationTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected EstimationTaxe convertToItem(EstimationTaxeDto dto) {
var item = new EstimationTaxe();
item.setId(dto.getId());
item.setEstimation(estimationConverter.toItem(dto.getEstimation()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected EstimationTaxeDto convertToDto(EstimationTaxe item) {
var dto = new EstimationTaxeDto();
dto.setId(item.getId());
dto.setEstimation(estimation? estimationConverter.toDto(item.getEstimation()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setEstimation(boolean value) {
this.estimation = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setEstimationConverter(EstimationConverter value) {
this.estimationConverter = value;
}
public EstimationConverter getEstimationConverter() {
return estimationConverter;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
}