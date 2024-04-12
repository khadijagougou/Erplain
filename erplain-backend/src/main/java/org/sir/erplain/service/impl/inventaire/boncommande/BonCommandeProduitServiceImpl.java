package org.sir.erplain.service.impl.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.sir.erplain.dao.inventaire.boncommande.BonCommandeProduitDao;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeProduitService;
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
public class BonCommandeProduitServiceImpl implements BonCommandeProduitService {
//--------------- FIND -------------------------------------
public BonCommandeProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<BonCommandeProduit> findAll() {
return dao.findAll();
}
public List<BonCommandeProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommandeProduit create(BonCommandeProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommandeProduit> create(List<BonCommandeProduit> items) {
List<BonCommandeProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommandeProduit update(BonCommandeProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommandeProduit> update(List<BonCommandeProduit> items) {
List<BonCommandeProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
BonCommandeProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(BonCommandeProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<BonCommandeProduit> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByBonCommandeId(Long id){
if (id == null) return 0;
return dao.deleteByBonCommandeId(id);
}
@Override
public List<BonCommandeProduit> findByBonCommandeId(Long id){
return dao.findByBonCommandeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private BonCommandeProduitDao dao;
@Lazy @Autowired private BonCommandeService bonCommandeService;
}