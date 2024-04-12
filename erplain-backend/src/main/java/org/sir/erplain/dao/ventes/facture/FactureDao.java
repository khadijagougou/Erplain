package org.sir.erplain.dao.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface FactureDao extends JpaRepository<Facture, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByPaiementId(Long id);
Facture findByPaiementId(Long id);
int deleteByClientId(Long id);
List<Facture> findByClientId(Long id);
int deleteByEntrepriseId(Long id);
List<Facture> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Facture> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Facture> findByNiveauPrixId(Long id);
}