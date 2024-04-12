package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.dao.parametres.DevisDao;
import org.sir.erplain.service.facade.parametres.DevisService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.bean.core.parametres.NouvelleDevise;
import org.sir.erplain.service.facade.parametres.NouvelleDeviseService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class DevisServiceImpl implements DevisService {
//--------------- FIND -------------------------------------
public Devis findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Devis> findAll() {
return dao.findAll();
}
public List<Devis> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Devis create(Devis item) {
if (item == null) return null;
Devis saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Devis> create(List<Devis> items) {
List<Devis> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Devis update(Devis item) {
if (item == null || item.getId() == null) return null;
Devis saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Devis> update(List<Devis> items) {
List<Devis> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Devis item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Devis item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Devis> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Devis item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNouvelleDeviseId(Long id){
if (id == null) return 0;
List<Devis> found = findByNouvelleDeviseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNouvelleDeviseId(id);
}
@Override
public List<Devis> findByNouvelleDeviseId(Long id){
return dao.findByNouvelleDeviseId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Devis item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Devis::getClients, Client::setDevis, clientService::create);
ServiceHelper.createList(item, Devis::getEstimations, Estimation::setDevis, estimationService::create);
ServiceHelper.createList(item, Devis::getCommandes, Commande::setDevis, commandeService::create);
ServiceHelper.createList(item, Devis::getFactures, Facture::setDevis, factureService::create);
ServiceHelper.createList(item, Devis::getNotesCredit, NoteCredit::setDevis, noteCreditService::create);
ServiceHelper.createList(item, Devis::getRemboursements, Remboursement::setDevis, remboursementService::create);
ServiceHelper.createList(item, Devis::getBonCommandes, BonCommande::setDevis, bonCommandeService::create);
}
public void updateAssociatedList(Devis item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, clientService.findByDevisId(item.getId()),
item.getClients(), Client::setDevis,
clientService::update,
clientService::delete
);
ServiceHelper.updateList(
item, estimationService.findByDevisId(item.getId()),
item.getEstimations(), Estimation::setDevis,
estimationService::update,
estimationService::delete
);
ServiceHelper.updateList(
item, commandeService.findByDevisId(item.getId()),
item.getCommandes(), Commande::setDevis,
commandeService::update,
commandeService::delete
);
ServiceHelper.updateList(
item, factureService.findByDevisId(item.getId()),
item.getFactures(), Facture::setDevis,
factureService::update,
factureService::delete
);
ServiceHelper.updateList(
item, noteCreditService.findByDevisId(item.getId()),
item.getNotesCredit(), NoteCredit::setDevis,
noteCreditService::update,
noteCreditService::delete
);
ServiceHelper.updateList(
item, remboursementService.findByDevisId(item.getId()),
item.getRemboursements(), Remboursement::setDevis,
remboursementService::update,
remboursementService::delete
);
ServiceHelper.updateList(
item, bonCommandeService.findByDevisId(item.getId()),
item.getBonCommandes(), BonCommande::setDevis,
bonCommandeService::update,
bonCommandeService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Devis item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Devis item) {
clientService.deleteByDevisId(item.getId());
estimationService.deleteByDevisId(item.getId());
commandeService.deleteByDevisId(item.getId());
factureService.deleteByDevisId(item.getId());
noteCreditService.deleteByDevisId(item.getId());
remboursementService.deleteByDevisId(item.getId());
bonCommandeService.deleteByDevisId(item.getId());
}
//----------------------------------------------------------
@Autowired private DevisDao dao;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EstimationService estimationService;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private NoteCreditService noteCreditService;
@Lazy @Autowired private RemboursementService remboursementService;
@Lazy @Autowired private BonCommandeService bonCommandeService;
@Lazy @Autowired private NouvelleDeviseService nouvelleDeviseService;
}