package org.sir.erplain.service.impl.inventaire;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.dao.inventaire.NiveauStockDao;
import org.sir.erplain.service.facade.inventaire.NiveauStockService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.service.facade.produit.ProduitService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class NiveauStockServiceImpl implements NiveauStockService {
//--------------- FIND -------------------------------------
public NiveauStock findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<NiveauStock> findAll() {
return dao.findAll();
}
public List<NiveauStock> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NiveauStock create(NiveauStock item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NiveauStock> create(List<NiveauStock> items) {
List<NiveauStock> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NiveauStock update(NiveauStock item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NiveauStock> update(List<NiveauStock> items) {
List<NiveauStock> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
NiveauStock item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(NiveauStock item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<NiveauStock> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
NiveauStock item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<NiveauStock> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<NiveauStock> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
//----------------------------------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(NiveauStock item) {
deleteAssociatedObjects(item);
}
public void deleteAssociatedObjects(NiveauStock item) {
produitService.deleteByNiveauStockId(item.getId());
}
//----------------------------------------------------------
@Autowired private NiveauStockDao dao;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private ProduitService produitService;
}