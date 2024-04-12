package org.sir.erplain.bean.core.contacts.user;
import org.sir.erplain.zsecurity.entity.AppUser;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.Alerte;
import org.sir.erplain.bean.enums.LangueEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="admin")
public class Admin extends AppUser {
private String nom;
private String prenom;
@Enumerated(EnumType.STRING)
private LangueEnum languePDF;
@OneToOne()
private Entreprise entreprise;
@OneToMany(mappedBy = "admin")
private List<Alerte> alertes;
public Admin() {
super();
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
public LangueEnum getLanguePDF() {
return languePDF;
}
public void setLanguePDF(LangueEnum value) {
this.languePDF = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
public List<Alerte> getAlertes() {
return alertes;
}
public void setAlertes(List<Alerte> value) {
this.alertes = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Admin admin) {
return admin.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}