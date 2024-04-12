package org.sir.erplain.ws.dto.parametres;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NouvelleDeviseDto {
private Long id;
private String labelle;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getLabelle() {
return labelle;
}
public void setLabelle(String value) {
this.labelle = value;
}
}