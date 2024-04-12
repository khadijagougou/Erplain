package org.sir.erplain.service.impl.parametres;
import org.sir.erplain.bean.core.parametres.NouvelleDevise;
import org.sir.erplain.dao.parametres.NouvelleDeviseDao;
import org.sir.erplain.service.facade.parametres.NouvelleDeviseService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class NouvelleDeviseServiceImpl implements NouvelleDeviseService {
//--------------- FIND -------------------------------------
public NouvelleDevise findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<NouvelleDevise> findAll() {
return dao.findAll();
}
public List<NouvelleDevise> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NouvelleDevise create(NouvelleDevise item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NouvelleDevise> create(List<NouvelleDevise> items) {
List<NouvelleDevise> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public NouvelleDevise update(NouvelleDevise item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<NouvelleDevise> update(List<NouvelleDevise> items) {
List<NouvelleDevise> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
NouvelleDevise item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(NouvelleDevise item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<NouvelleDevise> items) {
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
@Autowired private NouvelleDeviseDao dao;
}