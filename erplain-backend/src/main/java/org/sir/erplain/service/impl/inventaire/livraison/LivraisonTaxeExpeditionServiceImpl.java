package org.sir.erplain.service.impl.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.dao.inventaire.livraison.LivraisonTaxeExpeditionDao;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonTaxeExpeditionService;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
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
public class LivraisonTaxeExpeditionServiceImpl implements LivraisonTaxeExpeditionService {
//--------------- FIND -------------------------------------
public LivraisonTaxeExpedition findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<LivraisonTaxeExpedition> findAll() {
return dao.findAll();
}
public List<LivraisonTaxeExpedition> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public LivraisonTaxeExpedition create(LivraisonTaxeExpedition item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<LivraisonTaxeExpedition> create(List<LivraisonTaxeExpedition> items) {
List<LivraisonTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public LivraisonTaxeExpedition update(LivraisonTaxeExpedition item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<LivraisonTaxeExpedition> update(List<LivraisonTaxeExpedition> items) {
List<LivraisonTaxeExpedition> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
LivraisonTaxeExpedition item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(LivraisonTaxeExpedition item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<LivraisonTaxeExpedition> items) {
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
public int deleteByLivraisonId(Long id){
if (id == null) return 0;
return dao.deleteByLivraisonId(id);
}
@Override
public List<LivraisonTaxeExpedition> findByLivraisonId(Long id){
return dao.findByLivraisonId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<LivraisonTaxeExpedition> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private LivraisonTaxeExpeditionDao dao;
@Lazy @Autowired private LivraisonService livraisonService;
@Lazy @Autowired private TaxeService taxeService;
}