package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.DestinataireEmploye;
import org.sir.erplain.dao.parametres.DestinataireEmployeDao;
import org.sir.erplain.service.facade.parametres.DestinataireEmployeService;
import org.sir.erplain.bean.core.parametres.Alerte;
import org.sir.erplain.service.facade.parametres.AlerteService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class DestinataireEmployeServiceImpl implements DestinataireEmployeService {
//--------------- FIND -------------------------------------
public DestinataireEmploye findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<DestinataireEmploye> findAll() {
return dao.findAll();
}
public List<DestinataireEmploye> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public DestinataireEmploye create(DestinataireEmploye item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<DestinataireEmploye> create(List<DestinataireEmploye> items) {
List<DestinataireEmploye> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public DestinataireEmploye update(DestinataireEmploye item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<DestinataireEmploye> update(List<DestinataireEmploye> items) {
List<DestinataireEmploye> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
DestinataireEmploye item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(DestinataireEmploye item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<DestinataireEmploye> items) {
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
public int deleteByAlerteId(Long id){
if (id == null) return 0;
return dao.deleteByAlerteId(id);
}
@Override
public List<DestinataireEmploye> findByAlerteId(Long id){
return dao.findByAlerteId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private DestinataireEmployeDao dao;
@Lazy @Autowired private AlerteService alerteService;
}