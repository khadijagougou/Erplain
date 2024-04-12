package org.sir.erplain.service.facade.ventes;
import org.sir.erplain.bean.core.ventes.CommandeExpedition;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import java.util.List;
public interface CommandeExpeditionService {
CommandeExpedition findById(Long id);
List<CommandeExpedition> findAllOptimized();
List<CommandeExpedition> findAll();
CommandeExpedition create(CommandeExpedition item);
List<CommandeExpedition> create(List<CommandeExpedition> item);
CommandeExpedition update(CommandeExpedition item);
List<CommandeExpedition> update(List<CommandeExpedition> item);
void deleteById(Long id);
void delete(CommandeExpedition item);
void delete(List<CommandeExpedition> items);
void deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeExpedition> findByCommandeId(Long id);
int deleteByEntrepriseId(Long id);
List<CommandeExpedition> findByEntrepriseId(Long id);
}