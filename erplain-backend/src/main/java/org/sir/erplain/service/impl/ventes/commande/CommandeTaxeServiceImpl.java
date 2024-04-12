package org.sir.erplain.service.impl.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.sir.erplain.dao.ventes.commande.CommandeTaxeDao;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
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
public class CommandeTaxeServiceImpl implements CommandeTaxeService {
//--------------- FIND -------------------------------------
public CommandeTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<CommandeTaxe> findAll() {
return dao.findAll();
}
public List<CommandeTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeTaxe create(CommandeTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeTaxe> create(List<CommandeTaxe> items) {
List<CommandeTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeTaxe update(CommandeTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeTaxe> update(List<CommandeTaxe> items) {
List<CommandeTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
CommandeTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(CommandeTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<CommandeTaxe> items) {
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
public int deleteByCommandeId(Long id){
if (id == null) return 0;
return dao.deleteByCommandeId(id);
}
@Override
public List<CommandeTaxe> findByCommandeId(Long id){
return dao.findByCommandeId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<CommandeTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private CommandeTaxeDao dao;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private TaxeService taxeService;
}