package org.sir.erplain.service.impl.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.dao.ventes.remboursement.RemboursementProduitDao;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementProduitService;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.service.facade.ventes.remboursement.RemboursementService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class RemboursementProduitServiceImpl implements RemboursementProduitService {
//--------------- FIND -------------------------------------
public RemboursementProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<RemboursementProduit> findAll() {
return dao.findAll();
}
public List<RemboursementProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public RemboursementProduit create(RemboursementProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<RemboursementProduit> create(List<RemboursementProduit> items) {
List<RemboursementProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public RemboursementProduit update(RemboursementProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<RemboursementProduit> update(List<RemboursementProduit> items) {
List<RemboursementProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
RemboursementProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(RemboursementProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<RemboursementProduit> items) {
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
public List<RemboursementProduit> findByRemboursementId(Long id){
return dao.findByRemboursementId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private RemboursementProduitDao dao;
@Lazy @Autowired private RemboursementService remboursementService;
}