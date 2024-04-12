package org.sir.erplain.service.impl.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.sir.erplain.dao.inventaire.livraison.LivraisonProduitDao;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonProduitService;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.service.facade.inventaire.livraison.LivraisonService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class LivraisonProduitServiceImpl implements LivraisonProduitService {
//--------------- FIND -------------------------------------
public LivraisonProduit findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<LivraisonProduit> findAll() {
return dao.findAll();
}
public List<LivraisonProduit> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public LivraisonProduit create(LivraisonProduit item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<LivraisonProduit> create(List<LivraisonProduit> items) {
List<LivraisonProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public LivraisonProduit update(LivraisonProduit item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<LivraisonProduit> update(List<LivraisonProduit> items) {
List<LivraisonProduit> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
LivraisonProduit item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(LivraisonProduit item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<LivraisonProduit> items) {
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
public List<LivraisonProduit> findByLivraisonId(Long id){
return dao.findByLivraisonId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private LivraisonProduitDao dao;
@Lazy @Autowired private LivraisonService livraisonService;
}