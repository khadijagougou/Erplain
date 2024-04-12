package org.sir.erplain.service.impl.address;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.dao.address.AddressDao;
import org.sir.erplain.service.facade.address.AddressService;
import org.sir.erplain.bean.core.address.Country;
import org.sir.erplain.service.facade.address.CountryService;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.service.facade.contacts.FournisseurService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.service.facade.contacts.user.EmployeService;
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
public class AddressServiceImpl implements AddressService {
//--------------- FIND -------------------------------------
public Address findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Address> findAll() {
return dao.findAll();
}
public List<Address> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Address create(Address item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Address> create(List<Address> items) {
List<Address> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Address update(Address item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Address> update(List<Address> items) {
List<Address> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Address item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Address item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Address> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Address item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByCountryId(Long id){
if (id == null) return 0;
List<Address> found = findByCountryId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByCountryId(id);
}
@Override
public List<Address> findByCountryId(Long id){
return dao.findByCountryId(id);
}
//----------------------------------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Address item) {
deleteAssociatedObjects(item);
}
public void deleteAssociatedObjects(Address item) {
fournisseurService.deleteByAddressId(item.getId());
clientService.deleteByAddressId(item.getId());
employeService.deleteByAddressId(item.getId());
entrepriseService.deleteByAddressId(item.getId());
}
//----------------------------------------------------------
@Autowired private AddressDao dao;
@Lazy @Autowired private CountryService countryService;
@Lazy @Autowired private FournisseurService fournisseurService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EmployeService employeService;
@Lazy @Autowired private EntrepriseService entrepriseService;
}