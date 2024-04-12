package org.sir.erplain.service.impl.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.dao.ventes.remboursement.RemboursementDao;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementTaxeService;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementProduitService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitService;
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
public class RemboursementServiceImpl implements RemboursementService {
//--------------- FIND -------------------------------------
public Remboursement findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Remboursement> findAll() {
return dao.findAll();
}
public List<Remboursement> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Remboursement create(Remboursement item) {
if (item == null) return null;
Remboursement saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Remboursement> create(List<Remboursement> items) {
List<Remboursement> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Remboursement update(Remboursement item) {
if (item == null || item.getId() == null) return null;
Remboursement saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Remboursement> update(List<Remboursement> items) {
List<Remboursement> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Remboursement item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Remboursement item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Remboursement> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Remboursement item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
List<Remboursement> found = findByClientId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByClientId(id);
}
@Override
public List<Remboursement> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByRetourProduitId(Long id){
if (id == null) return 0;
List<Remboursement> found = findByRetourProduitId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByRetourProduitId(id);
}
@Override
public List<Remboursement> findByRetourProduitId(Long id){
return dao.findByRetourProduitId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Remboursement> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Remboursement> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<Remboursement> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<Remboursement> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<Remboursement> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<Remboursement> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Remboursement item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Remboursement::getRemboursementTaxe, RemboursementTaxe::setRemboursement, remboursementTaxeService::create);
ServiceHelper.createList(item, Remboursement::getRemboursementProduit, RemboursementProduit::setRemboursement, remboursementProduitService::create);
}
public void updateAssociatedList(Remboursement item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, remboursementTaxeService.findByRemboursementId(item.getId()),
item.getRemboursementTaxe(), RemboursementTaxe::setRemboursement,
remboursementTaxeService::update,
remboursementTaxeService::delete
);
ServiceHelper.updateList(
item, remboursementProduitService.findByRemboursementId(item.getId()),
item.getRemboursementProduit(), RemboursementProduit::setRemboursement,
remboursementProduitService::update,
remboursementProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Remboursement item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Remboursement item) {
remboursementTaxeService.deleteByRemboursementId(item.getId());
remboursementProduitService.deleteByRemboursementId(item.getId());
}
//----------------------------------------------------------
@Autowired private RemboursementDao dao;
@Lazy @Autowired private RemboursementTaxeService remboursementTaxeService;
@Lazy @Autowired private RemboursementProduitService remboursementProduitService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private RetourProduitService retourProduitService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}