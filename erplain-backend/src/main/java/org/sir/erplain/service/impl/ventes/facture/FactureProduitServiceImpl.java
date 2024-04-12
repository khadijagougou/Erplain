package org.sir.erplain.service.impl.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.sir.erplain.dao.ventes.facture.FactureProduitDao;
import org.sir.erplain.service.facade.ventes.facture.FactureProduitService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class FactureProduitServiceImpl implements FactureProduitService {
//--------------- FIND -------------------------------------
public FactureProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<FactureProduit> findAll() {
return dao.findAll();
}
public List<FactureProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public FactureProduit create(FactureProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<FactureProduit> create(List<FactureProduit> items) {
List<FactureProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public FactureProduit update(FactureProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<FactureProduit> update(List<FactureProduit> items) {
List<FactureProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
FactureProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(FactureProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<FactureProduit> items) {
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
public int deleteByFactureId(Long id){
if (id == null) return 0;
return dao.deleteByFactureId(id);
}
@Override
public List<FactureProduit> findByFactureId(Long id){
return dao.findByFactureId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private FactureProduitDao dao;
@Lazy @Autowired private FactureService factureService;
}