package org.sir.erplain.service.facade.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface CommandeTaxeExpeditionService {
CommandeTaxeExpedition findById(Long id);
List<CommandeTaxeExpedition> findAllOptimized();
List<CommandeTaxeExpedition> findAll();
CommandeTaxeExpedition create(CommandeTaxeExpedition item);
List<CommandeTaxeExpedition> create(List<CommandeTaxeExpedition> item);
CommandeTaxeExpedition update(CommandeTaxeExpedition item);
List<CommandeTaxeExpedition> update(List<CommandeTaxeExpedition> item);
void deleteById(Long id);
void delete(CommandeTaxeExpedition item);
void delete(List<CommandeTaxeExpedition> items);
void deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeTaxeExpedition> findByCommandeId(Long id);
int deleteByTaxeId(Long id);
List<CommandeTaxeExpedition> findByTaxeId(Long id);
}