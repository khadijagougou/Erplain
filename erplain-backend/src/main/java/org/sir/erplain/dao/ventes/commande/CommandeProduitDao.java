package org.sir.erplain.dao.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CommandeProduitDao extends JpaRepository<CommandeProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeProduit> findByCommandeId(Long id);
}