package org.sir.erplain.ws.converter.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationTaxeExpeditionDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EstimationTaxeExpeditionConverter {
@Autowired private EstimationConverter estimationConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean estimation = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.estimationConverter.setEstimationTaxeExpedition(value);
this.taxeConverter.setEstimationTaxeExpedition(value);
}
public final EstimationTaxeExpeditionDto toDto(EstimationTaxeExpedition item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final EstimationTaxeExpedition toItem(EstimationTaxeExpeditionDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<EstimationTaxeExpedition> toItem(List<EstimationTaxeExpeditionDto> dtos) {
if (dtos == null) return null;
List<EstimationTaxeExpedition> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EstimationTaxeExpeditionDto> toDto(List<EstimationTaxeExpedition> items) {
if (items == null) return null;
List<EstimationTaxeExpeditionDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected EstimationTaxeExpedition convertToItem(EstimationTaxeExpeditionDto dto) {
var item = new EstimationTaxeExpedition();
item.setId(dto.getId());
item.setEstimation(estimationConverter.toItem(dto.getEstimation()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected EstimationTaxeExpeditionDto convertToDto(EstimationTaxeExpedition item) {
var dto = new EstimationTaxeExpeditionDto();
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