package org.sir.erplain.service.facade.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface BonCommandeTaxeExpeditionService {
BonCommandeTaxeExpedition findById(Long id);
List<BonCommandeTaxeExpedition> findAllOptimized();
List<BonCommandeTaxeExpedition> findAll();
BonCommandeTaxeExpedition create(BonCommandeTaxeExpedition item);
List<BonCommandeTaxeExpedition> create(List<BonCommandeTaxeExpedition> item);
BonCommandeTaxeExpedition update(BonCommandeTaxeExpedition item);
List<BonCommandeTaxeExpedition> update(List<BonCommandeTaxeExpedition> item);
void deleteById(Long id);
void delete(BonCommandeTaxeExpedition item);
void delete(List<BonCommandeTaxeExpedition> items);
void deleteByIdIn(List<Long> ids);
int deleteByBonCommandeId(Long id);
List<BonCommandeTaxeExpedition> findByBonCommandeId(Long id);
int deleteByTaxeId(Long id);
List<BonCommandeTaxeExpedition> findByTaxeId(Long id);
}