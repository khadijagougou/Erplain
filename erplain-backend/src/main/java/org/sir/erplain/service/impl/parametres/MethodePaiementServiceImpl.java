package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import org.sir.erplain.dao.parametres.MethodePaiementDao;
import org.sir.erplain.service.facade.parametres.MethodePaiementService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class MethodePaiementServiceImpl implements MethodePaiementService {
//--------------- FIND -------------------------------------
public MethodePaiement findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<MethodePaiement> findAll() {
return dao.findAll();
}
public List<MethodePaiement> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public MethodePaiement create(MethodePaiement item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<MethodePaiement> create(List<MethodePaiement> items) {
List<MethodePaiement> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public MethodePaiement update(MethodePaiement item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<MethodePaiement> update(List<MethodePaiement> items) {
List<MethodePaiement> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
MethodePaiement item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(MethodePaiement item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<MethodePaiement> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private MethodePaiementDao dao;
}