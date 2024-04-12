package org.sir.erplain.service.impl.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Admin;
import org.sir.erplain.dao.contacts.user.AdminDao;
import org.sir.erplain.service.facade.contacts.user.AdminService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
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
public class AdminServiceImpl implements AdminService {
//--------------- FIND -------------------------------------
public Admin findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Admin> findAll() {
return dao.findAll();
}
public List<Admin> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Admin create(Admin item) {
if (item == null) return null;
Admin saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Admin> create(List<Admin> items) {
List<Admin> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Admin update(Admin item) {
if (item == null || item.getId() == null) return null;
Admin saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Admin> update(List<Admin> items) {
List<Admin> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Admin item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Admin item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Admin> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Admin item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
Admin found = findByEntrepriseId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByEntrepriseId(id);
}
@Override
public Admin findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Admin::getAlertes, Alerte::setAdmin, alerteService::create);
}
public void updateAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, alerteService.findByAdminId(item.getId()),
item.getAlertes(), Alerte::setAdmin,
alerteService::update,
alerteService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Admin item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Admin item) {
alerteService.deleteByAdminId(item.getId());
}
//----------------------------------------------------------
@Autowired private AdminDao dao;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private AlerteService alerteService;
}