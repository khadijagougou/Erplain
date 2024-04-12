package org.sir.erplain.service.facade.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import java.util.List;
public interface RemboursementProduitService {
RemboursementProduit findById(Long id);
List<RemboursementProduit> findAllOptimized();
List<RemboursementProduit> findAll();
RemboursementProduit create(RemboursementProduit item);
List<RemboursementProduit> create(List<RemboursementProduit> item);
RemboursementProduit update(RemboursementProduit item);
List<RemboursementProduit> update(List<RemboursementProduit> item);
void deleteById(Long id);
void delete(RemboursementProduit item);
void delete(List<RemboursementProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByRemboursementId(Long id);
List<RemboursementProduit> findByRemboursementId(Long id);
}