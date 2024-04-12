package org.sir.erplain.dao.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface BonCommandeTaxeExpeditionDao extends JpaRepository<BonCommandeTaxeExpedition, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByBonCommandeId(Long id);
List<BonCommandeTaxeExpedition> findByBonCommandeId(Long id);
int deleteByTaxeId(Long id);
List<BonCommandeTaxeExpedition> findByTaxeId(Long id);
}