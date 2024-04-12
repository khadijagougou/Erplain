package org.sir.erplain.ws.converter.parametres;
import org.sir.erplain.bean.core.parametres.NouvelleDevise;
import org.sir.erplain.ws.dto.parametres.NouvelleDeviseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class NouvelleDeviseConverter {
protected void configure(boolean value) {
}
public final NouvelleDeviseDto toDto(NouvelleDevise item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final NouvelleDevise toItem(NouvelleDeviseDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<NouvelleDevise> toItem(List<NouvelleDeviseDto> dtos) {
if (dtos == null) return null;
List<NouvelleDevise> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<NouvelleDeviseDto> toDto(List<NouvelleDevise> items) {
if (items == null) return null;
List<NouvelleDeviseDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected NouvelleDevise convertToItem(NouvelleDeviseDto dto) {
var item = new NouvelleDevise();
item.setId(dto.getId());
item.setLabelle(dto.getLabelle());
return item;
}
protected NouvelleDeviseDto convertToDto(NouvelleDevise item) {
var dto = new NouvelleDeviseDto();
dto.setId(item.getId());
dto.setLabelle(item.getLabelle());
return dto;
}
}