package org.sir.erplain.dao.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface FactureProduitDao extends JpaRepository<FactureProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
List<FactureProduit> findByFactureId(Long id);
}