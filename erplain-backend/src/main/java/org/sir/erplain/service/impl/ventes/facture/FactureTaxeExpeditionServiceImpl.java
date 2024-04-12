package org.sir.erplain.service.impl.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.dao.ventes.facture.FactureTaxeExpeditionDao;
import org.sir.erplain.service.facade.ventes.facture.FactureTaxeExpeditionService;
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
public class FactureTaxeExpeditionServiceImpl implements FactureTaxeExpeditionService {
//--------------- FIND -------------------------------------
public FactureTaxeExpedition findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<FactureTaxeExpedition> findAll() {
return dao.findAll();
}
public List<FactureTaxeExpedition> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public FactureTaxeExpedition create(FactureTaxeExpedition item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<FactureTaxeExpedition> create(List<FactureTaxeExpedition> items) {
List<FactureTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public FactureTaxeExpedition update(FactureTaxeExpedition item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<FactureTaxeExpedition> update(List<FactureTaxeExpedition> items) {
List<FactureTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
FactureTaxeExpedition item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(FactureTaxeExpedition item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<FactureTaxeExpedition> items) {
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
public List<FactureTaxeExpedition> findByFactureId(Long id){
return dao.findByFactureId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<FactureTaxeExpedition> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private FactureTaxeExpeditionDao dao;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private TaxeService taxeService;
}