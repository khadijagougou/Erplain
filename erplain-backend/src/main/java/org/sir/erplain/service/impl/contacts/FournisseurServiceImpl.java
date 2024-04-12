package org.sir.erplain.service.impl.contacts;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.dao.contacts.FournisseurDao;
import org.sir.erplain.service.facade.contacts.FournisseurService;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.service.facade.address.AddressService;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.service.facade.produit.ProduitService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
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
public class FournisseurServiceImpl implements FournisseurService {
//--------------- FIND -------------------------------------
public Fournisseur findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Fournisseur> findAll() {
return dao.findAll();
}
public List<Fournisseur> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Fournisseur create(Fournisseur item) {
if (item == null) return null;
Fournisseur saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Fournisseur> create(List<Fournisseur> items) {
List<Fournisseur> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Fournisseur update(Fournisseur item) {
if (item == null || item.getId() == null) return null;
Fournisseur saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Fournisseur> update(List<Fournisseur> items) {
List<Fournisseur> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Fournisseur item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Fournisseur item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Fournisseur> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Fournisseur item = findById(id);
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
Fournisseur found = findByAddressId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByAddressId(id);
}
@Override
public Fournisseur findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Fournisseur> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Fournisseur> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<Fournisseur> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<Fournisseur> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Fournisseur item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Fournisseur::getProduits, Produit::setFournisseur, produitService::create);
ServiceHelper.createList(item, Fournisseur::getBonCommandes, BonCommande::setFournisseur, bonCommandeService::create);
ServiceHelper.createList(item, Fournisseur::getLivraisons, Livraison::setFournisseur, livraisonService::create);
}
public void updateAssociatedList(Fournisseur item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, produitService.findByFournisseurId(item.getId()),
item.getProduits(), Produit::setFournisseur,
produitService::update,
produitService::delete
);
ServiceHelper.updateList(
item, bonCommandeService.findByFournisseurId(item.getId()),
item.getBonCommandes(), BonCommande::setFournisseur,
bonCommandeService::update,
bonCommandeService::delete
);
ServiceHelper.updateList(
item, livraisonService.findByFournisseurId(item.getId()),
item.getLivraisons(), Livraison::setFournisseur,
livraisonService::update,
livraisonService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Fournisseur item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Fournisseur item) {
produitService.deleteByFournisseurId(item.getId());
bonCommandeService.deleteByFournisseurId(item.getId());
livraisonService.deleteByFournisseurId(item.getId());
}
//----------------------------------------------------------
@Autowired private FournisseurDao dao;
@Lazy @Autowired private AddressService addressService;
@Lazy @Autowired private ProduitService produitService;
@Lazy @Autowired private BonCommandeService bonCommandeService;
@Lazy @Autowired private LivraisonService livraisonService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}