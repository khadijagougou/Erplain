package org.sir.erplain.service.impl.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.dao.ventes.facture.FactureDao;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.service.facade.ventes.PaiementService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitService;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeService;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.sir.erplain.service.facade.ventes.facture.FactureProduitService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.service.facade.parametres.DevisService;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.service.facade.parametres.NiveauPrixService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class FactureServiceImpl implements FactureService {
//--------------- FIND -------------------------------------
public Facture findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Facture> findAll() {
return dao.findAll();
}
public List<Facture> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Facture create(Facture item) {
if (item == null) return null;
Facture saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Facture> create(List<Facture> items) {
List<Facture> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Facture update(Facture item) {
if (item == null || item.getId() == null) return null;
Facture saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Facture> update(List<Facture> items) {
List<Facture> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Facture item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Facture item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Facture> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Facture item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByPaiementId(Long id){
Facture found = findByPaiementId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByPaiementId(id);
}
@Override
public Facture findByPaiementId(Long id){
return dao.findByPaiementId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
List<Facture> found = findByClientId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByClientId(id);
}
@Override
public List<Facture> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Facture> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Facture> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<Facture> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<Facture> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<Facture> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<Facture> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Facture item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Facture::getRetourProduit, RetourProduit::setFacture, retourProduitService::create);
ServiceHelper.createList(item, Facture::getFactureTaxe, FactureTaxe::setFacture, factureTaxeService::create);
ServiceHelper.createList(item, Facture::getFactureTaxeExpedition, FactureTaxeExpedition::setFacture, factureTaxeExpeditionService::create);
ServiceHelper.createList(item, Facture::getFactureProduit, FactureProduit::setFacture, factureProduitService::create);
}
public void updateAssociatedList(Facture item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, retourProduitService.findByFactureId(item.getId()),
item.getRetourProduit(), RetourProduit::setFacture,
retourProduitService::update,
retourProduitService::delete
);
ServiceHelper.updateList(
item, factureTaxeService.findByFactureId(item.getId()),
item.getFactureTaxe(), FactureTaxe::setFacture,
factureTaxeService::update,
factureTaxeService::delete
);
ServiceHelper.updateList(
item, factureTaxeExpeditionService.findByFactureId(item.getId()),
item.getFactureTaxeExpedition(), FactureTaxeExpedition::setFacture,
factureTaxeExpeditionService::update,
factureTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, factureProduitService.findByFactureId(item.getId()),
item.getFactureProduit(), FactureProduit::setFacture,
factureProduitService::update,
factureProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Facture item) {
deleteAssociatedList(item);
deleteAssociatedObjects(item);
}
public void deleteAssociatedList(Facture item) {
retourProduitService.deleteByFactureId(item.getId());
factureTaxeService.deleteByFactureId(item.getId());
factureTaxeExpeditionService.deleteByFactureId(item.getId());
factureProduitService.deleteByFactureId(item.getId());
}
public void deleteAssociatedObjects(Facture item) {
estimationService.deleteByFactureId(item.getId());
commandeService.deleteByFactureId(item.getId());
}
//----------------------------------------------------------
@Autowired private FactureDao dao;
@Lazy @Autowired private PaiementService paiementService;
@Lazy @Autowired private RetourProduitService retourProduitService;
@Lazy @Autowired private FactureTaxeService factureTaxeService;
@Lazy @Autowired private FactureTaxeExpeditionService factureTaxeExpeditionService;
@Lazy @Autowired private FactureProduitService factureProduitService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
@Lazy @Autowired private EstimationService estimationService;
@Lazy @Autowired private CommandeService commandeService;
}