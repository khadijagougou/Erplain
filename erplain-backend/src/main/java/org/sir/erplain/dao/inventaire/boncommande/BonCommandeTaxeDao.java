package org.sir.erplain.dao.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface BonCommandeTaxeDao extends JpaRepository<BonCommandeTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByBonCommandeId(Long id);
List<BonCommandeTaxe> findByBonCommandeId(Long id);
int deleteByTaxeId(Long id);
List<BonCommandeTaxe> findByTaxeId(Long id);
}