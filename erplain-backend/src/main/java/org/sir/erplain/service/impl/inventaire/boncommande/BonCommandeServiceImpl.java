package org.sir.erplain.service.impl.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.dao.inventaire.boncommande.BonCommandeDao;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeProduitService;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.service.facade.contacts.FournisseurService;
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
public class BonCommandeServiceImpl implements BonCommandeService {
//--------------- FIND -------------------------------------
public BonCommande findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<BonCommande> findAll() {
return dao.findAll();
}
public List<BonCommande> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommande create(BonCommande item) {
if (item == null) return null;
BonCommande saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommande> create(List<BonCommande> items) {
List<BonCommande> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommande update(BonCommande item) {
if (item == null || item.getId() == null) return null;
BonCommande saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommande> update(List<BonCommande> items) {
List<BonCommande> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
BonCommande item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(BonCommande item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<BonCommande> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
BonCommande item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByLivraisonId(Long id){
BonCommande found = findByLivraisonId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByLivraisonId(id);
}
@Override
public BonCommande findByLivraisonId(Long id){
return dao.findByLivraisonId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByFournisseurId(Long id){
if (id == null) return 0;
List<BonCommande> found = findByFournisseurId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByFournisseurId(id);
}
@Override
public List<BonCommande> findByFournisseurId(Long id){
return dao.findByFournisseurId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<BonCommande> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<BonCommande> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<BonCommande> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<BonCommande> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<BonCommande> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<BonCommande> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(BonCommande item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, BonCommande::getBonCommandeTaxe, BonCommandeTaxe::setBonCommande, bonCommandeTaxeService::create);
ServiceHelper.createList(item, BonCommande::getBonCommandeTaxeExpedition, BonCommandeTaxeExpedition::setBonCommande, bonCommandeTaxeExpeditionService::create);
ServiceHelper.createList(item, BonCommande::getBonCommandeProduit, BonCommandeProduit::setBonCommande, bonCommandeProduitService::create);
}
public void updateAssociatedList(BonCommande item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, bonCommandeTaxeService.findByBonCommandeId(item.getId()),
item.getBonCommandeTaxe(), BonCommandeTaxe::setBonCommande,
bonCommandeTaxeService::update,
bonCommandeTaxeService::delete
);
ServiceHelper.updateList(
item, bonCommandeTaxeExpeditionService.findByBonCommandeId(item.getId()),
item.getBonCommandeTaxeExpedition(), BonCommandeTaxeExpedition::setBonCommande,
bonCommandeTaxeExpeditionService::update,
bonCommandeTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, bonCommandeProduitService.findByBonCommandeId(item.getId()),
item.getBonCommandeProduit(), BonCommandeProduit::setBonCommande,
bonCommandeProduitService::update,
bonCommandeProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(BonCommande item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(BonCommande item) {
bonCommandeTaxeService.deleteByBonCommandeId(item.getId());
bonCommandeTaxeExpeditionService.deleteByBonCommandeId(item.getId());
bonCommandeProduitService.deleteByBonCommandeId(item.getId());
}
//----------------------------------------------------------
@Autowired private BonCommandeDao dao;
@Lazy @Autowired private LivraisonService livraisonService;
@Lazy @Autowired private BonCommandeTaxeService bonCommandeTaxeService;
@Lazy @Autowired private BonCommandeTaxeExpeditionService bonCommandeTaxeExpeditionService;
@Lazy @Autowired private BonCommandeProduitService bonCommandeProduitService;
@Lazy @Autowired private FournisseurService fournisseurService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}