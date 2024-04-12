package org.sir.erplain.dao.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface NoteCreditTaxeDao extends JpaRepository<NoteCreditTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByNoteCreditId(Long id);
List<NoteCreditTaxe> findByNoteCreditId(Long id);
int deleteByTaxeId(Long id);
List<NoteCreditTaxe> findByTaxeId(Long id);
}