package org.sir.erplain.service.impl.ventes;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.dao.ventes.CommandeExpeditionDao;
import org.sir.erplain.service.facade.ventes.CommandeExpeditionService;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.service.facade.ventes.commande.CommandeService;
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
public class CommandeExpeditionServiceImpl implements CommandeExpeditionService {
//--------------- FIND -------------------------------------
public CommandeExpedition findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<CommandeExpedition> findAll() {
return dao.findAll();
}
public List<CommandeExpedition> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeExpedition create(CommandeExpedition item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeExpedition> create(List<CommandeExpedition> items) {
List<CommandeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public CommandeExpedition update(CommandeExpedition item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<CommandeExpedition> update(List<CommandeExpedition> items) {
List<CommandeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
CommandeExpedition item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(CommandeExpedition item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<CommandeExpedition> items) {
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
public List<CommandeExpedition> findByCommandeId(Long id){
return dao.findByCommandeId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
return dao.deleteByEntrepriseId(id);
}
@Override
public List<CommandeExpedition> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private CommandeExpeditionDao dao;
@Lazy @Autowired private CommandeService commandeService;
@Lazy @Autowired private EntrepriseService entrepriseService;
}