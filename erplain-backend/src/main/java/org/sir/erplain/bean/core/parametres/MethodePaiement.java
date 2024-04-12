package org.sir.erplain.bean.core.parametres;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="methodepaiement")
public class MethodePaiement {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private boolean disponiblePos;
private boolean actif;
public MethodePaiement() {
}
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
public boolean isDisponiblePos() {
return disponiblePos;
}
public void setDisponiblePos(boolean value) {
this.disponiblePos = value;
}
public boolean isActif() {
return actif;
}
public void setActif(boolean value) {
this.actif = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof MethodePaiement methodePaiement) {
return methodePaiement.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}