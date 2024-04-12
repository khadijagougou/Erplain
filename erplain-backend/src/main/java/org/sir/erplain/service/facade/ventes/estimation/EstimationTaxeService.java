package org.sir.erplain.service.facade.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface EstimationTaxeService {
EstimationTaxe findById(Long id);
List<EstimationTaxe> findAllOptimized();
List<EstimationTaxe> findAll();
EstimationTaxe create(EstimationTaxe item);
List<EstimationTaxe> create(List<EstimationTaxe> item);
EstimationTaxe update(EstimationTaxe item);
List<EstimationTaxe> update(List<EstimationTaxe> item);
void deleteById(Long id);
void delete(EstimationTaxe item);
void delete(List<EstimationTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByEstimationId(Long id);
List<EstimationTaxe> findByEstimationId(Long id);
int deleteByTaxeId(Long id);
List<EstimationTaxe> findByTaxeId(Long id);
}