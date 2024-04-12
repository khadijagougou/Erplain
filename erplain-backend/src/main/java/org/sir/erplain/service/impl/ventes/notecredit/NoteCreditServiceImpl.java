package org.sir.erplain.service.impl.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.dao.ventes.notecredit.NoteCreditDao;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditTaxeService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditProduitService;
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
public class NoteCreditServiceImpl implements NoteCreditService {
//--------------- FIND -------------------------------------
public NoteCredit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<NoteCredit> findAll() {
return dao.findAll();
}
public List<NoteCredit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NoteCredit create(NoteCredit item) {
if (item == null) return null;
NoteCredit saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<NoteCredit> create(List<NoteCredit> items) {
List<NoteCredit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NoteCredit update(NoteCredit item) {
if (item == null || item.getId() == null) return null;
NoteCredit saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<NoteCredit> update(List<NoteCredit> items) {
List<NoteCredit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
NoteCredit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(NoteCredit item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<NoteCredit> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
NoteCredit item = findById(id);
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
List<NoteCredit> found = findByClientId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByClientId(id);
}
@Override
public List<NoteCredit> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByRetourProduitId(Long id){
if (id == null) return 0;
List<NoteCredit> found = findByRetourProduitId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByRetourProduitId(id);
}
@Override
public List<NoteCredit> findByRetourProduitId(Long id){
return dao.findByRetourProduitId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<NoteCredit> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<NoteCredit> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<NoteCredit> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<NoteCredit> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<NoteCredit> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<NoteCredit> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(NoteCredit item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, NoteCredit::getNoteCreditTaxe, NoteCreditTaxe::setNoteCredit, noteCreditTaxeService::create);
ServiceHelper.createList(item, NoteCredit::getNoteCreditProduit, NoteCreditProduit::setNoteCredit, noteCreditProduitService::create);
}
public void updateAssociatedList(NoteCredit item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, noteCreditTaxeService.findByNoteCreditId(item.getId()),
item.getNoteCreditTaxe(), NoteCreditTaxe::setNoteCredit,
noteCreditTaxeService::update,
noteCreditTaxeService::delete
);
ServiceHelper.updateList(
item, noteCreditProduitService.findByNoteCreditId(item.getId()),
item.getNoteCreditProduit(), NoteCreditProduit::setNoteCredit,
noteCreditProduitService::update,
noteCreditProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(NoteCredit item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(NoteCredit item) {
noteCreditTaxeService.deleteByNoteCreditId(item.getId());
noteCreditProduitService.deleteByNoteCreditId(item.getId());
}
//----------------------------------------------------------
@Autowired private NoteCreditDao dao;
@Lazy @Autowired private NoteCreditTaxeService noteCreditTaxeService;
@Lazy @Autowired private NoteCreditProduitService noteCreditProduitService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private RetourProduitService retourProduitService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}