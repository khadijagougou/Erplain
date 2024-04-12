package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.dao.parametres.NiveauPrixDao;
import org.sir.erplain.service.facade.parametres.NiveauPrixService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.service.facade.contacts.FournisseurService;
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
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class NiveauPrixServiceImpl implements NiveauPrixService {
//--------------- FIND -------------------------------------
public NiveauPrix findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<NiveauPrix> findAll() {
return dao.findAll();
}
public List<NiveauPrix> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NiveauPrix create(NiveauPrix item) {
if (item == null) return null;
NiveauPrix saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<NiveauPrix> create(List<NiveauPrix> items) {
List<NiveauPrix> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NiveauPrix update(NiveauPrix item) {
if (item == null || item.getId() == null) return null;
NiveauPrix saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<NiveauPrix> update(List<NiveauPrix> items) {
List<NiveauPrix> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
NiveauPrix item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(NiveauPrix item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<NiveauPrix> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
NiveauPrix item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
public void createAssociatedList(NiveauPrix item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, NiveauPrix::getClients, Client::setNiveauPrix, clientService::create);
ServiceHelper.createList(item, NiveauPrix::getFournisseurs, Fournisseur::setNiveauPrix, fournisseurService::create);
ServiceHelper.createList(item, NiveauPrix::getEstimations, Estimation::setNiveauPrix, estimationService::create);
ServiceHelper.createList(item, NiveauPrix::getCommandes, Commande::setNiveauPrix, commandeService::create);
ServiceHelper.createList(item, NiveauPrix::getFactures, Facture::setNiveauPrix, factureService::create);
ServiceHelper.createList(item, NiveauPrix::getNotesCredit, NoteCredit::setNiveauPrix, noteCreditService::create);
ServiceHelper.createList(item, NiveauPrix::getRemboursements, Remboursement::setNiveauPrix, remboursementService::create);
ServiceHelper.createList(item, NiveauPrix::getBonCommandes, BonCommande::setNiveauPrix, bonCommandeService::create);
}
public void updateAssociatedList(NiveauPrix item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, clientService.findByNiveauPrixId(item.getId()),
item.getClients(), Client::setNiveauPrix,
clientService::update,
clientService::delete
);
ServiceHelper.updateList(
item, fournisseurService.findByNiveauPrixId(item.getId()),
item.getFournisseurs(), Fournisseur::setNiveauPrix,
fournisseurService::update,
fournisseurService::delete
);
ServiceHelper.updateList(
item, estimationService.findByNiveauPrixId(item.getId()),
item.getEstimations(), Estimation::setNiveauPrix,
estimationService::update,
estimationService::delete
);
ServiceHelper.updateList(
item, commandeService.findByNiveauPrixId(item.getId()),
item.getCommandes(), Commande::setNiveauPrix,
commandeService::update,
commandeService::delete
);
ServiceHelper.updateList(
item, factureService.findByNiveauPrixId(item.getId()),
item.getFactures(), Facture::setNiveauPrix,
factureService::update,
factureService::delete
);
ServiceHelper.updateList(
item, noteCreditService.findByNiveauPrixId(item.getId()),
item.getNotesCredit(), NoteCredit::setNiveauPrix,
noteCreditService::update,
noteCreditService::delete
);
ServiceHelper.updateList(
item, remboursementService.findByNiveauPrixId(item.getId()),
item.getRemboursements(), Remboursement::setNiveauPrix,
remboursementService::update,
remboursementService::delete
);
ServiceHelper.updateList(
item, bonCommandeService.findByNiveauPrixId(item.getId()),
item.getBonCommandes(), BonCommande::setNiveauPrix,
bonCommandeService::update,
bonCommandeService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(NiveauPrix item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(NiveauPrix item) {
clientService.deleteByNiveauPrixId(item.getId());
fournisseurService.deleteByNiveauPrixId(item.getId());
estimationService.deleteByNiveauPrixId(item.getId());
commandeService.deleteByNiveauPrixId(item.getId());
factureService.deleteByNiveauPrixId(item.getId());
noteCreditService.deleteByNiveauPrixId(item.getId());
remboursementService.deleteByNiveauPrixId(item.getId());
bonCommandeService.deleteByNiveauPrixId(item.getId());
}
//----------------------------------------------------------
@Autowired private NiveauPrixDao dao;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private FournisseurService fournisseurService;
@Lazy @Autowired private EstimationService estimationService;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private NoteCreditService noteCreditService;
@Lazy @Autowired private RemboursementService remboursementService;
@Lazy @Autowired private BonCommandeService bonCommandeService;
}