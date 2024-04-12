package org.sir.erplain.bean.core.ventes;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.enums.StatutCommandeExpeditionEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="commandeexpedition")
public class CommandeExpedition {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
private LocalDate dateCreation;
private LocalDate dateExpedition;
@Enumerated(EnumType.STRING)
private StatutCommandeExpeditionEnum statut;
@ManyToOne(fetch = FetchType.LAZY)
private Commande commande;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
public CommandeExpedition() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public LocalDate getDateCreation() {
return dateCreation;
}
public void setDateCreation(LocalDate value) {
this.dateCreation = value;
}
public LocalDate getDateExpedition() {
return dateExpedition;
}
public void setDateExpedition(LocalDate value) {
this.dateExpedition = value;
}
public StatutCommandeExpeditionEnum getStatut() {
return statut;
}
public void setStatut(StatutCommandeExpeditionEnum value) {
this.statut = value;
}
public Commande getCommande() {
return commande;
}
public void setCommande(Commande value) {
this.commande = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof CommandeExpedition commandeExpedition) {
return commandeExpedition.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}