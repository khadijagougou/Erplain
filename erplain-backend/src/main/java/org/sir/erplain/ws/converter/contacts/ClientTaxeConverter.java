package org.sir.erplain.ws.converter.contacts;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.ws.dto.contacts.ClientTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ClientTaxeConverter {
@Autowired private ClientConverter clientConverter;
@Autowired private TaxeConverter taxeConverter;
private boolean client = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.clientConverter.setClientTaxe(value);
this.taxeConverter.setClientTaxe(value);
}
public final ClientTaxeDto toDto(ClientTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final ClientTaxe toItem(ClientTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<ClientTaxe> toItem(List<ClientTaxeDto> dtos) {
if (dtos == null) return null;
List<ClientTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<ClientTaxeDto> toDto(List<ClientTaxe> items) {
if (items == null) return null;
List<ClientTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected ClientTaxe convertToItem(ClientTaxeDto dto) {
var item = new ClientTaxe();
item.setId(dto.getId());
item.setClient(clientConverter.toItem(dto.getClient()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected ClientTaxeDto convertToDto(ClientTaxe item) {
var dto = new ClientTaxeDto();
dto.setId(item.getId());
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setClient(boolean value) {
this.client = value;
}
public void setTaxe(boolean value) {
this.taxe = value;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
public void setTaxeConverter(TaxeConverter value) {
this.taxeConverter = value;
}
public TaxeConverter getTaxeConverter() {
return taxeConverter;
}
}