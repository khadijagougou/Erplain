package org.sir.erplain.ws.converter.address;
import org.sir.erplain.bean.core.address.Country;
import org.sir.erplain.ws.dto.address.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CountryConverter {
@Autowired private AddressConverter addressConverter;
private boolean addresses = true;
protected void configure(boolean value) {
this.addressConverter.setCountry(value);
}
public final CountryDto toDto(Country item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Country toItem(CountryDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Country> toItem(List<CountryDto> dtos) {
if (dtos == null) return null;
List<Country> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<CountryDto> toDto(List<Country> items) {
if (items == null) return null;
List<CountryDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Country convertToItem(CountryDto dto) {
var item = new Country();
item.setId(dto.getId());
item.setName(dto.getName());
item.setAddresses(addressConverter.toItem(dto.getAddresses()));
return item;
}
protected CountryDto convertToDto(Country item) {
var dto = new CountryDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setAddresses(addresses? addressConverter.toDto(item.getAddresses()): null);
return dto;
}
public void setAddresses(boolean value) {
this.addresses = value;
}
public void setAddressConverter(AddressConverter value) {
this.addressConverter = value;
}
public AddressConverter getAddressConverter() {
return addressConverter;
}
}