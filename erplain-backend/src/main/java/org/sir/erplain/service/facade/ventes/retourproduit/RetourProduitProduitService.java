package org.sir.erplain.service.facade.ventes.retourproduit;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduitProduit;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import java.util.List;
public interface RetourProduitProduitService {
RetourProduitProduit findById(Long id);
List<RetourProduitProduit> findAllOptimized();
List<RetourProduitProduit> findAll();
RetourProduitProduit create(RetourProduitProduit item);
List<RetourProduitProduit> create(List<RetourProduitProduit> item);
RetourProduitProduit update(RetourProduitProduit item);
List<RetourProduitProduit> update(List<RetourProduitProduit> item);
void deleteById(Long id);
void delete(RetourProduitProduit item);
void delete(List<RetourProduitProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByRetourProduitId(Long id);
List<RetourProduitProduit> findByRetourProduitId(Long id);
}