package org.sir.erplain.dao.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EstimationTaxeExpeditionDao extends JpaRepository<EstimationTaxeExpedition, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByEstimationId(Long id);
List<EstimationTaxeExpedition> findByEstimationId(Long id);
int deleteByTaxeId(Long id);
List<EstimationTaxeExpedition> findByTaxeId(Long id);
}