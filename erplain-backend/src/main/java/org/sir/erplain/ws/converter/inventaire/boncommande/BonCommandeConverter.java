package org.sir.erplain.ws.converter.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.ws.dto.inventaire.boncommande.BonCommandeDto;
import org.sir.erplain.ws.converter.inventaire.livraison.LivraisonConverter;
import org.sir.erplain.ws.converter.contacts.FournisseurConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.converter.parametres.DevisConverter;
import org.sir.erplain.ws.converter.parametres.NiveauPrixConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BonCommandeConverter {
@Autowired private EntrepriseConverter entrepriseConverter;
@Autowired private NiveauPrixConverter niveauPrixConverter;
@Autowired private DevisConverter devisConverter;
@Autowired private FournisseurConverter fournisseurConverter;
@Autowired private BonCommandeTaxeConverter bonCommandeTaxeConverter;
@Autowired private BonCommandeProduitConverter bonCommandeProduitConverter;
@Autowired private BonCommandeTaxeExpeditionConverter bonCommandeTaxeExpeditionConverter;
@Autowired private LivraisonConverter livraisonConverter;
private boolean livraison = true;
private boolean bonCommandeTaxe = true;
private boolean bonCommandeTaxeExpedition = true;
private boolean bonCommandeProduit = true;
private boolean fournisseur = true;
private boolean entreprise = true;
private boolean devis = true;
private boolean niveauPrix = true;
protected void configure(boolean value) {
this.entrepriseConverter.setBonCommande(value);
this.niveauPrixConverter.setBonCommandes(value);
this.devisConverter.setBonCommandes(value);
this.fournisseurConverter.setBonCommandes(value);
this.bonCommandeTaxeConverter.setBonCommande(value);
this.bonCommandeProduitConverter.setBonCommande(value);
this.bonCommandeTaxeExpeditionConverter.setBonCommande(value);
}
public final BonCommandeDto toDto(BonCommande item) {
this.configure(false);
var dto = item != null ? convertToDto(item) : null;
this.configure(true);
return dto;
}
public final BonCommande toItem(BonCommandeDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<BonCommande> toItem(List<BonCommandeDto> dtos) {
if (dtos == null) return null;
List<BonCommande> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<BonCommandeDto> toDto(List<BonCommande> items) {
if (items == null) return null;
List<BonCommandeDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected BonCommande convertToItem(BonCommandeDto dto) {
var item = new BonCommande();
item.setId(dto.getId());
item.setCode(dto.getCode());
item.setDateCreation(dto.getDateCreation());
item.setDateExpedition(dto.getDateExpedition());
item.setRabais(dto.getRabais());
item.setTypeRabais(dto.getTypeRabais());
item.setRemiseGlobal(dto.getRemiseGlobal());
item.setTotalUnites(dto.getTotalUnites());
item.setSousTotal(dto.getSousTotal());
item.setTotal(dto.getTotal());
item.setStatut(dto.getStatut());
item.setLivraison(livraisonConverter.toItem(dto.getLivraison()));
item.setBonCommandeTaxe(bonCommandeTaxeConverter.toItem(dto.getBonCommandeTaxe()));
item.setBonCommandeTaxeExpedition(bonCommandeTaxeExpeditionConverter.toItem(dto.getBonCommandeTaxeExpedition()));
item.setBonCommandeProduit(bonCommandeProduitConverter.toItem(dto.getBonCommandeProduit()));
item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur()));
item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
item.setDevis(devisConverter.toItem(dto.getDevis()));
item.setNiveauPrix(niveauPrixConverter.toItem(dto.getNiveauPrix()));
return item;
}
protected BonCommandeDto convertToDto(BonCommande item) {
var dto = new BonCommandeDto();
dto.setId(item.getId());
dto.setCode(item.getCode());
dto.setDateCreation(item.getDateCreation());
dto.setDateExpedition(item.getDateExpedition());
dto.setRabais(item.getRabais());
dto.setTypeRabais(item.getTypeRabais());
dto.setRemiseGlobal(item.getRemiseGlobal());
dto.setTotalUnites(item.getTotalUnites());
dto.setSousTotal(item.getSousTotal());
dto.setTotal(item.getTotal());
dto.setStatut(item.getStatut());
dto.setLivraison(livraison? livraisonConverter.toDto(item.getLivraison()): null);
dto.setBonCommandeTaxe(bonCommandeTaxe? bonCommandeTaxeConverter.toDto(item.getBonCommandeTaxe()): null);
dto.setBonCommandeTaxeExpedition(bonCommandeTaxeExpedition? bonCommandeTaxeExpeditionConverter.toDto(item.getBonCommandeTaxeExpedition()): null);
dto.setBonCommandeProduit(bonCommandeProduit? bonCommandeProduitConverter.toDto(item.getBonCommandeProduit()): null);
dto.setFournisseur(fournisseur? fournisseurConverter.toDto(item.getFournisseur()): null);
dto.setEntreprise(entreprise? entrepriseConverter.toDto(item.getEntreprise()): null);
dto.setDevis(devis? devisConverter.toDto(item.getDevis()): null);
dto.setNiveauPrix(niveauPrix? niveauPrixConverter.toDto(item.getNiveauPrix()): null);
return dto;
}
public void setLivraison(boolean value) {
this.livraison = value;
}
public void setBonCommandeTaxe(boolean value) {
this.bonCommandeTaxe = value;
}
public void setBonCommandeTaxeExpedition(boolean value) {
this.bonCommandeTaxeExpedition = value;
}
public void setBonCommandeProduit(boolean value) {
this.bonCommandeProduit = value;
}
public void setFournisseur(boolean value) {
this.fournisseur = value;
}
public void setEntreprise(boolean value) {
this.entreprise = value;
}
public void setDevis(boolean value) {
this.devis = value;
}
public void setNiveauPrix(boolean value) {
this.niveauPrix = value;
}
public void setEntrepriseConverter(EntrepriseConverter value) {
this.entrepriseConverter = value;
}
public EntrepriseConverter getEntrepriseConverter() {
return entrepriseConverter;
}
public void setNiveauPrixConverter(NiveauPrixConverter value) {
this.niveauPrixConverter = value;
}
public NiveauPrixConverter getNiveauPrixConverter() {
return niveauPrixConverter;
}
public void setDevisConverter(DevisConverter value) {
this.devisConverter = value;
}
public DevisConverter getDevisConverter() {
return devisConverter;
}
public void setFournisseurConverter(FournisseurConverter value) {
this.fournisseurConverter = value;
}
public FournisseurConverter getFournisseurConverter() {
return fournisseurConverter;
}
public void setBonCommandeTaxeConverter(BonCommandeTaxeConverter value) {
this.bonCommandeTaxeConverter = value;
}
public BonCommandeTaxeConverter getBonCommandeTaxeConverter() {
return bonCommandeTaxeConverter;
}
public void setBonCommandeProduitConverter(BonCommandeProduitConverter value) {
this.bonCommandeProduitConverter = value;
}
public BonCommandeProduitConverter getBonCommandeProduitConverter() {
return bonCommandeProduitConverter;
}
public void setBonCommandeTaxeExpeditionConverter(BonCommandeTaxeExpeditionConverter value) {
this.bonCommandeTaxeExpeditionConverter = value;
}
public BonCommandeTaxeExpeditionConverter getBonCommandeTaxeExpeditionConverter() {
return bonCommandeTaxeExpeditionConverter;
}
public void setLivraisonConverter(LivraisonConverter value) {
this.livraisonConverter = value;
}
public LivraisonConverter getLivraisonConverter() {
return livraisonConverter;
}
}