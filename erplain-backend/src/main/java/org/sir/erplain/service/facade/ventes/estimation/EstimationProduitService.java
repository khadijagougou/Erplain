package org.sir.erplain.service.facade.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import java.util.List;
public interface EstimationProduitService {
EstimationProduit findById(Long id);
List<EstimationProduit> findAllOptimized();
List<EstimationProduit> findAll();
EstimationProduit create(EstimationProduit item);
List<EstimationProduit> create(List<EstimationProduit> item);
EstimationProduit update(EstimationProduit item);
List<EstimationProduit> update(List<EstimationProduit> item);
void deleteById(Long id);
void delete(EstimationProduit item);
void delete(List<EstimationProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByEstimationId(Long id);
List<EstimationProduit> findByEstimationId(Long id);
}