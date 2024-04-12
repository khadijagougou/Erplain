package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.dao.parametres.TaxeDao;
import org.sir.erplain.service.facade.parametres.TaxeService;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.service.facade.contacts.ClientTaxeService;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.service.facade.produit.ProduitTaxeService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeService;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeService;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditTaxeService;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementTaxeService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonTaxeExpeditionService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class TaxeServiceImpl implements TaxeService {
//--------------- FIND -------------------------------------
public Taxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Taxe> findAll() {
return dao.findAll();
}
public List<Taxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Taxe create(Taxe item) {
if (item == null) return null;
Taxe saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Taxe> create(List<Taxe> items) {
List<Taxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Taxe update(Taxe item) {
if (item == null || item.getId() == null) return null;
Taxe saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Taxe> update(List<Taxe> items) {
List<Taxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Taxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Taxe item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Taxe> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Taxe item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
public void createAssociatedList(Taxe item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Taxe::getClientTaxe, ClientTaxe::setTaxe, clientTaxeService::create);
ServiceHelper.createList(item, Taxe::getProduitTaxe, ProduitTaxe::setTaxe, produitTaxeService::create);
ServiceHelper.createList(item, Taxe::getEstimationTaxe, EstimationTaxe::setTaxe, estimationTaxeService::create);
ServiceHelper.createList(item, Taxe::getEstimationTaxeExpedition, EstimationTaxeExpedition::setTaxe, estimationTaxeExpeditionService::create);
ServiceHelper.createList(item, Taxe::getCommandeTaxe, CommandeTaxe::setTaxe, commandeTaxeService::create);
ServiceHelper.createList(item, Taxe::getCommandeTaxeExpedition, CommandeTaxeExpedition::setTaxe, commandeTaxeExpeditionService::create);
ServiceHelper.createList(item, Taxe::getFactureTaxe, FactureTaxe::setTaxe, factureTaxeService::create);
ServiceHelper.createList(item, Taxe::getFactureTaxeExpedition, FactureTaxeExpedition::setTaxe, factureTaxeExpeditionService::create);
ServiceHelper.createList(item, Taxe::getNoteCreditTaxe, NoteCreditTaxe::setTaxe, noteCreditTaxeService::create);
ServiceHelper.createList(item, Taxe::getRemboursementTaxe, RemboursementTaxe::setTaxe, remboursementTaxeService::create);
ServiceHelper.createList(item, Taxe::getBonCommandeTaxe, BonCommandeTaxe::setTaxe, bonCommandeTaxeService::create);
ServiceHelper.createList(item, Taxe::getBonCommandeTaxeExpedition, BonCommandeTaxeExpedition::setTaxe, bonCommandeTaxeExpeditionService::create);
ServiceHelper.createList(item, Taxe::getLivraisonTaxeExpedition, LivraisonTaxeExpedition::setTaxe, livraisonTaxeExpeditionService::create);
}
public void updateAssociatedList(Taxe item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, clientTaxeService.findByTaxeId(item.getId()),
item.getClientTaxe(), ClientTaxe::setTaxe,
clientTaxeService::update,
clientTaxeService::delete
);
ServiceHelper.updateList(
item, produitTaxeService.findByTaxeId(item.getId()),
item.getProduitTaxe(), ProduitTaxe::setTaxe,
produitTaxeService::update,
produitTaxeService::delete
);
ServiceHelper.updateList(
item, estimationTaxeService.findByTaxeId(item.getId()),
item.getEstimationTaxe(), EstimationTaxe::setTaxe,
estimationTaxeService::update,
estimationTaxeService::delete
);
ServiceHelper.updateList(
item, estimationTaxeExpeditionService.findByTaxeId(item.getId()),
item.getEstimationTaxeExpedition(), EstimationTaxeExpedition::setTaxe,
estimationTaxeExpeditionService::update,
estimationTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, commandeTaxeService.findByTaxeId(item.getId()),
item.getCommandeTaxe(), CommandeTaxe::setTaxe,
commandeTaxeService::update,
commandeTaxeService::delete
);
ServiceHelper.updateList(
item, commandeTaxeExpeditionService.findByTaxeId(item.getId()),
item.getCommandeTaxeExpedition(), CommandeTaxeExpedition::setTaxe,
commandeTaxeExpeditionService::update,
commandeTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, factureTaxeService.findByTaxeId(item.getId()),
item.getFactureTaxe(), FactureTaxe::setTaxe,
factureTaxeService::update,
factureTaxeService::delete
);
ServiceHelper.updateList(
item, factureTaxeExpeditionService.findByTaxeId(item.getId()),
item.getFactureTaxeExpedition(), FactureTaxeExpedition::setTaxe,
factureTaxeExpeditionService::update,
factureTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, noteCreditTaxeService.findByTaxeId(item.getId()),
item.getNoteCreditTaxe(), NoteCreditTaxe::setTaxe,
noteCreditTaxeService::update,
noteCreditTaxeService::delete
);
ServiceHelper.updateList(
item, remboursementTaxeService.findByTaxeId(item.getId()),
item.getRemboursementTaxe(), RemboursementTaxe::setTaxe,
remboursementTaxeService::update,
remboursementTaxeService::delete
);
ServiceHelper.updateList(
item, bonCommandeTaxeService.findByTaxeId(item.getId()),
item.getBonCommandeTaxe(), BonCommandeTaxe::setTaxe,
bonCommandeTaxeService::update,
bonCommandeTaxeService::delete
);
ServiceHelper.updateList(
item, bonCommandeTaxeExpeditionService.findByTaxeId(item.getId()),
item.getBonCommandeTaxeExpedition(), BonCommandeTaxeExpedition::setTaxe,
bonCommandeTaxeExpeditionService::update,
bonCommandeTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, livraisonTaxeExpeditionService.findByTaxeId(item.getId()),
item.getLivraisonTaxeExpedition(), LivraisonTaxeExpedition::setTaxe,
livraisonTaxeExpeditionService::update,
livraisonTaxeExpeditionService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Taxe item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Taxe item) {
clientTaxeService.deleteByTaxeId(item.getId());
produitTaxeService.deleteByTaxeId(item.getId());
estimationTaxeService.deleteByTaxeId(item.getId());
estimationTaxeExpeditionService.deleteByTaxeId(item.getId());
commandeTaxeService.deleteByTaxeId(item.getId());
commandeTaxeExpeditionService.deleteByTaxeId(item.getId());
factureTaxeService.deleteByTaxeId(item.getId());
factureTaxeExpeditionService.deleteByTaxeId(item.getId());
noteCreditTaxeService.deleteByTaxeId(item.getId());
remboursementTaxeService.deleteByTaxeId(item.getId());
bonCommandeTaxeService.deleteByTaxeId(item.getId());
bonCommandeTaxeExpeditionService.deleteByTaxeId(item.getId());
livraisonTaxeExpeditionService.deleteByTaxeId(item.getId());
}
//----------------------------------------------------------
@Autowired private TaxeDao dao;
@Lazy @Autowired private ClientTaxeService clientTaxeService;
@Lazy @Autowired private ProduitTaxeService produitTaxeService;
@Lazy @Autowired private EstimationTaxeService estimationTaxeService;
@Lazy @Autowired private EstimationTaxeExpeditionService estimationTaxeExpeditionService;
@Lazy @Autowired private CommandeTaxeService commandeTaxeService;
@Lazy @Autowired private CommandeTaxeExpeditionService commandeTaxeExpeditionService;
@Lazy @Autowired private FactureTaxeService factureTaxeService;
@Lazy @Autowired private FactureTaxeExpeditionService factureTaxeExpeditionService;
@Lazy @Autowired private NoteCreditTaxeService noteCreditTaxeService;
@Lazy @Autowired private RemboursementTaxeService remboursementTaxeService;
@Lazy @Autowired private BonCommandeTaxeService bonCommandeTaxeService;
@Lazy @Autowired private BonCommandeTaxeExpeditionService bonCommandeTaxeExpeditionService;
@Lazy @Autowired private LivraisonTaxeExpeditionService livraisonTaxeExpeditionService;
}