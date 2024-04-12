package org.sir.erplain.service.impl.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.sir.erplain.dao.ventes.commande.CommandeProduitDao;
import org.sir.erplain.service.facade.ventes.commande.CommandeProduitService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class CommandeProduitServiceImpl implements CommandeProduitService {
//--------------- FIND -------------------------------------
public CommandeProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<CommandeProduit> findAll() {
return dao.findAll();
}
public List<CommandeProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeProduit create(CommandeProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeProduit> create(List<CommandeProduit> items) {
List<CommandeProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeProduit update(CommandeProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeProduit> update(List<CommandeProduit> items) {
List<CommandeProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
CommandeProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(CommandeProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<CommandeProduit> items) {
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
public List<CommandeProduit> findByCommandeId(Long id){
return dao.findByCommandeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private CommandeProduitDao dao;
@Lazy @Autowired private CommandeService commandeService;
}