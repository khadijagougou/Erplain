package org.sir.erplain.bean.core.ventes.notecredit;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Taxe' and 'NoteCredit'
*/
@Entity
@Table(name="notecredittaxe")
public class NoteCreditTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private NoteCredit noteCredit;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public NoteCreditTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public NoteCredit getNoteCredit() {
return noteCredit;
}
public void setNoteCredit(NoteCredit value) {
this.noteCredit = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof NoteCreditTaxe noteCreditTaxe) {
return noteCreditTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}