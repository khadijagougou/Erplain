package org.sir.erplain.dao.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface NoteCreditProduitDao extends JpaRepository<NoteCreditProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByNoteCreditId(Long id);
List<NoteCreditProduit> findByNoteCreditId(Long id);
}