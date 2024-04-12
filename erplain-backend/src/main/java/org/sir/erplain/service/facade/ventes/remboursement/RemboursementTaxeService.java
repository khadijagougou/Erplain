package org.sir.erplain.service.facade.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface RemboursementTaxeService {
RemboursementTaxe findById(Long id);
List<RemboursementTaxe> findAllOptimized();
List<RemboursementTaxe> findAll();
RemboursementTaxe create(RemboursementTaxe item);
List<RemboursementTaxe> create(List<RemboursementTaxe> item);
RemboursementTaxe update(RemboursementTaxe item);
List<RemboursementTaxe> update(List<RemboursementTaxe> item);
void deleteById(Long id);
void delete(RemboursementTaxe item);
void delete(List<RemboursementTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByRemboursementId(Long id);
List<RemboursementTaxe> findByRemboursementId(Long id);
int deleteByTaxeId(Long id);
List<RemboursementTaxe> findByTaxeId(Long id);
}