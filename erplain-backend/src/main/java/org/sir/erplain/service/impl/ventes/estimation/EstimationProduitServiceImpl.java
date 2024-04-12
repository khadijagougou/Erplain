package org.sir.erplain.service.impl.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.dao.ventes.estimation.EstimationProduitDao;
import org.sir.erplain.service.facade.ventes.estimation.EstimationProduitService;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class EstimationProduitServiceImpl implements EstimationProduitService {
//--------------- FIND -------------------------------------
public EstimationProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<EstimationProduit> findAll() {
return dao.findAll();
}
public List<EstimationProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public EstimationProduit create(EstimationProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<EstimationProduit> create(List<EstimationProduit> items) {
List<EstimationProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public EstimationProduit update(EstimationProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<EstimationProduit> update(List<EstimationProduit> items) {
List<EstimationProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
EstimationProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(EstimationProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<EstimationProduit> items) {
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
public List<EstimationProduit> findByEstimationId(Long id){
return dao.findByEstimationId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private EstimationProduitDao dao;
@Lazy @Autowired private EstimationService estimationService;
}