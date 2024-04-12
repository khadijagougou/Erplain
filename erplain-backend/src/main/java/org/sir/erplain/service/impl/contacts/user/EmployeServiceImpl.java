package org.sir.erplain.service.impl.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.dao.contacts.user.EmployeDao;
import org.sir.erplain.service.facade.contacts.user.EmployeService;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.service.facade.address.AddressService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class EmployeServiceImpl implements EmployeService {
//--------------- FIND -------------------------------------
public Employe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Employe> findAll() {
return dao.findAll();
}
public List<Employe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Employe create(Employe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Employe> create(List<Employe> items) {
List<Employe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Employe update(Employe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Employe> update(List<Employe> items) {
List<Employe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Employe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Employe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Employe> items) {
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
public int deleteByAddressId(Long id){
return dao.deleteByAddressId(id);
}
@Override
public Employe findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Employe> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private EmployeDao dao;
@Lazy @Autowired private AddressService addressService;
@Lazy @Autowired private EntrepriseService entrepriseService;
}