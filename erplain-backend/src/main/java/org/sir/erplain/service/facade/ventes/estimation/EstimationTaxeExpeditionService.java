package org.sir.erplain.service.facade.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface EstimationTaxeExpeditionService {
EstimationTaxeExpedition findById(Long id);
List<EstimationTaxeExpedition> findAllOptimized();
List<EstimationTaxeExpedition> findAll();
EstimationTaxeExpedition create(EstimationTaxeExpedition item);
List<EstimationTaxeExpedition> create(List<EstimationTaxeExpedition> item);
EstimationTaxeExpedition update(EstimationTaxeExpedition item);
List<EstimationTaxeExpedition> update(List<EstimationTaxeExpedition> item);
void deleteById(Long id);
void delete(EstimationTaxeExpedition item);
void delete(List<EstimationTaxeExpedition> items);
void deleteByIdIn(List<Long> ids);
int deleteByEstimationId(Long id);
List<EstimationTaxeExpedition> findByEstimationId(Long id);
int deleteByTaxeId(Long id);
List<EstimationTaxeExpedition> findByTaxeId(Long id);
}