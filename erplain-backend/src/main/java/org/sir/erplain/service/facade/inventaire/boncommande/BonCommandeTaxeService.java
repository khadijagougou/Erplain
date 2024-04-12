package org.sir.erplain.service.facade.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface BonCommandeTaxeService {
BonCommandeTaxe findById(Long id);
List<BonCommandeTaxe> findAllOptimized();
List<BonCommandeTaxe> findAll();
BonCommandeTaxe create(BonCommandeTaxe item);
List<BonCommandeTaxe> create(List<BonCommandeTaxe> item);
BonCommandeTaxe update(BonCommandeTaxe item);
List<BonCommandeTaxe> update(List<BonCommandeTaxe> item);
void deleteById(Long id);
void delete(BonCommandeTaxe item);
void delete(List<BonCommandeTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByBonCommandeId(Long id);
List<BonCommandeTaxe> findByBonCommandeId(Long id);
int deleteByTaxeId(Long id);
List<BonCommandeTaxe> findByTaxeId(Long id);
}