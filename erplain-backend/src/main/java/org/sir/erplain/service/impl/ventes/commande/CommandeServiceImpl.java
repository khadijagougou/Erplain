package org.sir.erplain.service.impl.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.dao.ventes.commande.CommandeDao;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.service.facade.ventes.CommandeExpeditionService;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeService;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.sir.erplain.service.facade.ventes.commande.CommandeProduitService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.service.facade.parametres.DevisService;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.service.facade.parametres.NiveauPrixService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class CommandeServiceImpl implements CommandeService {
//--------------- FIND -------------------------------------
public Commande findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Commande> findAll() {
return dao.findAll();
}
public List<Commande> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Commande create(Commande item) {
if (item == null) return null;
Commande saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Commande> create(List<Commande> items) {
List<Commande> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Commande update(Commande item) {
if (item == null || item.getId() == null) return null;
Commande saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Commande> update(List<Commande> items) {
List<Commande> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Commande item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Commande item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Commande> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Commande item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByFactureId(Long id){
Commande found = findByFactureId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByFactureId(id);
}
@Override
public Commande findByFactureId(Long id){
return dao.findByFactureId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
List<Commande> found = findByClientId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByClientId(id);
}
@Override
public List<Commande> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Commande> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Commande> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<Commande> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<Commande> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<Commande> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<Commande> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Commande item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Commande::getCommandeExpedition, CommandeExpedition::setCommande, commandeExpeditionService::create);
ServiceHelper.createList(item, Commande::getCommandeTaxe, CommandeTaxe::setCommande, commandeTaxeService::create);
ServiceHelper.createList(item, Commande::getCommandeTaxeExpedition, CommandeTaxeExpedition::setCommande, commandeTaxeExpeditionService::create);
ServiceHelper.createList(item, Commande::getCommandeProduit, CommandeProduit::setCommande, commandeProduitService::create);
}
public void updateAssociatedList(Commande item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, commandeExpeditionService.findByCommandeId(item.getId()),
item.getCommandeExpedition(), CommandeExpedition::setCommande,
commandeExpeditionService::update,
commandeExpeditionService::delete
);
ServiceHelper.updateList(
item, commandeTaxeService.findByCommandeId(item.getId()),
item.getCommandeTaxe(), CommandeTaxe::setCommande,
commandeTaxeService::update,
commandeTaxeService::delete
);
ServiceHelper.updateList(
item, commandeTaxeExpeditionService.findByCommandeId(item.getId()),
item.getCommandeTaxeExpedition(), CommandeTaxeExpedition::setCommande,
commandeTaxeExpeditionService::update,
commandeTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, commandeProduitService.findByCommandeId(item.getId()),
item.getCommandeProduit(), CommandeProduit::setCommande,
commandeProduitService::update,
commandeProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Commande item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Commande item) {
commandeExpeditionService.deleteByCommandeId(item.getId());
commandeTaxeService.deleteByCommandeId(item.getId());
commandeTaxeExpeditionService.deleteByCommandeId(item.getId());
commandeProduitService.deleteByCommandeId(item.getId());
}
//----------------------------------------------------------
@Autowired private CommandeDao dao;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private CommandeExpeditionService commandeExpeditionService;
@Lazy @Autowired private CommandeTaxeService commandeTaxeService;
@Lazy @Autowired private CommandeTaxeExpeditionService commandeTaxeExpeditionService;
@Lazy @Autowired private CommandeProduitService commandeProduitService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}