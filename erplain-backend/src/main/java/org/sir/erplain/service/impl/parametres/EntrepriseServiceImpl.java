package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.dao.parametres.EntrepriseDao;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.service.facade.address.AddressService;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.service.facade.contacts.user.EmployeService;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.service.facade.produit.ProduitService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.service.facade.contacts.FournisseurService;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.service.facade.ventes.PaiementService;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.service.facade.ventes.CommandeExpeditionService;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.service.facade.inventaire.NiveauStockService;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.bean.core.contacts.user.Admin;
import org.sir.erplain.service.facade.contacts.user.AdminService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class EntrepriseServiceImpl implements EntrepriseService {
//--------------- FIND -------------------------------------
public Entreprise findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Entreprise> findAll() {
return dao.findAll();
}
public List<Entreprise> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Entreprise create(Entreprise item) {
if (item == null) return null;
Entreprise saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Entreprise> create(List<Entreprise> items) {
List<Entreprise> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Entreprise update(Entreprise item) {
if (item == null || item.getId() == null) return null;
Entreprise saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Entreprise> update(List<Entreprise> items) {
List<Entreprise> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Entreprise item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Entreprise item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Entreprise> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Entreprise item = findById(id);
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
Entreprise found = findByAddressId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByAddressId(id);
}
@Override
public Entreprise findByAddressId(Long id){
return dao.findByAddressId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Entreprise item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Entreprise::getEmployes, Employe::setEntreprise, employeService::create);
ServiceHelper.createList(item, Entreprise::getProduits, Produit::setEntreprise, produitService::create);
ServiceHelper.createList(item, Entreprise::getClients, Client::setEntreprise, clientService::create);
ServiceHelper.createList(item, Entreprise::getFournisseurs, Fournisseur::setEntreprise, fournisseurService::create);
ServiceHelper.createList(item, Entreprise::getPaiement, Paiement::setEntreprise, paiementService::create);
ServiceHelper.createList(item, Entreprise::getCommandeExpedition, CommandeExpedition::setEntreprise, commandeExpeditionService::create);
ServiceHelper.createList(item, Entreprise::getLivraison, Livraison::setEntreprise, livraisonService::create);
ServiceHelper.createList(item, Entreprise::getBonCommande, BonCommande::setEntreprise, bonCommandeService::create);
ServiceHelper.createList(item, Entreprise::getNiveauStock, NiveauStock::setEntreprise, niveauStockService::create);
ServiceHelper.createList(item, Entreprise::getRemboursement, Remboursement::setEntreprise, remboursementService::create);
ServiceHelper.createList(item, Entreprise::getNoteCredit, NoteCredit::setEntreprise, noteCreditService::create);
ServiceHelper.createList(item, Entreprise::getRetourProduit, RetourProduit::setEntreprise, retourProduitService::create);
ServiceHelper.createList(item, Entreprise::getFacture, Facture::setEntreprise, factureService::create);
ServiceHelper.createList(item, Entreprise::getCommande, Commande::setEntreprise, commandeService::create);
ServiceHelper.createList(item, Entreprise::getEstimation, Estimation::setEntreprise, estimationService::create);
}
public void updateAssociatedList(Entreprise item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, employeService.findByEntrepriseId(item.getId()),
item.getEmployes(), Employe::setEntreprise,
employeService::update,
employeService::delete
);
ServiceHelper.updateList(
item, produitService.findByEntrepriseId(item.getId()),
item.getProduits(), Produit::setEntreprise,
produitService::update,
produitService::delete
);
ServiceHelper.updateList(
item, clientService.findByEntrepriseId(item.getId()),
item.getClients(), Client::setEntreprise,
clientService::update,
clientService::delete
);
ServiceHelper.updateList(
item, fournisseurService.findByEntrepriseId(item.getId()),
item.getFournisseurs(), Fournisseur::setEntreprise,
fournisseurService::update,
fournisseurService::delete
);
ServiceHelper.updateList(
item, paiementService.findByEntrepriseId(item.getId()),
item.getPaiement(), Paiement::setEntreprise,
paiementService::update,
paiementService::delete
);
ServiceHelper.updateList(
item, commandeExpeditionService.findByEntrepriseId(item.getId()),
item.getCommandeExpedition(), CommandeExpedition::setEntreprise,
commandeExpeditionService::update,
commandeExpeditionService::delete
);
ServiceHelper.updateList(
item, livraisonService.findByEntrepriseId(item.getId()),
item.getLivraison(), Livraison::setEntreprise,
livraisonService::update,
livraisonService::delete
);
ServiceHelper.updateList(
item, bonCommandeService.findByEntrepriseId(item.getId()),
item.getBonCommande(), BonCommande::setEntreprise,
bonCommandeService::update,
bonCommandeService::delete
);
ServiceHelper.updateList(
item, niveauStockService.findByEntrepriseId(item.getId()),
item.getNiveauStock(), NiveauStock::setEntreprise,
niveauStockService::update,
niveauStockService::delete
);
ServiceHelper.updateList(
item, remboursementService.findByEntrepriseId(item.getId()),
item.getRemboursement(), Remboursement::setEntreprise,
remboursementService::update,
remboursementService::delete
);
ServiceHelper.updateList(
item, noteCreditService.findByEntrepriseId(item.getId()),
item.getNoteCredit(), NoteCredit::setEntreprise,
noteCreditService::update,
noteCreditService::delete
);
ServiceHelper.updateList(
item, retourProduitService.findByEntrepriseId(item.getId()),
item.getRetourProduit(), RetourProduit::setEntreprise,
retourProduitService::update,
retourProduitService::delete
);
ServiceHelper.updateList(
item, factureService.findByEntrepriseId(item.getId()),
item.getFacture(), Facture::setEntreprise,
factureService::update,
factureService::delete
);
ServiceHelper.updateList(
item, commandeService.findByEntrepriseId(item.getId()),
item.getCommande(), Commande::setEntreprise,
commandeService::update,
commandeService::delete
);
ServiceHelper.updateList(
item, estimationService.findByEntrepriseId(item.getId()),
item.getEstimation(), Estimation::setEntreprise,
estimationService::update,
estimationService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Entreprise item) {
deleteAssociatedList(item);
deleteAssociatedObjects(item);
}
public void deleteAssociatedList(Entreprise item) {
employeService.deleteByEntrepriseId(item.getId());
produitService.deleteByEntrepriseId(item.getId());
clientService.deleteByEntrepriseId(item.getId());
fournisseurService.deleteByEntrepriseId(item.getId());
paiementService.deleteByEntrepriseId(item.getId());
commandeExpeditionService.deleteByEntrepriseId(item.getId());
livraisonService.deleteByEntrepriseId(item.getId());
bonCommandeService.deleteByEntrepriseId(item.getId());
niveauStockService.deleteByEntrepriseId(item.getId());
remboursementService.deleteByEntrepriseId(item.getId());
noteCreditService.deleteByEntrepriseId(item.getId());
retourProduitService.deleteByEntrepriseId(item.getId());
factureService.deleteByEntrepriseId(item.getId());
commandeService.deleteByEntrepriseId(item.getId());
estimationService.deleteByEntrepriseId(item.getId());
}
public void deleteAssociatedObjects(Entreprise item) {
adminService.deleteByEntrepriseId(item.getId());
}
//----------------------------------------------------------
@Autowired private EntrepriseDao dao;
@Lazy @Autowired private AddressService addressService;
@Lazy @Autowired private EmployeService employeService;
@Lazy @Autowired private ProduitService produitService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private FournisseurService fournisseurService;
@Lazy @Autowired private PaiementService paiementService;
@Lazy @Autowired private CommandeExpeditionService commandeExpeditionService;
@Lazy @Autowired private LivraisonService livraisonService;
@Lazy @Autowired private BonCommandeService bonCommandeService;
@Lazy @Autowired private NiveauStockService niveauStockService;
@Lazy @Autowired private RemboursementService remboursementService;
@Lazy @Autowired private NoteCreditService noteCreditService;
@Lazy @Autowired private RetourProduitService retourProduitService;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private EstimationService estimationService;
@Lazy @Autowired private AdminService adminService;
}