package org.sir.erplain.service.impl.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.dao.ventes.commande.CommandeTaxeExpeditionDao;
import org.sir.erplain.service.facade.ventes.commande.CommandeTaxeExpeditionService;
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
public class CommandeTaxeExpeditionServiceImpl implements CommandeTaxeExpeditionService {
//--------------- FIND -------------------------------------
public CommandeTaxeExpedition findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<CommandeTaxeExpedition> findAll() {
return dao.findAll();
}
public List<CommandeTaxeExpedition> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeTaxeExpedition create(CommandeTaxeExpedition item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeTaxeExpedition> create(List<CommandeTaxeExpedition> items) {
List<CommandeTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeTaxeExpedition update(CommandeTaxeExpedition item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeTaxeExpedition> update(List<CommandeTaxeExpedition> items) {
List<CommandeTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
CommandeTaxeExpedition item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(CommandeTaxeExpedition item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<CommandeTaxeExpedition> items) {
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
public List<CommandeTaxeExpedition> findByCommandeId(Long id){
return dao.findByCommandeId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<CommandeTaxeExpedition> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private CommandeTaxeExpeditionDao dao;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private TaxeService taxeService;
}