package org.sir.erplain.dao.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CommandeTaxeDao extends JpaRepository<CommandeTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeTaxe> findByCommandeId(Long id);
int deleteByTaxeId(Long id);
List<CommandeTaxe> findByTaxeId(Long id);
}