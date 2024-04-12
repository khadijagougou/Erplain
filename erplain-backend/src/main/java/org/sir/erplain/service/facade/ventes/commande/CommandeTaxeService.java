package org.sir.erplain.service.facade.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface CommandeTaxeService {
CommandeTaxe findById(Long id);
List<CommandeTaxe> findAllOptimized();
List<CommandeTaxe> findAll();
CommandeTaxe create(CommandeTaxe item);
List<CommandeTaxe> create(List<CommandeTaxe> item);
CommandeTaxe update(CommandeTaxe item);
List<CommandeTaxe> update(List<CommandeTaxe> item);
void deleteById(Long id);
void delete(CommandeTaxe item);
void delete(List<CommandeTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByCommandeId(Long id);
List<CommandeTaxe> findByCommandeId(Long id);
int deleteByTaxeId(Long id);
List<CommandeTaxe> findByTaxeId(Long id);
}