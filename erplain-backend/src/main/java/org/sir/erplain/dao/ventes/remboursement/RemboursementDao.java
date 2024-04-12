package org.sir.erplain.dao.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface RemboursementDao extends JpaRepository<Remboursement, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<Remboursement> findByClientId(Long id);
int deleteByRetourProduitId(Long id);
List<Remboursement> findByRetourProduitId(Long id);
int deleteByEntrepriseId(Long id);
List<Remboursement> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Remboursement> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Remboursement> findByNiveauPrixId(Long id);
}