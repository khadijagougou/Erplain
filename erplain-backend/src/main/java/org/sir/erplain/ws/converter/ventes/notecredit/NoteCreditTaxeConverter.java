package org.sir.erplain.ws.converter.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditTaxeDto;
import org.sir.erplain.ws.converter.parametres.TaxeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class NoteCreditTaxeConverter {
@Autowired private TaxeConverter taxeConverter;
@Autowired private NoteCreditConverter noteCreditConverter;
private boolean noteCredit = true;
private boolean taxe = true;
protected void configure(boolean value) {
this.taxeConverter.setNoteCreditTaxe(value);
this.noteCreditConverter.setNoteCreditTaxe(value);
}
public final NoteCreditTaxeDto toDto(NoteCreditTaxe item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final NoteCreditTaxe toItem(NoteCreditTaxeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<NoteCreditTaxe> toItem(List<NoteCreditTaxeDto> dtos) {
if (dtos == null) return null;
List<NoteCreditTaxe> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<NoteCreditTaxeDto> toDto(List<NoteCreditTaxe> items) {
if (items == null) return null;
List<NoteCreditTaxeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected NoteCreditTaxe convertToItem(NoteCreditTaxeDto dto) {
var item = new NoteCreditTaxe();
item.setId(dto.getId());
item.setNoteCredit(noteCreditConverter.toItem(dto.getNoteCredit()));
item.setTaxe(taxeConverter.toItem(dto.getTaxe()));
return item;
}
protected NoteCreditTaxeDto convertToDto(NoteCreditTaxe item) {
var dto = new NoteCreditTaxeDto();
dto.setId(item.getId());
dto.setNoteCredit(noteCredit? noteCreditConverter.toDto(item.getNoteCredit()): null);
dto.setTaxe(taxe? taxeConverter.toDto(item.getTaxe()): null);
return dto;
}
public void setNoteCredit(boolean value) {
this.noteCredit = value;
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
public void setNoteCreditConverter(NoteCreditConverter value) {
this.noteCreditConverter = value;
}
public NoteCreditConverter getNoteCreditConverter() {
return noteCreditConverter;
}
}