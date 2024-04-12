package org.sir.erplain.service.facade.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import java.util.List;
public interface BonCommandeProduitService {
BonCommandeProduit findById(Long id);
List<BonCommandeProduit> findAllOptimized();
List<BonCommandeProduit> findAll();
BonCommandeProduit create(BonCommandeProduit item);
List<BonCommandeProduit> create(List<BonCommandeProduit> item);
BonCommandeProduit update(BonCommandeProduit item);
List<BonCommandeProduit> update(List<BonCommandeProduit> item);
void deleteById(Long id);
void delete(BonCommandeProduit item);
void delete(List<BonCommandeProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByBonCommandeId(Long id);
List<BonCommandeProduit> findByBonCommandeId(Long id);
}