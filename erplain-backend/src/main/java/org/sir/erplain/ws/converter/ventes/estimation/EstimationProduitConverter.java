package org.sir.erplain.ws.converter.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.ws.dto.ventes.estimation.EstimationProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EstimationProduitConverter {
@Autowired private EstimationConverter estimationConverter;
private boolean estimation = true;
protected void configure(boolean value) {
this.estimationConverter.setEstimationProduit(value);
}
public final EstimationProduitDto toDto(EstimationProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final EstimationProduit toItem(EstimationProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<EstimationProduit> toItem(List<EstimationProduitDto> dtos) {
if (dtos == null) return null;
List<EstimationProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EstimationProduitDto> toDto(List<EstimationProduit> items) {
if (items == null) return null;
List<EstimationProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected EstimationProduit convertToItem(EstimationProduitDto dto) {
var item = new EstimationProduit();
item.setId(dto.getId());
item.setTotal(dto.getTotal());
item.setQuantite(dto.getQuantite());
item.setDisque(dto.getDisque());
item.setEstimation(estimationConverter.toItem(dto.getEstimation()));
return item;
}
protected EstimationProduitDto convertToDto(EstimationProduit item) {
var dto = new EstimationProduitDto();
dto.setId(item.getId());
dto.setTotal(item.getTotal());
dto.setQuantite(item.getQuantite());
dto.setDisque(item.getDisque());
dto.setEstimation(estimation? estimationConverter.toDto(item.getEstimation()): null);
return dto;
}
public void setEstimation(boolean value) {
this.estimation = value;
}
public void setEstimationConverter(EstimationConverter value) {
this.estimationConverter = value;
}
public EstimationConverter getEstimationConverter() {
return estimationConverter;
}
}