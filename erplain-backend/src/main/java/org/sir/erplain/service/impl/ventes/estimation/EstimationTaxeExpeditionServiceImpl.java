package org.sir.erplain.service.impl.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.dao.ventes.estimation.EstimationTaxeExpeditionDao;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
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
public class EstimationTaxeExpeditionServiceImpl implements EstimationTaxeExpeditionService {
//--------------- FIND -------------------------------------
public EstimationTaxeExpedition findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<EstimationTaxeExpedition> findAll() {
return dao.findAll();
}
public List<EstimationTaxeExpedition> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public EstimationTaxeExpedition create(EstimationTaxeExpedition item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<EstimationTaxeExpedition> create(List<EstimationTaxeExpedition> items) {
List<EstimationTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public EstimationTaxeExpedition update(EstimationTaxeExpedition item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<EstimationTaxeExpedition> update(List<EstimationTaxeExpedition> items) {
List<EstimationTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
EstimationTaxeExpedition item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(EstimationTaxeExpedition item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<EstimationTaxeExpedition> items) {
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
public int deleteByEstimationId(Long id){
if (id == null) return 0;
return dao.deleteByEstimationId(id);
}
@Override
public List<EstimationTaxeExpedition> findByEstimationId(Long id){
return dao.findByEstimationId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<EstimationTaxeExpedition> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private EstimationTaxeExpeditionDao dao;
@Lazy @Autowired private EstimationService estimationService;
@Lazy @Autowired private TaxeService taxeService;
}