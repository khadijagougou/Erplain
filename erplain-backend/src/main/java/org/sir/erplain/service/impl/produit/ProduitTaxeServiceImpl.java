package org.sir.erplain.service.impl.produit;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.dao.produit.ProduitTaxeDao;
import org.sir.erplain.service.facade.produit.ProduitTaxeService;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.service.facade.produit.ProduitService;
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
public class ProduitTaxeServiceImpl implements ProduitTaxeService {
//--------------- FIND -------------------------------------
public ProduitTaxe findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<ProduitTaxe> findAll() {
return dao.findAll();
}
public List<ProduitTaxe> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public ProduitTaxe create(ProduitTaxe item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<ProduitTaxe> create(List<ProduitTaxe> items) {
List<ProduitTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public ProduitTaxe update(ProduitTaxe item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<ProduitTaxe> update(List<ProduitTaxe> items) {
List<ProduitTaxe> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
ProduitTaxe item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(ProduitTaxe item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<ProduitTaxe> items) {
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
public int deleteByProduitId(Long id){
if (id == null) return 0;
return dao.deleteByProduitId(id);
}
@Override
public List<ProduitTaxe> findByProduitId(Long id){
return dao.findByProduitId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByTaxeId(Long id){
if (id == null) return 0;
return dao.deleteByTaxeId(id);
}
@Override
public List<ProduitTaxe> findByTaxeId(Long id){
return dao.findByTaxeId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private ProduitTaxeDao dao;
@Lazy @Autowired private ProduitService produitService;
@Lazy @Autowired private TaxeService taxeService;
}