package org.sir.erplain.bean.core.contacts;
import org.sir.erplain.bean.core.parametres.Taxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Client' and 'Taxe'
*/
@Entity
@Table(name="clienttaxe")
public class ClientTaxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Client client;
@ManyToOne(fetch = FetchType.LAZY)
private Taxe taxe;
public ClientTaxe() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public Client getClient() {
return client;
}
public void setClient(Client value) {
this.client = value;
}
public Taxe getTaxe() {
return taxe;
}
public void setTaxe(Taxe value) {
this.taxe = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof ClientTaxe clientTaxe) {
return clientTaxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}