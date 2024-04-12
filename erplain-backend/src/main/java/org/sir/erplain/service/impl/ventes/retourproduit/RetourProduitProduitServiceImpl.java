package org.sir.erplain.service.impl.ventes.retourproduit;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduitProduit;
import org.sir.erplain.dao.ventes.retourproduit.RetourProduitProduitDao;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitProduitService;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.service.facade.ventes.retourproduit.RetourProduitService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class RetourProduitProduitServiceImpl implements RetourProduitProduitService {
//--------------- FIND -------------------------------------
public RetourProduitProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<RetourProduitProduit> findAll() {
return dao.findAll();
}
public List<RetourProduitProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public RetourProduitProduit create(RetourProduitProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<RetourProduitProduit> create(List<RetourProduitProduit> items) {
List<RetourProduitProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public RetourProduitProduit update(RetourProduitProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<RetourProduitProduit> update(List<RetourProduitProduit> items) {
List<RetourProduitProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
RetourProduitProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(RetourProduitProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<RetourProduitProduit> items) {
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
public int deleteByRetourProduitId(Long id){
if (id == null) return 0;
return dao.deleteByRetourProduitId(id);
}
@Override
public List<RetourProduitProduit> findByRetourProduitId(Long id){
return dao.findByRetourProduitId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private RetourProduitProduitDao dao;
@Lazy @Autowired private RetourProduitService retourProduitService;
}