package org.sir.erplain.service.impl.contacts;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.dao.contacts.ClientTaxeDao;
import org.sir.erplain.service.facade.contacts.ClientTaxeService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
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
public class ClientTaxeServiceImpl implements ClientTaxeService {
//--------------- FIND -------------------------------------
public ClientTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<ClientTaxe> findAll() {
return dao.findAll();
}
public List<ClientTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public ClientTaxe create(ClientTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<ClientTaxe> create(List<ClientTaxe> items) {
List<ClientTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public ClientTaxe update(ClientTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<ClientTaxe> update(List<ClientTaxe> items) {
List<ClientTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
ClientTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(ClientTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<ClientTaxe> items) {
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
public int deleteByClientId(Long id){
if (id == null) return 0;
return dao.deleteByClientId(id);
}
@Override
public List<ClientTaxe> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<ClientTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private ClientTaxeDao dao;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private TaxeService taxeService;
}