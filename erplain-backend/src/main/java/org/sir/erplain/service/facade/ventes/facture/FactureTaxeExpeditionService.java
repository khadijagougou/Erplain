package org.sir.erplain.service.facade.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import java.util.List;
public interface FactureTaxeExpeditionService {
FactureTaxeExpedition findById(Long id);
List<FactureTaxeExpedition> findAllOptimized();
List<FactureTaxeExpedition> findAll();
FactureTaxeExpedition create(FactureTaxeExpedition item);
List<FactureTaxeExpedition> create(List<FactureTaxeExpedition> item);
FactureTaxeExpedition update(FactureTaxeExpedition item);
List<FactureTaxeExpedition> update(List<FactureTaxeExpedition> item);
void deleteById(Long id);
void delete(FactureTaxeExpedition item);
void delete(List<FactureTaxeExpedition> items);
void deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
List<FactureTaxeExpedition> findByFactureId(Long id);
int deleteByTaxeId(Long id);
List<FactureTaxeExpedition> findByTaxeId(Long id);
}