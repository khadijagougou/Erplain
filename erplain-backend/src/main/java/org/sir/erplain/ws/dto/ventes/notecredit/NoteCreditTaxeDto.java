package org.sir.erplain.ws.dto.ventes.notecredit;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.ws.dto.parametres.TaxeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteCreditTaxeDto {
private Long id;
private NoteCreditDto noteCredit;
private TaxeDto taxe;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public NoteCreditDto getNoteCredit() {
return noteCredit;
}
public void setNoteCredit(NoteCreditDto value) {
this.noteCredit = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
}