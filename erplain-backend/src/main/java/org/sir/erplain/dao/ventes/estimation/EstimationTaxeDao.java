package org.sir.erplain.dao.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EstimationTaxeDao extends JpaRepository<EstimationTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByEstimationId(Long id);
List<EstimationTaxe> findByEstimationId(Long id);
int deleteByTaxeId(Long id);
List<EstimationTaxe> findByTaxeId(Long id);
}