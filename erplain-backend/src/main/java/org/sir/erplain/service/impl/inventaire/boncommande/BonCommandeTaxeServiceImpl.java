package org.sir.erplain.service.impl.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.dao.inventaire.boncommande.BonCommandeTaxeDao;
import org.sir.erplain.service.facade.inventaire.boncommande.BonCommandeTaxeService;
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
public class BonCommandeTaxeServiceImpl implements BonCommandeTaxeService {
//--------------- FIND -------------------------------------
public BonCommandeTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<BonCommandeTaxe> findAll() {
return dao.findAll();
}
public List<BonCommandeTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommandeTaxe create(BonCommandeTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommandeTaxe> create(List<BonCommandeTaxe> items) {
List<BonCommandeTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public BonCommandeTaxe update(BonCommandeTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<BonCommandeTaxe> update(List<BonCommandeTaxe> items) {
List<BonCommandeTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
BonCommandeTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(BonCommandeTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<BonCommandeTaxe> items) {
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
public List<BonCommandeTaxe> findByBonCommandeId(Long id){
return dao.findByBonCommandeId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<BonCommandeTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private BonCommandeTaxeDao dao;
@Lazy @Autowired private BonCommandeService bonCommandeService;
@Lazy @Autowired private TaxeService taxeService;
}