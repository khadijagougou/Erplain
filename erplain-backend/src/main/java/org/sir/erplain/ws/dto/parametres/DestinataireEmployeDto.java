package org.sir.erplain.ws.dto.parametres;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DestinataireEmployeDto {
private Long id;
private AlerteDto alerte;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public AlerteDto getAlerte() {
return alerte;
}
public void setAlerte(AlerteDto value) {
this.alerte = value;
}
}