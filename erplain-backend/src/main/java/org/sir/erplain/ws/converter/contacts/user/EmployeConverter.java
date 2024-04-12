package org.sir.erplain.ws.converter.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.ws.dto.contacts.user.EmployeDto;
import org.sir.erplain.zsecurity.ws.converter.AppUserConverter;
import org.sir.erplain.ws.converter.address.AddressConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeConverter {
@Autowired private AppUserConverter appUserConverter;
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private AddressConverter addressConverter;
private boolean address = true;
private boolean entreprise = true;
protected void configure(boolean value) {
this.entrepriseConverter.setEmployes(value);
}
public final EmployeDto toDto(Employe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Employe toItem(EmployeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Employe> toItem(List<EmployeDto> dtos) {
if (dtos == null) return null;
List<Employe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EmployeDto> toDto(List<Employe> items) {
if (items == null) return null;
List<EmployeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Employe convertToItem(EmployeDto dto) {
var item = new Employe();
appUserConverter.convertToChildItem(dto, item);
item.setNom(dto.getNom());
item.setPrenom(dto.getPrenom());
item.setCode(dto.getCode());
item.setTelephone(dto.getTelephone());
item.setAddress(addressConverter.toItem(dto.getAddress()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
return item;
}
protected EmployeDto convertToDto(Employe item) {
var dto = new EmployeDto();
appUserConverter.convertToChildDto(item, dto);
dto.setNom(item.getNom());
dto.setPrenom(item.getPrenom());
dto.setCode(item.getCode());
dto.setTelephone(item.getTelephone());
dto.setAddress(address? addressConverter.toDto(item.getAddress()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
return dto;
}
public void setAddress(boolean value) {
this.address = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setAddressConverter(AddressConverter value) {
this.addressConverter = value;
}
public AddressConverter getAddressConverter() {
return addressConverter;
}
}