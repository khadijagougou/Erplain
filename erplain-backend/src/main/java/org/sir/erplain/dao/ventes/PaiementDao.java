package org.sir.erplain.dao.ventes;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface PaiementDao extends JpaRepository<Paiement, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByMethodePaiementId(Long id);
List<Paiement> findByMethodePaiementId(Long id);
int deleteByEntrepriseId(Long id);
List<Paiement> findByEntrepriseId(Long id);
}