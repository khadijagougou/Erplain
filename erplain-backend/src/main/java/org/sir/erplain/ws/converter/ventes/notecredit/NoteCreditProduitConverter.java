package org.sir.erplain.ws.converter.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.sir.erplain.ws.dto.ventes.notecredit.NoteCreditProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class NoteCreditProduitConverter {
@Autowired private NoteCreditConverter noteCreditConverter;
private boolean noteCredit = true;
protected void configure(boolean value) {
this.noteCreditConverter.setNoteCreditProduit(value);
}
public final NoteCreditProduitDto toDto(NoteCreditProduit item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final NoteCreditProduit toItem(NoteCreditProduitDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<NoteCreditProduit> toItem(List<NoteCreditProduitDto> dtos) {
if (dtos == null) return null;
List<NoteCreditProduit> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<NoteCreditProduitDto> toDto(List<NoteCreditProduit> items) {
if (items == null) return null;
List<NoteCreditProduitDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected NoteCreditProduit convertToItem(NoteCreditProduitDto dto) {
var item = new NoteCreditProduit();
item.setId(dto.getId());
item.setTotal(dto.getTotal());
item.setQuantite(dto.getQuantite());
item.setDisque(dto.getDisque());
item.setNoteCredit(noteCreditConverter.toItem(dto.getNoteCredit()));
return item;
}
protected NoteCreditProduitDto convertToDto(NoteCreditProduit item) {
var dto = new NoteCreditProduitDto();
dto.setId(item.getId());
dto.setTotal(item.getTotal());
dto.setQuantite(item.getQuantite());
dto.setDisque(item.getDisque());
dto.setNoteCredit(noteCredit? noteCreditConverter.toDto(item.getNoteCredit()): null);
return dto;
}
public void setNoteCredit(boolean value) {
this.noteCredit = value;
}
public void setNoteCreditConverter(NoteCreditConverter value) {
this.noteCreditConverter = value;
}
public NoteCreditConverter getNoteCreditConverter() {
return noteCreditConverter;
}
}