package org.sir.erplain.dao.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface RemboursementTaxeDao extends JpaRepository<RemboursementTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByRemboursementId(Long id);
List<RemboursementTaxe> findByRemboursementId(Long id);
int deleteByTaxeId(Long id);
List<RemboursementTaxe> findByTaxeId(Long id);
}