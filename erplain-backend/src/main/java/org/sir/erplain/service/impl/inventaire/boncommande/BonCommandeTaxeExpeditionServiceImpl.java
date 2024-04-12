package org.sir.erplain.service.impl.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.dao.inventaire.boncommande.BonCommandeTaxeExpeditionDao;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeService;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.service.facade.parametres.TaxeService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class BonCommandeTaxeExpeditionServiceImpl implements BonCommandeTaxeExpeditionService {
//--------------- FIND -------------------------------------
public BonCommandeTaxeExpedition findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<BonCommandeTaxeExpedition> findAll() {
return dao.findAll();
}
public List<BonCommandeTaxeExpedition> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommandeTaxeExpedition create(BonCommandeTaxeExpedition item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommandeTaxeExpedition> create(List<BonCommandeTaxeExpedition> items) {
List<BonCommandeTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommandeTaxeExpedition update(BonCommandeTaxeExpedition item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommandeTaxeExpedition> update(List<BonCommandeTaxeExpedition> items) {
List<BonCommandeTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
BonCommandeTaxeExpedition item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(BonCommandeTaxeExpedition item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<BonCommandeTaxeExpedition> items) {
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
public List<BonCommandeTaxeExpedition> findByBonCommandeId(Long id){
return dao.findByBonCommandeId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<BonCommandeTaxeExpedition> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private BonCommandeTaxeExpeditionDao dao;
@Lazy @Autowired private BonCommandeService bonCommandeService;
@Lazy @Autowired private TaxeService taxeService;
}