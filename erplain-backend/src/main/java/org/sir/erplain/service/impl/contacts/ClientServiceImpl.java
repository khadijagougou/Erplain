package org.sir.erplain.service.impl.contacts;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.dao.contacts.ClientDao;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.service.facade.address.AddressService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.service.facade.contacts.ClientTaxeService;
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
public class ClientServiceImpl implements ClientService {
//--------------- FIND -------------------------------------
public Client findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Client> findAll() {
return dao.findAll();
}
public List<Client> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Client create(Client item) {
if (item == null) return null;
Client saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Client> create(List<Client> items) {
List<Client> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Client update(Client item) {
if (item == null || item.getId() == null) return null;
Client saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Client> update(List<Client> items) {
List<Client> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Client item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Client item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Client> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Client item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAddressId(Long id){
Client found = findByAddressId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByAddressId(id);
}
@Override
public Client findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Client> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Client> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<Client> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<Client> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<Client> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<Client> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Client item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Client::getEstimations, Estimation::setClient, estimationService::create);
ServiceHelper.createList(item, Client::getCommandes, Commande::setClient, commandeService::create);
ServiceHelper.createList(item, Client::getFactures, Facture::setClient, factureService::create);
ServiceHelper.createList(item, Client::getRetourProduits, RetourProduit::setClient, retourProduitService::create);
ServiceHelper.createList(item, Client::getNotesCredit, NoteCredit::setClient, noteCreditService::create);
ServiceHelper.createList(item, Client::getRemboursements, Remboursement::setClient, remboursementService::create);
ServiceHelper.createList(item, Client::getClientTaxe, ClientTaxe::setClient, clientTaxeService::create);
}
public void updateAssociatedList(Client item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, estimationService.findByClientId(item.getId()),
item.getEstimations(), Estimation::setClient,
estimationService::update,
estimationService::delete
);
ServiceHelper.updateList(
item, commandeService.findByClientId(item.getId()),
item.getCommandes(), Commande::setClient,
commandeService::update,
commandeService::delete
);
ServiceHelper.updateList(
item, factureService.findByClientId(item.getId()),
item.getFactures(), Facture::setClient,
factureService::update,
factureService::delete
);
ServiceHelper.updateList(
item, retourProduitService.findByClientId(item.getId()),
item.getRetourProduits(), RetourProduit::setClient,
retourProduitService::update,
retourProduitService::delete
);
ServiceHelper.updateList(
item, noteCreditService.findByClientId(item.getId()),
item.getNotesCredit(), NoteCredit::setClient,
noteCreditService::update,
noteCreditService::delete
);
ServiceHelper.updateList(
item, remboursementService.findByClientId(item.getId()),
item.getRemboursements(), Remboursement::setClient,
remboursementService::update,
remboursementService::delete
);
ServiceHelper.updateList(
item, clientTaxeService.findByClientId(item.getId()),
item.getClientTaxe(), ClientTaxe::setClient,
clientTaxeService::update,
clientTaxeService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Client item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Client item) {
estimationService.deleteByClientId(item.getId());
commandeService.deleteByClientId(item.getId());
factureService.deleteByClientId(item.getId());
retourProduitService.deleteByClientId(item.getId());
noteCreditService.deleteByClientId(item.getId());
remboursementService.deleteByClientId(item.getId());
clientTaxeService.deleteByClientId(item.getId());
}
//----------------------------------------------------------
@Autowired private ClientDao dao;
@Lazy @Autowired private AddressService addressService;
@Lazy @Autowired private EstimationService estimationService;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private RetourProduitService retourProduitService;
@Lazy @Autowired private NoteCreditService noteCreditService;
@Lazy @Autowired private RemboursementService remboursementService;
@Lazy @Autowired private ClientTaxeService clientTaxeService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}