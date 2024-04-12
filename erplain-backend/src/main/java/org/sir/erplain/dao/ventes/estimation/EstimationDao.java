package org.sir.erplain.dao.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EstimationDao extends JpaRepository<Estimation, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
Estimation findByFactureId(Long id);
int deleteByClientId(Long id);
List<Estimation> findByClientId(Long id);
int deleteByEntrepriseId(Long id);
List<Estimation> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Estimation> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Estimation> findByNiveauPrixId(Long id);
}