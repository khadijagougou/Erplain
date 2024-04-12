package org.sir.erplain.ws.dto.contacts.user;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.zsecurity.ws.dto.AppUserDto;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.ws.dto.address.AddressDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeDto extends AppUserDto {
private Long id;
private String nom;
private String prenom;
private String code;
private String telephone;
private AddressDto address;
private EntrepriseDto entreprise;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getNom() {
return nom;
}
public void setNom(String value) {
this.nom = value;
}
public String getPrenom() {
return prenom;
}
public void setPrenom(String value) {
this.prenom = value;
}
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String value) {
this.telephone = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}
}