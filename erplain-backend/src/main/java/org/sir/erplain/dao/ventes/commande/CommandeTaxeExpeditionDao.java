package org.sir.erplain.dao.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CommandeTaxeExpeditionDao extends JpaRepository<CommandeTaxeExpedition, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeTaxeExpedition> findByCommandeId(Long id);
int deleteByTaxeId(Long id);
List<CommandeTaxeExpedition> findByTaxeId(Long id);
}