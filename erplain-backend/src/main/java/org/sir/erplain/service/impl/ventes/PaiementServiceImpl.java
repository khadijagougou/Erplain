package org.sir.erplain.service.impl.ventes;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.dao.ventes.PaiementDao;
import org.sir.erplain.service.facade.ventes.PaiementService;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import org.sir.erplain.service.facade.parametres.MethodePaiementService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class PaiementServiceImpl implements PaiementService {
//--------------- FIND -------------------------------------
public Paiement findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Paiement> findAll() {
return dao.findAll();
}
public List<Paiement> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Paiement create(Paiement item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Paiement> create(List<Paiement> items) {
List<Paiement> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Paiement update(Paiement item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Paiement> update(List<Paiement> items) {
List<Paiement> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Paiement item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Paiement item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Paiement> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Paiement item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByMethodePaiementId(Long id){
if (id == null) return 0;
List<Paiement> found = findByMethodePaiementId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByMethodePaiementId(id);
}
@Override
public List<Paiement> findByMethodePaiementId(Long id){
return dao.findByMethodePaiementId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Paiement> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Paiement> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
//----------------------------------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Paiement item) {
deleteAssociatedObjects(item);
}
public void deleteAssociatedObjects(Paiement item) {
factureService.deleteByPaiementId(item.getId());
}
//----------------------------------------------------------
@Autowired private PaiementDao dao;
@Lazy @Autowired private MethodePaiementService methodePaiementService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private FactureService factureService;
}