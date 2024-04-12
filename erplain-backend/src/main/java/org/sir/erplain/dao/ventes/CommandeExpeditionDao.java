package org.sir.erplain.dao.ventes;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CommandeExpeditionDao extends JpaRepository<CommandeExpedition, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeExpedition> findByCommandeId(Long id);
int deleteByEntrepriseId(Long id);
List<CommandeExpedition> findByEntrepriseId(Long id);
}