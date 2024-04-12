package org.sir.erplain.bean.core.parametres;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="taxe")
public class Taxe {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private double tauxImposition;
private boolean actif;
@OneToMany(mappedBy = "taxe")
private List<ClientTaxe> clientTaxe;
@OneToMany(mappedBy = "taxe")
private List<ProduitTaxe> produitTaxe;
@OneToMany(mappedBy = "taxe")
private List<EstimationTaxe> estimationTaxe;
@OneToMany(mappedBy = "taxe")
private List<EstimationTaxeExpedition> estimationTaxeExpedition;
@OneToMany(mappedBy = "taxe")
private List<CommandeTaxe> commandeTaxe;
@OneToMany(mappedBy = "taxe")
private List<CommandeTaxeExpedition> commandeTaxeExpedition;
@OneToMany(mappedBy = "taxe")
private List<FactureTaxe> factureTaxe;
@OneToMany(mappedBy = "taxe")
private List<FactureTaxeExpedition> factureTaxeExpedition;
@OneToMany(mappedBy = "taxe")
private List<NoteCreditTaxe> noteCreditTaxe;
@OneToMany(mappedBy = "taxe")
private List<RemboursementTaxe> remboursementTaxe;
@OneToMany(mappedBy = "taxe")
private List<BonCommandeTaxe> bonCommandeTaxe;
@OneToMany(mappedBy = "taxe")
private List<BonCommandeTaxeExpedition> bonCommandeTaxeExpedition;
@OneToMany(mappedBy = "taxe")
private List<LivraisonTaxeExpedition> livraisonTaxeExpedition;
public Taxe() {
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
public double getTauxImposition() {
return tauxImposition;
}
public void setTauxImposition(double value) {
this.tauxImposition = value;
}
public boolean isActif() {
return actif;
}
public void setActif(boolean value) {
this.actif = value;
}
public List<ClientTaxe> getClientTaxe() {
return clientTaxe;
}
public void setClientTaxe(List<ClientTaxe> value) {
this.clientTaxe = value;
}
public List<ProduitTaxe> getProduitTaxe() {
return produitTaxe;
}
public void setProduitTaxe(List<ProduitTaxe> value) {
this.produitTaxe = value;
}
public List<EstimationTaxe> getEstimationTaxe() {
return estimationTaxe;
}
public void setEstimationTaxe(List<EstimationTaxe> value) {
this.estimationTaxe = value;
}
public List<EstimationTaxeExpedition> getEstimationTaxeExpedition() {
return estimationTaxeExpedition;
}
public void setEstimationTaxeExpedition(List<EstimationTaxeExpedition> value) {
this.estimationTaxeExpedition = value;
}
public List<CommandeTaxe> getCommandeTaxe() {
return commandeTaxe;
}
public void setCommandeTaxe(List<CommandeTaxe> value) {
this.commandeTaxe = value;
}
public List<CommandeTaxeExpedition> getCommandeTaxeExpedition() {
return commandeTaxeExpedition;
}
public void setCommandeTaxeExpedition(List<CommandeTaxeExpedition> value) {
this.commandeTaxeExpedition = value;
}
public List<FactureTaxe> getFactureTaxe() {
return factureTaxe;
}
public void setFactureTaxe(List<FactureTaxe> value) {
this.factureTaxe = value;
}
public List<FactureTaxeExpedition> getFactureTaxeExpedition() {
return factureTaxeExpedition;
}
public void setFactureTaxeExpedition(List<FactureTaxeExpedition> value) {
this.factureTaxeExpedition = value;
}
public List<NoteCreditTaxe> getNoteCreditTaxe() {
return noteCreditTaxe;
}
public void setNoteCreditTaxe(List<NoteCreditTaxe> value) {
this.noteCreditTaxe = value;
}
public List<RemboursementTaxe> getRemboursementTaxe() {
return remboursementTaxe;
}
public void setRemboursementTaxe(List<RemboursementTaxe> value) {
this.remboursementTaxe = value;
}
public List<BonCommandeTaxe> getBonCommandeTaxe() {
return bonCommandeTaxe;
}
public void setBonCommandeTaxe(List<BonCommandeTaxe> value) {
this.bonCommandeTaxe = value;
}
public List<BonCommandeTaxeExpedition> getBonCommandeTaxeExpedition() {
return bonCommandeTaxeExpedition;
}
public void setBonCommandeTaxeExpedition(List<BonCommandeTaxeExpedition> value) {
this.bonCommandeTaxeExpedition = value;
}
public List<LivraisonTaxeExpedition> getLivraisonTaxeExpedition() {
return livraisonTaxeExpedition;
}
public void setLivraisonTaxeExpedition(List<LivraisonTaxeExpedition> value) {
this.livraisonTaxeExpedition = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Taxe taxe) {
return taxe.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}