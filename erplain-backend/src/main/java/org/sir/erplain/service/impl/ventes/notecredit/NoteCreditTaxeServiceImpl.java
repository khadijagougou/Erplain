package org.sir.erplain.service.impl.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.dao.ventes.notecredit.NoteCreditTaxeDao;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditTaxeService;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.service.facade.ventes.notecredit.NoteCreditService;
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
public class NoteCreditTaxeServiceImpl implements NoteCreditTaxeService {
//--------------- FIND -------------------------------------
public NoteCreditTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<NoteCreditTaxe> findAll() {
return dao.findAll();
}
public List<NoteCreditTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NoteCreditTaxe create(NoteCreditTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NoteCreditTaxe> create(List<NoteCreditTaxe> items) {
List<NoteCreditTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NoteCreditTaxe update(NoteCreditTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NoteCreditTaxe> update(List<NoteCreditTaxe> items) {
List<NoteCreditTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
NoteCreditTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(NoteCreditTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<NoteCreditTaxe> items) {
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
public List<NoteCreditTaxe> findByNoteCreditId(Long id){
return dao.findByNoteCreditId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<NoteCreditTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private NoteCreditTaxeDao dao;
@Lazy @Autowired private NoteCreditService noteCreditService;
@Lazy @Autowired private TaxeService taxeService;
}