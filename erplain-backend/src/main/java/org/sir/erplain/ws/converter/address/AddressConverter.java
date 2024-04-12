package org.sir.erplain.ws.converter.address;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.ws.dto.address.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class AddressConverter {
@Autowired private CountryConverter countryConverter;
private boolean country = true;
protected void configure(boolean value) {
this.countryConverter.setAddresses(value);
}
public final AddressDto toDto(Address item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final Address toItem(AddressDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Address> toItem(List<AddressDto> dtos) {
if (dtos == null) return null;
List<Address> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<AddressDto> toDto(List<Address> items) {
if (items == null) return null;
List<AddressDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Address convertToItem(AddressDto dto) {
var item = new Address();
item.setId(dto.getId());
item.setAddress1(dto.getAddress1());
item.setAddress2(dto.getAddress2());
item.setPostalCode(dto.getPostalCode());
item.setCity(dto.getCity());
item.setCountry(countryConverter.toItem(dto.getCountry()));
return item;
}
protected AddressDto convertToDto(Address item) {
var dto = new AddressDto();
dto.setId(item.getId());
dto.setAddress1(item.getAddress1());
dto.setAddress2(item.getAddress2());
dto.setPostalCode(item.getPostalCode());
dto.setCity(item.getCity());
dto.setCountry(country? countryConverter.toDto(item.getCountry()): null);
return dto;
}
public void setCountry(boolean value) {
this.country = value;
}
public void setCountryConverter(CountryConverter value) {
this.countryConverter = value;
}
public CountryConverter getCountryConverter() {
return countryConverter;
}
}