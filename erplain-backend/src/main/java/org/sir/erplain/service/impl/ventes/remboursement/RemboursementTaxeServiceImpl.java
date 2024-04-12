package org.sir.erplain.service.impl.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.dao.ventes.remboursement.RemboursementTaxeDao;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementTaxeService;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
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
public class RemboursementTaxeServiceImpl implements RemboursementTaxeService {
//--------------- FIND -------------------------------------
public RemboursementTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<RemboursementTaxe> findAll() {
return dao.findAll();
}
public List<RemboursementTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public RemboursementTaxe create(RemboursementTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<RemboursementTaxe> create(List<RemboursementTaxe> items) {
List<RemboursementTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public RemboursementTaxe update(RemboursementTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<RemboursementTaxe> update(List<RemboursementTaxe> items) {
List<RemboursementTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
RemboursementTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(RemboursementTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<RemboursementTaxe> items) {
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
public int deleteByRemboursementId(Long id){
if (id == null) return 0;
return dao.deleteByRemboursementId(id);
}
@Override
public List<RemboursementTaxe> findByRemboursementId(Long id){
return dao.findByRemboursementId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<RemboursementTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private RemboursementTaxeDao dao;
@Lazy @Autowired private RemboursementService remboursementService;
@Lazy @Autowired private TaxeService taxeService;
}