package org.sir.erplain.dao.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface BonCommandeProduitDao extends JpaRepository<BonCommandeProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByBonCommandeId(Long id);
List<BonCommandeProduit> findByBonCommandeId(Long id);
}