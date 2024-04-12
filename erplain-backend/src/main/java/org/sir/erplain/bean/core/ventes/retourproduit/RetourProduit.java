package org.sir.erplain.bean.core.ventes.retourproduit;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.enums.StatutRetourProduitEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="retourproduit")
public class RetourProduit {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String code;
@OneToMany(mappedBy = "retourProduit")
private List<NoteCredit> noteCredit;
@OneToMany(mappedBy = "retourProduit")
private List<Remboursement> remboursements;
@Enumerated(EnumType.STRING)
private StatutRetourProduitEnum statut;
@OneToMany(mappedBy = "retourProduit")
private List<RetourProduitProduit> retourProduitProduit;
@ManyToOne(fetch = FetchType.LAZY)
private Client client;
@ManyToOne(fetch = FetchType.LAZY)
private Facture facture;
@ManyToOne(fetch = FetchType.LAZY)
private Entreprise entreprise;
public RetourProduit() {
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
public List<NoteCredit> getNoteCredit() {
return noteCredit;
}
public void setNoteCredit(List<NoteCredit> value) {
this.noteCredit = value;
}
public List<Remboursement> getRemboursements() {
return remboursements;
}
public void setRemboursements(List<Remboursement> value) {
this.remboursements = value;
}
public StatutRetourProduitEnum getStatut() {
return statut;
}
public void setStatut(StatutRetourProduitEnum value) {
this.statut = value;
}
public List<RetourProduitProduit> getRetourProduitProduit() {
return retourProduitProduit;
}
public void setRetourProduitProduit(List<RetourProduitProduit> value) {
this.retourProduitProduit = value;
}
public Client getClient() {
return client;
}
public void setClient(Client value) {
this.client = value;
}
public Facture getFacture() {
return facture;
}
public void setFacture(Facture value) {
this.facture = value;
}
public Entreprise getEntreprise() {
return entreprise;
}
public void setEntreprise(Entreprise value) {
this.entreprise = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof RetourProduit retourProduit) {
return retourProduit.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}