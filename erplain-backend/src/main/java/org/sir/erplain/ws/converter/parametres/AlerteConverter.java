package org.sir.erplain.ws.converter.parametres;
import org.sir.erplain.bean.core.parametres.Alerte;
import org.sir.erplain.ws.dto.parametres.AlerteDto;
import org.sir.erplain.ws.converter.contacts.user.AdminConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class AlerteConverter {
@Autowired private DestinataireEmployeConverter destinataireEmployeConverter;
@Autowired private AdminConverter adminConverter;
private boolean destinataireEmploye = true;
private boolean admin = true;
protected void configure(boolean value) {
this.destinataireEmployeConverter.setAlerte(value);
this.adminConverter.setAlertes(value);
}
public final AlerteDto toDto(Alerte item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Alerte toItem(AlerteDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Alerte> toItem(List<AlerteDto> dtos) {
if (dtos == null) return null;
List<Alerte> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<AlerteDto> toDto(List<Alerte> items) {
if (items == null) return null;
List<AlerteDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Alerte convertToItem(AlerteDto dto) {
var item = new Alerte();
item.setId(dto.getId());
item.setNom(dto.getNom());
item.setStatut(dto.getStatut());
item.setActif(dto.isActif());
item.setDestinataireEmploye(destinataireEmployeConverter.toItem(dto.getDestinataireEmploye()));
item.setAdmin(adminConverter.toItem(dto.getAdmin()));
return item;
}
protected AlerteDto convertToDto(Alerte item) {
var dto = new AlerteDto();
dto.setId(item.getId());
dto.setNom(item.getNom());
dto.setStatut(item.getStatut());
dto.setActif(item.isActif());
dto.setDestinataireEmploye(destinataireEmploye? destinataireEmployeConverter.toDto(item.getDestinataireEmploye()): null);
dto.setAdmin(admin? adminConverter.toDto(item.getAdmin()): null);
return dto;
}
public void setDestinataireEmploye(boolean value) {
this.destinataireEmploye = value;
}
public void setAdmin(boolean value) {
this.admin = value;
}
public void setDestinataireEmployeConverter(DestinataireEmployeConverter value) {
this.destinataireEmployeConverter = value;
}
public DestinataireEmployeConverter getDestinataireEmployeConverter() {
return destinataireEmployeConverter;
}
public void setAdminConverter(AdminConverter value) {
this.adminConverter = value;
}
public AdminConverter getAdminConverter() {
return adminConverter;
}
}