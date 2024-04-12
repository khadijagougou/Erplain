package org.sir.erplain.service.impl.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.dao.inventaire.livraison.LivraisonDao;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonProduitService;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.service.facade.contacts.FournisseurService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
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
public class LivraisonServiceImpl implements LivraisonService {
//--------------- FIND -------------------------------------
public Livraison findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Livraison> findAll() {
return dao.findAll();
}
public List<Livraison> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Livraison create(Livraison item) {
if (item == null) return null;
Livraison saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Livraison> create(List<Livraison> items) {
List<Livraison> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Livraison update(Livraison item) {
if (item == null || item.getId() == null) return null;
Livraison saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Livraison> update(List<Livraison> items) {
List<Livraison> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Livraison item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Livraison item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Livraison> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Livraison item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByFournisseurId(Long id){
if (id == null) return 0;
List<Livraison> found = findByFournisseurId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByFournisseurId(id);
}
@Override
public List<Livraison> findByFournisseurId(Long id){
return dao.findByFournisseurId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Livraison> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Livraison> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Livraison item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Livraison::getLivraisonTaxeExpedition, LivraisonTaxeExpedition::setLivraison, livraisonTaxeExpeditionService::create);
ServiceHelper.createList(item, Livraison::getLivraisonProduit, LivraisonProduit::setLivraison, livraisonProduitService::create);
}
public void updateAssociatedList(Livraison item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, livraisonTaxeExpeditionService.findByLivraisonId(item.getId()),
item.getLivraisonTaxeExpedition(), LivraisonTaxeExpedition::setLivraison,
livraisonTaxeExpeditionService::update,
livraisonTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, livraisonProduitService.findByLivraisonId(item.getId()),
item.getLivraisonProduit(), LivraisonProduit::setLivraison,
livraisonProduitService::update,
livraisonProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Livraison item) {
deleteAssociatedList(item);
deleteAssociatedObjects(item);
}
public void deleteAssociatedList(Livraison item) {
livraisonTaxeExpeditionService.deleteByLivraisonId(item.getId());
livraisonProduitService.deleteByLivraisonId(item.getId());
}
public void deleteAssociatedObjects(Livraison item) {
bonCommandeService.deleteByLivraisonId(item.getId());
}
//----------------------------------------------------------
@Autowired private LivraisonDao dao;
@Lazy @Autowired private LivraisonTaxeExpeditionService livraisonTaxeExpeditionService;
@Lazy @Autowired private LivraisonProduitService livraisonProduitService;
@Lazy @Autowired private FournisseurService fournisseurService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private BonCommandeService bonCommandeService;
}