package org.sir.erplain.service.impl.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.sir.erplain.dao.ventes.notecredit.NoteCreditProduitDao;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditProduitService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class NoteCreditProduitServiceImpl implements NoteCreditProduitService {
//--------------- FIND -------------------------------------
public NoteCreditProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<NoteCreditProduit> findAll() {
return dao.findAll();
}
public List<NoteCreditProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NoteCreditProduit create(NoteCreditProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NoteCreditProduit> create(List<NoteCreditProduit> items) {
List<NoteCreditProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NoteCreditProduit update(NoteCreditProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NoteCreditProduit> update(List<NoteCreditProduit> items) {
List<NoteCreditProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
NoteCreditProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(NoteCreditProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<NoteCreditProduit> items) {
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
public int deleteByNoteCreditId(Long id){
if (id == null) return 0;
return dao.deleteByNoteCreditId(id);
}
@Override
public List<NoteCreditProduit> findByNoteCreditId(Long id){
return dao.findByNoteCreditId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private NoteCreditProduitDao dao;
@Lazy @Autowired private NoteCreditService noteCreditService;
}