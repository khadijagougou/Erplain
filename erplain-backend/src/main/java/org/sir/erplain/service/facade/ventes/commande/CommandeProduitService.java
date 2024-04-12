package org.sir.erplain.service.facade.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeProduit;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import java.util.List;
public interface CommandeProduitService {
CommandeProduit findById(Long id);
List<CommandeProduit> findAllOptimized();
List<CommandeProduit> findAll();
CommandeProduit create(CommandeProduit item);
List<CommandeProduit> create(List<CommandeProduit> item);
CommandeProduit update(CommandeProduit item);
List<CommandeProduit> update(List<CommandeProduit> item);
void deleteById(Long id);
void delete(CommandeProduit item);
void delete(List<CommandeProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeProduit> findByCommandeId(Long id);
}