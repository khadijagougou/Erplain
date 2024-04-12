package org.sir.erplain.dao.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface RemboursementProduitDao extends JpaRepository<RemboursementProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByRemboursementId(Long id);
List<RemboursementProduit> findByRemboursementId(Long id);
}