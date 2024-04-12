package org.sir.erplain.service.impl.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.dao.ventes.facture.FactureTaxeDao;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
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
public class FactureTaxeServiceImpl implements FactureTaxeService {
//--------------- FIND -------------------------------------
public FactureTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<FactureTaxe> findAll() {
return dao.findAll();
}
public List<FactureTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public FactureTaxe create(FactureTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<FactureTaxe> create(List<FactureTaxe> items) {
List<FactureTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public FactureTaxe update(FactureTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<FactureTaxe> update(List<FactureTaxe> items) {
List<FactureTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
FactureTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(FactureTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<FactureTaxe> items) {
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
public List<FactureTaxe> findByFactureId(Long id){
return dao.findByFactureId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<FactureTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private FactureTaxeDao dao;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private TaxeService taxeService;
}