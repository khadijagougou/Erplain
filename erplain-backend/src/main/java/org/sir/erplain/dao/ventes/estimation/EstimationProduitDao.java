package org.sir.erplain.dao.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EstimationProduitDao extends JpaRepository<EstimationProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByEstimationId(Long id);
List<EstimationProduit> findByEstimationId(Long id);
}