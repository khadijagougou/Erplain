package org.sir.erplain.bean.core.parametres;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="nouvelledevise")
public class NouvelleDevise {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String labelle;
public NouvelleDevise() {
}
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
@Override
public boolean equals(Object object) {
if (object instanceof NouvelleDevise nouvelleDevise) {
return nouvelleDevise.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}