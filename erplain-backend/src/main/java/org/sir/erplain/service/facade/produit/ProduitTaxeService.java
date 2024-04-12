package org.sir.erplain.service.facade.produit;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.bean.core.produit.Produit;
import java.util.List;
public interface ProduitTaxeService {
ProduitTaxe findById(Long id);
List<ProduitTaxe> findAllOptimized();
List<ProduitTaxe> findAll();
ProduitTaxe create(ProduitTaxe item);
List<ProduitTaxe> create(List<ProduitTaxe> item);
ProduitTaxe update(ProduitTaxe item);
List<ProduitTaxe> update(List<ProduitTaxe> item);
void deleteById(Long id);
void delete(ProduitTaxe item);
void delete(List<ProduitTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByProduitId(Long id);
List<ProduitTaxe> findByProduitId(Long id);
int deleteByTaxeId(Long id);
List<ProduitTaxe> findByTaxeId(Long id);
}